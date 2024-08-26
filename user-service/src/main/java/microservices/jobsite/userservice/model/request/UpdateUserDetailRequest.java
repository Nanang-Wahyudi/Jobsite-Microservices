package microservices.jobsite.userservice.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateUserDetailRequest {

    private String name;

    private String address;

    private String picture;

    private String description;

}
