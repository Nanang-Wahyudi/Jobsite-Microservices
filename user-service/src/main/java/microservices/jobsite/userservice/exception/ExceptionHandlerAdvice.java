package microservices.jobsite.userservice.exception;

import microservices.jobsite.userservice.model.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(ResponseStatusException.class)
    protected ResponseEntity<Object> handleResponseStatusException(ResponseStatusException ex, WebRequest request) {
        Map<String, Object> details = new HashMap<>();

        String message = ex.getReason();
        if (message != null) {
            details.put("message", message);
        } else {
            details.put("message", ex.getMessage());
        }

        ErrorResponse errorResponse = ErrorResponse.builder()
                .url(request.getDescription(false).replace("uri=", ""))
                .status(ex.getStatusCode().toString())
                .details(details)
                .build();
        errorResponse.setTimestamp(new Date());

        return new ResponseEntity<>(errorResponse, ex.getStatusCode());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Object> handleInvalidArgument(MethodArgumentNotValidException ex, WebRequest request) {
        Map<String, String> details = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            details.put(error.getField(), error.getDefaultMessage());
        });

        ErrorResponse errorResponse = ErrorResponse.builder()
                .url(request.getDescription(false).replace("uri=", ""))
                .status(HttpStatus.BAD_REQUEST.toString())
                .details(details)
                .build();
        errorResponse.setTimestamp(new Date());

        return ResponseEntity.ok(errorResponse);
    }

}
