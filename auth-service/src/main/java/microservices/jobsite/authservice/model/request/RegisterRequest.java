package microservices.jobsite.authservice.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RegisterRequest {

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Invalid email address")
    private String email;

    @NotBlank(message = "Username is mandatory")
    @Size(min=3, max=50, message="Username length must be between 3 and 50 characters")
    @Pattern(regexp = "^[a-z]+$", message = "Field must contain only lowercase letters")
    private String username;

    @NotBlank(message = "Password is mandatory")
    @Size(min=8, max=50, message="Password length must be between 8 and 50 characters")
    @Pattern(regexp="[a-zA-Z0-9]+", message="Password can contain alphanumeric characters only")
    private String password;

}
