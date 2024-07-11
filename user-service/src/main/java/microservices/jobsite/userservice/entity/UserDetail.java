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
@Table(name = "user_detail")
@Entity
public class UserDetail {

    @Id
    @GeneratedValue
    @UuidGenerator
    private String id;

    private String name;

    private String picture;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String address;

    private String userId;

}
