package com.SPM.backend.IT20122096.LoginRegistationAuth.Service;

import com.SPM.backend.IT20122096.LoginRegistationAuth.DTO.UserDTO;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService  {
    UserDetails loadUserByUsername(String email);
    ResponseEntity getAllUsers();
    ResponseEntity getUserById(ObjectId id);
    ResponseEntity saveUser(UserDTO userDTO);



}
