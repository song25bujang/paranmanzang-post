package com.paranmanzang.post.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    private String username;
    private String password;
    //@Data : implement Serialization,getter,setter,noargsConstructor
}
