package microservices.jobsite.usereducationservice.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateUserDetailCreateEducationRequest {

    private String name;

    private String address;

    private String picture;

    private String description;

    private String institutionName;

    private String major;

    private String avgScore;

}
