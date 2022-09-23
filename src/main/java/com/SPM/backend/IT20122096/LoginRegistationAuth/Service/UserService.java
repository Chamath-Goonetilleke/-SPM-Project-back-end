package com.SPM.backend.IT20122096.LoginRegistationAuth.Service;


import com.SPM.backend.IT20122096.LoginRegistationAuth.DTO.UserRegisterDTO;
import com.SPM.backend.IT20122096.LoginRegistationAuth.DTO.UserUpdateDTO;
import com.SPM.backend.IT20122096.LoginRegistationAuth.Entity.User;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService  {
    UserDetails loadUserByUsername(String email);
    ResponseEntity getAllUsers();
    ResponseEntity getUserById(ObjectId id);
    ResponseEntity saveUser(UserRegisterDTO userDTO);
    ResponseEntity updateUser(UserUpdateDTO userDTO);
    String getUserByEmail(String email);




}
