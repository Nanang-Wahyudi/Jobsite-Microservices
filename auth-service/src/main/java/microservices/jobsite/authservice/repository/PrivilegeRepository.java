package microservices.jobsite.authservice.repository;

import microservices.jobsite.authservice.entity.Privilege;
import microservices.jobsite.authservice.model.enums.PrivilegeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, String> {

    Optional<Privilege> findByName(PrivilegeEnum name);

}
