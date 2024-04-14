package org.danielsproject.dtos.response;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationResponse {
    private String name;
    private String email;
    private String message;
}
