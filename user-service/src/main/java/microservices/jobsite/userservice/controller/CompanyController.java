package microservices.jobsite.userservice.controller;

import jakarta.servlet.http.HttpServletRequest;
import microservices.jobsite.userservice.model.request.CreateUserDetailAndCompanyRequest;
import microservices.jobsite.userservice.model.response.NoDataResponse;
import microservices.jobsite.userservice.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RequestMapping("/api")
@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping("/v1/company/create")
    public ResponseEntity<?> createCompany(HttpServletRequest servletRequest,
                                           @RequestBody CreateUserDetailAndCompanyRequest companyRequest) {
        try {
            companyService.createCompany(companyRequest);
            NoDataResponse response = NoDataResponse.builder()
                    .url(servletRequest.getRequestURI())
                    .status(HttpStatus.OK.toString())
                    .message("Company created successfully")
                    .build();
            response.setTimestamp(new Date());
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            ex.printStackTrace();
            NoDataResponse response = NoDataResponse.builder()
                    .url(servletRequest.getRequestURI())
                    .status(HttpStatus.INTERNAL_SERVER_ERROR.toString())
                    .message("Error creating Company: " + ex.getMessage())
                    .build();
            response.setTimestamp(new Date());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
