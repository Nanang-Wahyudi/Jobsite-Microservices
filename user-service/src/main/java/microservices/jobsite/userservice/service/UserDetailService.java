package microservices.jobsite.userservice.service;

import microservices.jobsite.userservice.model.request.CreateUserDetailAndCompanyRequest;

public interface UserDetailService {

    void createUserDetail(CreateUserDetailAndCompanyRequest userDetailRequest);

}
