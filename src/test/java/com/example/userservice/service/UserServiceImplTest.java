package com.example.userservice.service;

import com.example.userservice.repository.UserRepository;
import com.example.userservice.request.RequestUser;
import com.netflix.discovery.converters.Auto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceImplTest {

    @Autowired
    UserServiceImpl userService;
    @Autowired
    UserRepository userRepository;

    @Test
    @DisplayName("이메일,이름,비밀번호값을 전송해 회원가입에 성공한다")
    public void test(){
        RequestUser user = new RequestUser();
        user.setEmail("haley@test.com");
        user.setName("지혜영");
        user.setPassword("test1234");

        userService.create(user);

        Assertions.assertEquals(1L, userRepository.findAll().size());
    }

}