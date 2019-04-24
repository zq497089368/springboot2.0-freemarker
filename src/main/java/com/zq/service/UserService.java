package com.zq.service;

import com.zq.entity.UserPO;

public interface UserService {
    UserPO findById(Long id);

    void save(UserPO userPO);
}
