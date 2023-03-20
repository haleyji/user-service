package com.example.userservice.controller;

import com.example.userservice.dto.UserDto;
import com.example.userservice.entity.User;
import com.example.userservice.request.RequestUser;
import com.example.userservice.response.ResponseUser;
import com.example.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UsersController {

    private final Environment env;
    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity create(@RequestBody RequestUser requestUser) {
        ResponseUser createdUser = userService.create(requestUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @GetMapping("/users")
    public ResponseEntity<List<ResponseUser>> getUsers(){
        Iterable<User> users = userService.getAllUser();
        List<ResponseUser> responseUsers = new ArrayList<>();
        users.forEach(u->{
            responseUsers.add(new ModelMapper().map(u, ResponseUser.class));
        });
        return ResponseEntity.status(HttpStatus.OK).body(responseUsers);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<ResponseUser> getUser(@PathVariable String userId) {
        UserDto userDto = userService.getUserByUserId(userId);

        return ResponseEntity.status(HttpStatus.OK).body(new ModelMapper().map(userDto, ResponseUser.class));
    }
}
