package microservices.jobsite.usereducationservice.service;

import microservices.jobsite.usereducationservice.client.EducationClient;
import microservices.jobsite.usereducationservice.client.UserDetailClient;
import microservices.jobsite.usereducationservice.entity.UserEducation;
import microservices.jobsite.usereducationservice.model.request.UpdateUserDetailCreateEducationRequest;
import microservices.jobsite.usereducationservice.model.request.clientRequest.UpdateUserDetailCreateEducationClientRequest;
import microservices.jobsite.usereducationservice.repository.UserEducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserEducationServiceImpl implements UserEducationService {

    @Autowired
    private UserEducationRepository userEducationRepository;

    @Autowired
    private UserDetailClient userDetailClient;

    @Autowired
    private EducationClient educationClient;

    @Override
    public void updateUserDetailCreateEducation(String id, UpdateUserDetailCreateEducationRequest request) {
        UpdateUserDetailCreateEducationClientRequest userDetailRequest = UpdateUserDetailCreateEducationClientRequest.builder()
                .name(request.getName())
                .address(request.getAddress())
                .picture(request.getPicture())
                .description(request.getDescription())
                .build();
        userDetailClient.updateUserDetail(id, userDetailRequest);

        if (request.getInstitutionName() != null && !request.getInstitutionName().isEmpty() &&
            request.getMajor() != null && !request.getMajor().isEmpty() &&
            request.getAvgScore() != null && !request.getAvgScore().isEmpty()) {

            UpdateUserDetailCreateEducationClientRequest educationRequest = UpdateUserDetailCreateEducationClientRequest.builder()
                    .institutionName(request.getInstitutionName())
                    .major(request.getMajor())
                    .avgScore(request.getAvgScore())
                    .build();
            String educationResponse = educationClient.createEducation(educationRequest);

            UserEducation userEducation = UserEducation.builder()
                    .userId(id)
                    .educationId(educationResponse)
                    .build();
            userEducationRepository.save(userEducation);
        }
    }
}
