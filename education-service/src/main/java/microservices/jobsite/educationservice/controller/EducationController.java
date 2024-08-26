package microservices.jobsite.educationservice.controller;

import jakarta.servlet.http.HttpServletRequest;
import microservices.jobsite.educationservice.model.request.CreateEducationRequest;
import microservices.jobsite.educationservice.model.response.NoDataResponse;
import microservices.jobsite.educationservice.model.response.WithDataResponse;
import microservices.jobsite.educationservice.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/api")
public class EducationController {

    @Autowired
    private EducationService educationService;

    @PostMapping("/v1/education/create")
    public ResponseEntity<?> createEducation(HttpServletRequest servletRequest,
                                             @RequestBody CreateEducationRequest request) {
        try {
            String educationId = educationService.createEducation(request);
            WithDataResponse<Object> response = WithDataResponse.builder()
                    .url(servletRequest.getRequestURI())
                    .status(HttpStatus.OK.toString())
                    .data(educationId)
                    .build();
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            ex.printStackTrace();
            NoDataResponse response = NoDataResponse.builder()
                    .url(servletRequest.getRequestURI())
                    .status(HttpStatus.INTERNAL_SERVER_ERROR.toString())
                    .message("Error creating Education: " + ex.getMessage())
                    .build();
            response.setTimestamp(new Date());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
