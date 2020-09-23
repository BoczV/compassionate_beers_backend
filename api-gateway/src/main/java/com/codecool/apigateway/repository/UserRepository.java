package com.codecool.apigateway.repository;

import com.codecool.apigateway.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String username);

    Optional<User> deleteUserById(Long id);
}
