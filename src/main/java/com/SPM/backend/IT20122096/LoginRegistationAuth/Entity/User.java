package com.SPM.backend.IT20122096.LoginRegistationAuth.Entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Document
public class User {

    private String name;
    private String email;
    private String password;

}
