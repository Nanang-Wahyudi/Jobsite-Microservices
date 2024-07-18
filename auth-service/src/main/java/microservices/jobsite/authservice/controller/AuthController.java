package microservices.jobsite.authservice.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import microservices.jobsite.authservice.model.enums.RoleEnum;
import microservices.jobsite.authservice.model.request.RegisterRequest;
import microservices.jobsite.authservice.model.response.NoDataResponse;
import microservices.jobsite.authservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.concurrent.CompletableFuture;

@RequestMapping("/api")
@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/v1/auth/register-user")
    public CompletableFuture<ResponseEntity<NoDataResponse>> registerUser(HttpServletRequest servletRequest,
                                                                          @Valid @RequestBody RegisterRequest request) {
        return authService.register(request, RoleEnum.USER)
                .thenApply(result -> {
                    NoDataResponse response = NoDataResponse.builder()
                            .url(servletRequest.getRequestURI())
                            .status(HttpStatus.OK.toString())
                            .message("User Registered Successfully")
                            .build();
                    response.setTimestamp(new Date());
                    return ResponseEntity.ok(response);
                })
                .exceptionally(ex -> {
                    ex.printStackTrace();
                    NoDataResponse errorResponse = NoDataResponse.builder()
                            .url(servletRequest.getRequestURI())
                            .status(HttpStatus.INTERNAL_SERVER_ERROR.toString())
                            .message("Error User Registering: " + ex.getMessage())
                            .build();
                    errorResponse.setTimestamp(new Date());
                    return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
                });
    }

    @PostMapping("/v1/auth/register-admin")
    public CompletableFuture<ResponseEntity<NoDataResponse>> registerAdmin(HttpServletRequest servletRequest,
                                                                           @Valid @RequestBody RegisterRequest request) {
        return authService.register(request, RoleEnum.ADMIN)
                .thenApply(result -> {
                    NoDataResponse response = NoDataResponse.builder()
                            .url(servletRequest.getRequestURI())
                            .status(HttpStatus.OK.toString())
                            .message("Admin Registered Successfully")
                            .build();
                    response.setTimestamp(new Date());
                    return ResponseEntity.ok(response);
                })
                .exceptionally(ex -> {
                    ex.printStackTrace();
                    NoDataResponse errorResponse = NoDataResponse.builder()
                            .url(servletRequest.getRequestURI())
                            .status(HttpStatus.INTERNAL_SERVER_ERROR.toString())
                            .message("Error Admin Registering: " + ex.getMessage())
                            .build();
                    errorResponse.setTimestamp(new Date());
                    return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
                });
    }

    @PostMapping("/v1/auth/register-company")
    public CompletableFuture<ResponseEntity<NoDataResponse>> registerCompany(HttpServletRequest servletRequest,
                                                                             @Valid @RequestBody RegisterRequest request) {
        return authService.register(request, RoleEnum.COMPANY)
                .thenApply(result -> {
                    NoDataResponse response = NoDataResponse.builder()
                            .url(servletRequest.getRequestURI())
                            .status(HttpStatus.OK.toString())
                            .message("Company Registered Successfully")
                            .build();
                    response.setTimestamp(new Date());
                    return ResponseEntity.ok(response);
                })
                .exceptionally(ex -> {
                    ex.printStackTrace();
                    NoDataResponse errorResponse = NoDataResponse.builder()
                            .url(servletRequest.getRequestURI())
                            .status(HttpStatus.INTERNAL_SERVER_ERROR.toString())
                            .message("Error Company Registering: " + ex.getMessage())
                            .build();
                    errorResponse.setTimestamp(new Date());
                    return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
                });
    }

}
