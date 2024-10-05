package com.example.test_end_01.service.Impl;

import com.example.test_end_01.entity.pojo.User;
import com.example.test_end_01.mapper.UserMapper;
import com.example.test_end_01.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        return userMapper.getUserByUsernameAndPassword(username, password);
    }

    @Override
    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }
}
