package microservices.jobsite.educationservice.entity;

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
@Table(name = "education")
@Entity
public class Education {

    @Id
    @GeneratedValue
    @UuidGenerator
    private String id;

    private String name;

    private String major;

    private String avgScore;

}
