package microservices.jobsite.usereducationservice.model.request.clientRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateUserDetailCreateEducationClientRequest {

    private String name;

    private String address;

    private String picture;

    private String description;

    private String institutionName;

    private String major;

    private String avgScore;

}
