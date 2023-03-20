package com.example.userservice.service;

import com.example.userservice.dto.UserDto;
import com.example.userservice.entity.User;
import com.example.userservice.request.RequestUser;
import com.example.userservice.response.ResponseUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    ResponseUser create(RequestUser requestUser);

    UserDto getUserByUserId(String userId);
    Iterable<User> getAllUser();

    UserDto getUserDetailsByEmail(String email);
}
