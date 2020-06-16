package com.junga.mybatistest.service;

import com.junga.mybatistest.dao.UserMapper;
import com.junga.mybatistest.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void addUser(UserDto userDto) throws Exception {
        userMapper.insertUser(userDto);
    }

    public void setUser(UserDto userDto) throws Exception {
        userMapper.updateUser(userDto);
    }

    public void removeUser(int id) throws Exception {
        userMapper.deleteUser(id);
    }

    public UserDto getOneUser(int id) throws Exception {
        return userMapper.selectOneUser(id);
    }

    public List<UserDto> getAllUser() throws Exception {
        return userMapper.selectAllUser();
    }
}
