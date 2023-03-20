package com.example.userservice.dto;

import com.example.userservice.entity.User;
import com.example.userservice.response.ResponseOrder;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class UserDto {

    private String email;
    private String name;
    private String password;
    private String encryptedPassword;
    private String userId;
    private Date createAt;

    private List<ResponseOrder> orders = new ArrayList<>();

    public User toUserBuilder() {
        return User.builder()
                .email(email)
                .name(name)
                .encryptedPassword(encryptedPassword)
                .userId(userId)
                .createAt(createAt)
                .build();
    }

    public void setOrders(List<ResponseOrder> orders) {
        this.orders = orders;
    }
}
