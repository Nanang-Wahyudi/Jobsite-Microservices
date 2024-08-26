package microservices.jobsite.usereducationservice.client;

import microservices.jobsite.usereducationservice.model.request.clientRequest.UpdateUserDetailCreateEducationClientRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "education-service",
        url = "${application.config.education-url}")
public interface EducationClient {

    @PostMapping("/v1/education/create")
    String createEducation(@RequestBody UpdateUserDetailCreateEducationClientRequest request);

}
