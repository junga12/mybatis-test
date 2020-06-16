package com.junga.mybatistest.dao;

import com.junga.mybatistest.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    public void insertUser(UserDto userDto) throws Exception;

    public void updateUser(UserDto userDto) throws Exception;

    public void deleteUser(int id) throws Exception;

    public UserDto selectOneUser(int id) throws Exception;

    public List<UserDto> selectAllUser() throws Exception;
}
