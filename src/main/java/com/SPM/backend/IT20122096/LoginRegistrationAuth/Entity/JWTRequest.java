package com.SPM.backend.IT20122096.LoginRegistrationAuth.Entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JWTRequest {

    private String username;
    private String password;
}
