package com.SPM.backend.IT20122096.LoginRegistationAuth.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JWTRequest {

    private String username;
    private String password;
}
