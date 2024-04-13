package org.danielsproject.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginResponse {
    private String email;
    private String password;
}
