package microservices.jobsite.userservice.controller;

import jakarta.servlet.http.HttpServletRequest;
import microservices.jobsite.userservice.model.request.CreateUserDetailAndCompanyRequest;
import microservices.jobsite.userservice.model.response.NoDataResponse;
import microservices.jobsite.userservice.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RequestMapping("/api")
@RestController
public class UserDetailController {

    @Autowired
    private UserDetailService userDetailService;

    @PostMapping("/v1/user-detail/create")
    public ResponseEntity<?> createUserDetail(HttpServletRequest servletRequest,
                                              @RequestBody CreateUserDetailAndCompanyRequest request) {
        try {
            userDetailService.createUserDetail(request);
            NoDataResponse response = NoDataResponse.builder()
                    .url(servletRequest.getRequestURI())
                    .status(HttpStatus.OK.toString())
                    .message("User Detail created successfully")
                    .build();
            response.setTimestamp(new Date());
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            ex.printStackTrace();
            NoDataResponse response = NoDataResponse.builder()
                    .url(servletRequest.getRequestURI())
                    .status(HttpStatus.INTERNAL_SERVER_ERROR.toString())
                    .message("Error creating User Detail: " + ex.getMessage())
                    .build();
            response.setTimestamp(new Date());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
