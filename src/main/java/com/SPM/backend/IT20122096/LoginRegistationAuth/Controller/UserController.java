package com.SPM.backend.IT20122096.LoginRegistationAuth.Controller;

import com.SPM.backend.IT20122096.LoginRegistationAuth.Entity.*;
import com.SPM.backend.IT20122096.LoginRegistationAuth.Repository.UserRepository;
import com.SPM.backend.IT20122096.LoginRegistationAuth.Service.UserServiceImpl;
import com.SPM.backend.IT20122096.LoginRegistationAuth.Utility.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserRepository userRepository;
    private final JWTUtility jwtUtility;
    private AuthenticationManager authenticationManager;
    private final UserServiceImpl userService;

    public UserController(UserRepository userRepository, JWTUtility jwtUtility, AuthenticationManager authenticationManager, UserServiceImpl userService) {
        this.userRepository = userRepository;
        this.jwtUtility = jwtUtility;
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    @PostMapping("/user/save")
    public ResponseEntity saveUser(@RequestBody UserDTO user) {

        if (user.getIsAdmin()) {
            User admin = new Admin("chamath", "chamath@gh", "1234", true);
            return new ResponseEntity(userRepository.save(admin), HttpStatus.OK);
        }
        User visitor = new User("chamath", "chamath@gt", "1234");
        return new ResponseEntity(userRepository.save(visitor), HttpStatus.OK);

    }

    @GetMapping("/")
    public String home() {
        return "welcome to buf";
    }

    @PostMapping("/auth")
    public JWTResponse authenticate(@RequestBody JWTRequest jwtRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUsername(),
                            jwtRequest.getPassword()

                    )
            );

        } catch (BadCredentialsException exception) {
            throw new Exception("Invalid Credentials", exception);
        }
        final UserDetails userDetails = userService.loadUserByUsername(jwtRequest.getUsername());
        final String token = jwtUtility.generateToken(userDetails);

        return new JWTResponse(token);
    }
}