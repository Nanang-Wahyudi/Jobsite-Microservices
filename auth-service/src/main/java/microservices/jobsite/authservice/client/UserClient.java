package microservices.jobsite.authservice.client;

import microservices.jobsite.authservice.model.request.CreateUserDetailAndCompanyRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user-service",
        url = "${application.config.user-url}")
public interface UserClient {

    @PostMapping("/v1/user-detail/create")
    void createUserDetail(@RequestBody CreateUserDetailAndCompanyRequest userDetailRequest);

    @PostMapping("/v1/company/create")
    void createCompany(@RequestBody CreateUserDetailAndCompanyRequest companyRequest);

}
