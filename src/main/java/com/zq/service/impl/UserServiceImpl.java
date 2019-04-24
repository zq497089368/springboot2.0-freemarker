package com.zq.service.impl;

import com.zq.entity.UserPO;
import com.zq.mapper.UserMapper;
import com.zq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public UserPO findById(Long id) {
        return userMapper.findById(id);
    }

    @Override
    public void save(UserPO userPO) {
        userMapper.save(userPO);
    }
}
