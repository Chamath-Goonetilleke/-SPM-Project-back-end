package com.SPM.backend.IT20122096.LoginRegistationAuth.Service;

import com.SPM.backend.IT20122096.LoginRegistationAuth.Entity.Admin;
import com.SPM.backend.IT20122096.LoginRegistationAuth.Entity.UserDTO;
import com.SPM.backend.IT20122096.LoginRegistationAuth.Repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserDetailsService,UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        com.SPM.backend.IT20122096.LoginRegistationAuth.Entity.User user = userRepository.findUserByEmail(email);
        PasswordEncoder encoder =
                PasswordEncoderFactories.createDelegatingPasswordEncoder();

        return new User(user.getEmail(), encoder.encode(user.getPassword()), new ArrayList<>());
    }

    @Override
    public ResponseEntity getAllUsers() {
        List<com.SPM.backend.IT20122096.LoginRegistationAuth.Entity.User> allUsers = userRepository.findAll();

        return new ResponseEntity(allUsers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity getUserById(ObjectId id) {
        com.SPM.backend.IT20122096.LoginRegistationAuth.Entity.User user = userRepository.findById(id).get();
        return new ResponseEntity(user,HttpStatus.OK);
    }

    @Override
    public ResponseEntity saveUser(UserDTO userDTO) {

        com.SPM.backend.IT20122096.LoginRegistationAuth.Entity.User user = userRepository.findUserByEmail(userDTO.getEmail());
        if(user != null){
            return new ResponseEntity("User Already Exist",HttpStatus.BAD_REQUEST);
        }

        if (userDTO.getIsAdmin()) {
            com.SPM.backend.IT20122096.LoginRegistationAuth.Entity.User admin = new Admin(userDTO.getId(),userDTO.getName(), userDTO.getEmail(), userDTO.getPassword(), userDTO.getIsAdmin());
            return new ResponseEntity(userRepository.save(admin), HttpStatus.OK);
        }
        com.SPM.backend.IT20122096.LoginRegistationAuth.Entity.User visitor = new com.SPM.backend.IT20122096.LoginRegistationAuth.Entity.User(
                userDTO.getId(), userDTO.getName(), userDTO.getEmail(), userDTO.getPassword());

        return new ResponseEntity(userRepository.save(visitor), HttpStatus.OK);
    }
}
