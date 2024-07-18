package microservices.jobsite.userservice.service;

import microservices.jobsite.userservice.entity.Company;
import microservices.jobsite.userservice.model.request.CreateUserDetailAndCompanyRequest;
import microservices.jobsite.userservice.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public void createCompany(CreateUserDetailAndCompanyRequest companyRequest) {
        Company company = Company.builder()
                .name(companyRequest.getName())
                .userId(companyRequest.getUserId())
                .build();
        companyRepository.save(company);
    }

}
