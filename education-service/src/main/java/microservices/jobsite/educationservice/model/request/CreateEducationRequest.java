package microservices.jobsite.educationservice.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateEducationRequest {

    private String institutionName;

    private String major;

    private String avgScore;

}
