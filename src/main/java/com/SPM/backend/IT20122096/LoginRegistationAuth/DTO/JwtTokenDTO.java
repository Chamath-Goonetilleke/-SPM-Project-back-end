package com.SPM.backend.IT20122096.LoginRegistationAuth.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtTokenDTO {

    private String id;
    private boolean isAdmin=false;
}
