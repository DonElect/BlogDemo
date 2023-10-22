package com.dona.blogDemo.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class UsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String names;
    private String email;
    private String password;
    @Transient
    private String confirmPassword;
    private String role;
    private String address;
    @OneToMany(mappedBy = "usersEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PostEntity> posts;
    @OneToMany(mappedBy = "usersEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CommentEntity> comments;
    @OneToMany(mappedBy = "usersEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<LikeEntity> likes;
}
