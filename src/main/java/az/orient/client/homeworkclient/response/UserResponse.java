package az.orient.client.homeworkclient.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserResponse {

    private Long id;
    private String email;
    private String password;
    private String name;
    private String surname;
    private String token;
    private Integer active;
    private Date createdAt;
    private Date updatedAt;

}
