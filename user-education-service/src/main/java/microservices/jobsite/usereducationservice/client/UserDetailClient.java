package microservices.jobsite.usereducationservice.client;

import microservices.jobsite.usereducationservice.model.request.clientRequest.UpdateUserDetailCreateEducationClientRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user-service",
        url = "${application.config.user-url}")
public interface UserDetailClient {

    @PutMapping("/v1/user-detail/update/{id}")
    void updateUserDetail(@PathVariable String id,
                                       @RequestBody UpdateUserDetailCreateEducationClientRequest request);

}
