package gr.hua.dit.dsproject.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import gr.hua.dit.dsproject.entities.Role;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

    private String token;
    private Integer user_id;
    private String email;
    private String firstname;
    private String lastname;
    private Role role;
}
