package microservices.jobsite.userskillservice.entity;

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
@Table(name = "user-skill")
@Entity
public class UserSkill {

    @Id
    @GeneratedValue
    @UuidGenerator
    private String id;

    private String userId;

    private String skillId;

}
