package microservices.jobsite.authservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import microservices.jobsite.authservice.model.enums.PrivilegeEnum;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "privilege")
@Entity
public class Privilege {

    @Id
    @GeneratedValue
    @UuidGenerator
    private String id;

    @Column(unique = true)
    @Enumerated(EnumType.STRING)
    private PrivilegeEnum name;


    @ManyToMany(mappedBy = "privileges")
    private List<Role> roles;

}
