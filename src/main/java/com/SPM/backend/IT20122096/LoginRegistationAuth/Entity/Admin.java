package com.SPM.backend.IT20122096.LoginRegistationAuth.Entity;


import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor

public class Admin extends User {
    private Boolean isAdmin=false;

    public Admin(String name, String email, String password, Boolean isAdmin) {
        super(name, email, password);
        this.isAdmin = isAdmin;
    }
}
