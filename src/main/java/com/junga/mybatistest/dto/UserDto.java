package com.junga.mybatistest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserDto {

    private int userId;
    private String username;
    private String password;
}
