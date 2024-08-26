package microservices.jobsite.educationservice.service;

import microservices.jobsite.educationservice.model.request.CreateEducationRequest;

public interface EducationService {

    String createEducation(CreateEducationRequest request);

}
