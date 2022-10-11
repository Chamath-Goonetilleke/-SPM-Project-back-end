package com.SPM.backend.IT20122096.LoginRegistrationAuth.Entity_DTO;

import com.SPM.backend.IT20122096.LoginRegistrationAuth.DTO.JwtTokenDTO;
import com.SPM.backend.IT20122096.LoginRegistrationAuth.DTO.UserRegisterDTO;
import com.SPM.backend.IT20122096.LoginRegistrationAuth.DTO.UserUpdateDTO;
import com.SPM.backend.IT20122096.LoginRegistrationAuth.Entity.Admin;
import com.SPM.backend.IT20122096.LoginRegistrationAuth.Entity.JWTRequest;
import com.SPM.backend.IT20122096.LoginRegistrationAuth.Entity.JWTResponse;
import com.SPM.backend.IT20122096.LoginRegistrationAuth.Entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.meanbean.test.BeanTester;
import org.springframework.boot.test.context.SpringBootTest;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
public class LoginRegistrationAuthEntityDOTTest {

    @Test
    void TestAllLoginRegistrationAuthEntities(){
        BeanTester beanTester = new BeanTester();
        beanTester.testBean(Admin.class);
        beanTester.testBean(JWTRequest.class);
        beanTester.testBean(JWTResponse.class);
        beanTester.testBean(User.class);
    }
    @Test
    void TestAllLoginRegistrationAuthDTOs(){
        BeanTester beanTester = new BeanTester();
        beanTester.testBean(JwtTokenDTO.class);
        beanTester.testBean(UserRegisterDTO.class);
        beanTester.testBean(UserUpdateDTO.class);
    }
}
