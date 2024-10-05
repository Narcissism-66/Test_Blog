package com.example.test_end_01.service;

import com.example.test_end_01.entity.pojo.User;

public interface UserService {
    User login(String username, String password);
    User getUserById(int id);
}
