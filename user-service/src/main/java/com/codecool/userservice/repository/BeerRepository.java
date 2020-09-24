package com.codecool.userservice.repository;

import com.codecool.userservice.model.Beer;
import com.codecool.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BeerRepository extends JpaRepository<Beer, Long> {
    List<Beer> findByUsername(String username);
}
