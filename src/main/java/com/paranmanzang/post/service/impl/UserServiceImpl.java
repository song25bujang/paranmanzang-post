package com.paranmanzang.post.service.impl;


import com.paranmanzang.post.model.domain.UserModel;
import com.paranmanzang.post.model.entity.User;
import com.paranmanzang.post.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public List<UserModel> findAll() {
        return null;
    }

    @Override
    public User save(UserModel user) {
        return null;
    }

    @Override
    public UserModel findById(Long id) {
        return null;
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }
}
