package com.junga.mybatistest.service;

import com.junga.mybatistest.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void addUser() throws Exception {
        userService.addUser(new UserDto(1, "test1", "password1"));
        List<UserDto> users = userService.getAllUser();
        System.out.println(users.toString());
    }

    @Test
    void addDuplicationUser() throws Exception {
        userService.addUser(new UserDto(1, "test1", "password1"));
        try {
            userService.addUser(new UserDto(1, "test2", "password2")); // 중복되는 키
        } catch (DuplicateKeyException e) {
            e.printStackTrace();
        }
        List<UserDto> users = userService.getAllUser();
        System.out.println(users.toString());
    }

    @Test
    void setUser() throws Exception {
        userService.addUser(new UserDto(1, "username", "password1"));
        userService.setUser(new UserDto(1, "editedUsername", "password1"));
        List<UserDto> users = userService.getAllUser();
        System.out.println(users.toString());
    }

    @Test
    void removeUser() throws Exception {
        userService.addUser(new UserDto(1, "test1", "password1"));
        userService.addUser(new UserDto(2, "test2", "password2"));
        userService.removeUser(1);
        List<UserDto> users = userService.getAllUser();
        System.out.println(users.toString());
    }

    @Test
    void getOneUser() throws Exception {
        userService.addUser(new UserDto(1, "username", "password1"));
        System.out.println(userService.getOneUser(1).toString());
    }

    @Test
    void getAllUser() throws Exception {
        userService.addUser(new UserDto(1, "test1", "password1"));
        userService.addUser(new UserDto(2, "test2", "password2"));
        List<UserDto> users = userService.getAllUser();
        System.out.println(users.toString());
    }
}