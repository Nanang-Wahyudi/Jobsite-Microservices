package microservices.jobsite.userservice.service;

import microservices.jobsite.userservice.model.request.CreateUserDetailAndCompanyRequest;
import microservices.jobsite.userservice.model.request.UpdateUserDetailRequest;

public interface UserDetailService {

    void createUserDetail(CreateUserDetailAndCompanyRequest userDetailRequest);

    void updateUserDetail(String id, UpdateUserDetailRequest userDetailRequest);

}
