package microservices.jobsite.userservice.service;

import microservices.jobsite.userservice.model.request.CreateUserDetailAndCompanyRequest;

public interface CompanyService {

    void createCompany(CreateUserDetailAndCompanyRequest companyRequest);

}
