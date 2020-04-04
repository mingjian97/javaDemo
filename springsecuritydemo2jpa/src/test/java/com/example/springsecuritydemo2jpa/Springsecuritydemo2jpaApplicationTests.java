package com.example.springsecuritydemo2jpa;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


class Springsecuritydemo2jpaApplicationTests {

    @Test
    void run1() {
        String pass = "123";
        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
        String hashPass = bcryptPasswordEncoder.encode(pass);
        System.out.println(hashPass);
    }

}
