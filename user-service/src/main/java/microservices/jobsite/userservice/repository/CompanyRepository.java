package microservices.jobsite.userservice.repository;

import microservices.jobsite.userservice.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {
}
