package com.paranmanzang.post.controller;

import com.paranmanzang.post.model.domain.UserModel;
import com.paranmanzang.post.model.entity.User;
import com.paranmanzang.post.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController implements UserService {

    public List<UserModel> findAll() {
        throw new UnsupportedOperationException("unimplemented method (findAll)");
    }

    public User save(UserModel user) {
        throw new UnsupportedOperationException("unimplemented method (save)");
    }

    public UserModel findById(Long id) {
        throw new UnsupportedOperationException("unimplemented method (findById)");
    }

    public boolean existsById(Long id) {
        throw new UnsupportedOperationException("unimplemented method (existsById)");
    }
}
