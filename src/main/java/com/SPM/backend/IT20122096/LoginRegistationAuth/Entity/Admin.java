package com.SPM.backend.IT20122096.LoginRegistationAuth.Entity;


import lombok.*;
import org.bson.types.ObjectId;

@Setter
@Getter
@ToString
@NoArgsConstructor

public class Admin extends User {
    private Boolean isAdmin=false;

    public Admin(ObjectId id, String name, String email, String password, Boolean isAdmin) {
        super(id,name, email, password);
        this.isAdmin = isAdmin;
    }
}
