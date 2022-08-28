package com.SPM.backend.IT20122096.LoginRegistationAuth.Entity;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String name;
    private String email;
    private String password;
    private Boolean isAdmin=false;
}
