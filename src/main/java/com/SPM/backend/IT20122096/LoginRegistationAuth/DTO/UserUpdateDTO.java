package com.SPM.backend.IT20122096.LoginRegistationAuth.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.bson.types.ObjectId;


import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateDTO {

    private ObjectId id;
    @Size(min = 3, message = "must be longer than 3 characters")
    private String name;
    @Size(max = 10, min = 5, message = "must in range 5-10")
    private String password;
    private String currentPassword;
    private String address;
    @Pattern(regexp = "(0)[0-9]{9}", message = "Must be a valid phone number")
    private String phoneNumber;
    private String image;
}
