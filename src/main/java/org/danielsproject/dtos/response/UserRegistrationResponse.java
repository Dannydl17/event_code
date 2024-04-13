package org.danielsproject.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRegistrationResponse {
    private String name;
    private String email;
}
