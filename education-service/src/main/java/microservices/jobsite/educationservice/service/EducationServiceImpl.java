package microservices.jobsite.educationservice.service;

import microservices.jobsite.educationservice.entity.Education;
import microservices.jobsite.educationservice.model.request.CreateEducationRequest;
import microservices.jobsite.educationservice.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationServiceImpl implements EducationService {

    @Autowired
    private EducationRepository educationRepository;

    @Override
    public String createEducation(CreateEducationRequest request) {
        Education education = Education.builder()
                .name(request.getInstitutionName())
                .major(request.getMajor())
                .avgScore(request.getAvgScore())
                .build();
        Education saveEducation = educationRepository.save(education);
        return saveEducation.getId();
    }

}
