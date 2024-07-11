package microservices.jobsite.userservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "company")
@Entity
public class Company {

    @Id
    @GeneratedValue
    @UuidGenerator
    private String id;

    @Column(unique = true)
    private String name;

    private String picture;

    private String banner;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String address;

    private String userId;

}
