package microservices.jobsite.usereducationservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "user-education")
@Entity
public class UserEducation {

    @Id
    @GeneratedValue
    @UuidGenerator
    private String id;

    private String userId;

    private String educationId;

}
