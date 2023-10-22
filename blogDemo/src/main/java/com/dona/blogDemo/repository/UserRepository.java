package com.dona.blogDemo.repository;

import com.dona.blogDemo.model.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UsersEntity, Long> {
    boolean existsByEmail(String email);
    Optional<UsersEntity> findUsersEntityByEmailAndPassword(String email, String password);
}
