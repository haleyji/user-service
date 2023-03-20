package com.example.userservice.controller;

import com.example.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final Environment env;

    @GetMapping("/")
    public String home(){
        return "Welcome to User service hoem";
    }

    @GetMapping("/health_check")
    public String status(HttpServletRequest request) {
        String returnStr = "It's working in User-Service";
        returnStr += " port(local.server.port)=" + env.getProperty("local.server.port");
        returnStr += " port(server.port)=" + env.getProperty("server.port");
        returnStr += " token secret=" + env.getProperty("token.secret");
        returnStr += " token expiration time=" + env.getProperty("token.expiration_time");

        return returnStr;
    }
    @GetMapping("/welcome")
    public String welcome() {
        return String.format("It's working in user-service on POST %s", env.getProperty("local.server.port"));
    }

}
