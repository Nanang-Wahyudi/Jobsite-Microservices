package microservices.jobsite.authservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="\"user\"")
@Entity
public class User {

    @Id
    @GeneratedValue
    @UuidGenerator
    private String id;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    private String password;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private List<Role> roles;

}
