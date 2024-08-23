package com.paranmanzang.post.service;

import com.paranmanzang.post.model.domain.UserModel;
import com.paranmanzang.post.model.entity.User;

import java.util.List;

public interface UserService { //docker up 시 -p 옵션처럼 명시해주는 역할
    List<UserModel> findAll();
    User save(UserModel user);
    UserModel findById(Long id);
    boolean existsById(Long id);

}
