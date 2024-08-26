package microservices.jobsite.usereducationservice.controller;

import jakarta.servlet.http.HttpServletRequest;
import microservices.jobsite.usereducationservice.model.request.UpdateUserDetailCreateEducationRequest;
import microservices.jobsite.usereducationservice.model.response.NoDataResponse;
import microservices.jobsite.usereducationservice.service.UserEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RequestMapping("/api")
@RestController
public class UserEducationController {

    @Autowired
    private UserEducationService userEducationService;

    @PutMapping("/v2/user-detail/update/{id}")
    public ResponseEntity<?> updateUserDetailCreateEducation(HttpServletRequest servletRequest,
                                                             @PathVariable String  id,
                                                             @RequestBody UpdateUserDetailCreateEducationRequest request) {
        try {
            userEducationService.updateUserDetailCreateEducation(id, request);
            NoDataResponse response = NoDataResponse.builder()
                    .url(servletRequest.getRequestURI())
                    .status(HttpStatus.OK.toString())
                    .message("User Detail updated successfully")
                    .build();
            response.setTimestamp(new Date());
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            ex.printStackTrace();
            NoDataResponse response = NoDataResponse.builder()
                    .url(servletRequest.getRequestURI())
                    .status(HttpStatus.INTERNAL_SERVER_ERROR.toString())
                    .message("Error updating User Detail: " + ex.getMessage())
                    .build();
            response.setTimestamp(new Date());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
