package com.SPM.backend.IT20122096.LoginRegistationAuth.Repository;

import com.SPM.backend.IT20122096.LoginRegistationAuth.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<User, Integer> {

    @Query("{'email' : ?0}")
    User findUserByEmail (String email);

}
