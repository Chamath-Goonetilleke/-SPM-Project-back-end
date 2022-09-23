package com.SPM.backend.IT20122096.LoginRegistationAuth.Entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Id;


@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Document
public class User {
    @Id
    private ObjectId id;
    private String name;
    private String email;
    private String password;
    private String address;
    private String phoneNumber;
    private String image;

    public String passwordEncoder(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);
        return encodedPassword;
    }

    public boolean isPasswordMatch(String password, String encodedPassword){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return (passwordEncoder.matches(password,encodedPassword));
    }


}
