package org.danielsproject.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRegistrationRequest {
    private String name;
    private String email;
    private String password;
}
