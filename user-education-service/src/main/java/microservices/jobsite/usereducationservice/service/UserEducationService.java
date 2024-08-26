package microservices.jobsite.usereducationservice.service;

import microservices.jobsite.usereducationservice.model.request.UpdateUserDetailCreateEducationRequest;

public interface UserEducationService {

    void updateUserDetailCreateEducation(String id, UpdateUserDetailCreateEducationRequest request);

}
