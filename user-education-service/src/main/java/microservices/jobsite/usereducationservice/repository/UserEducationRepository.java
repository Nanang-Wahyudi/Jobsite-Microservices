package microservices.jobsite.usereducationservice.repository;

import microservices.jobsite.usereducationservice.entity.UserEducation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEducationRepository extends JpaRepository<UserEducation, String> {
}
