package microservices.jobsite.authservice.repository;

import microservices.jobsite.authservice.entity.Role;
import microservices.jobsite.authservice.model.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

    Optional<Role> findByName(RoleEnum name);

}
