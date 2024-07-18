package microservices.jobsite.userservice.repository;

import microservices.jobsite.userservice.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetail, String> {
}
