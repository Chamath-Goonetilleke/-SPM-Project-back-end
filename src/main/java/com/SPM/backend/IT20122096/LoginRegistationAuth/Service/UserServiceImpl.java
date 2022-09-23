package com.SPM.backend.IT20122096.LoginRegistationAuth.Service;

import com.SPM.backend.IT20122096.LoginRegistationAuth.DTO.UserUpdateDTO;
import com.SPM.backend.IT20122096.LoginRegistationAuth.Entity.Admin;
import com.SPM.backend.IT20122096.LoginRegistationAuth.DTO.UserRegisterDTO;
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
public class UserServiceImpl implements UserDetailsService, UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        com.SPM.backend.IT20122096.LoginRegistationAuth.Entity.User user = userRepository.findUserByEmail(email);


        return new User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }

    @Override
    public ResponseEntity getAllUsers() {
        List<com.SPM.backend.IT20122096.LoginRegistationAuth.Entity.User> allUsers = userRepository.findAll();

        return new ResponseEntity(allUsers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity getUserById(ObjectId id) {
        com.SPM.backend.IT20122096.LoginRegistationAuth.Entity.User user = userRepository.findById(id).get();
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @Override
    public String getUserByEmail(String email) {
        com.SPM.backend.IT20122096.LoginRegistationAuth.Entity.User user = userRepository.findUserByEmail(email);

        return user.getId().toHexString();
    }



    @Override
    public ResponseEntity saveUser(UserRegisterDTO userRegisterDTO) {

        com.SPM.backend.IT20122096.LoginRegistationAuth.Entity.User user = userRepository.findUserByEmail(userRegisterDTO.getEmail());
        if (user != null) {
            return new ResponseEntity("User Already Exist", HttpStatus.BAD_REQUEST);
        }

        if (userRegisterDTO.getIsAdmin()) {
            com.SPM.backend.IT20122096.LoginRegistationAuth.Entity.User admin = new Admin(
                    userRegisterDTO.getId(), userRegisterDTO.getName(), userRegisterDTO.getEmail(), userRegisterDTO.getPassword(), null, null, null, userRegisterDTO.getIsAdmin());
            admin.setPassword(admin.passwordEncoder(userRegisterDTO.getPassword()));

            return new ResponseEntity(userRepository.save(admin), HttpStatus.OK);
        }
        com.SPM.backend.IT20122096.LoginRegistationAuth.Entity.User visitor = new com.SPM.backend.IT20122096.LoginRegistationAuth.Entity.User(
                userRegisterDTO.getId(), userRegisterDTO.getName(), userRegisterDTO.getEmail(), userRegisterDTO.getPassword(), null, null, null);
        visitor.setPassword(visitor.passwordEncoder(userRegisterDTO.getPassword()));

        return new ResponseEntity(userRepository.save(visitor), HttpStatus.OK);
    }

    @Override
    public ResponseEntity updateUser(UserUpdateDTO userDTO) {

        com.SPM.backend.IT20122096.LoginRegistationAuth.Entity.User user = userRepository.findById(userDTO.getId()).get();

        if(userDTO.getCurrentPassword()!=null && !(user.isPasswordMatch(userDTO.getCurrentPassword(),user.getPassword()))){
            return new ResponseEntity("Wrong Password", HttpStatus.BAD_REQUEST);
        }

        user.setName(userDTO.getName());
        user.setAddress(userDTO.getAddress());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setImage(userDTO.getImage());

        if(userDTO.getPassword()!=null){
            String encodedPassword = user.passwordEncoder(userDTO.getPassword());
            user.setPassword(encodedPassword);
        }

        return new ResponseEntity(userRepository.save(user), HttpStatus.OK);
    }
}
