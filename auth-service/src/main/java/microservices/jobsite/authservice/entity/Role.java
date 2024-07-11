package microservices.jobsite.authservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import microservices.jobsite.authservice.model.enums.RoleEnum;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "role")
@Entity
public class Role {

    @Id
    @GeneratedValue
    @UuidGenerator
    private String id;

    @Column(unique = true)
    @Enumerated(EnumType.STRING)
    private RoleEnum name;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "role_privilege",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "id")
    )
    List<Privilege> privileges;

}
