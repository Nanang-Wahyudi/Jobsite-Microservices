package microservices.jobsite.authservice.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateUserDetailAndCompanyRequest {

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "ID user is mandatory")
    private String userId;

}
