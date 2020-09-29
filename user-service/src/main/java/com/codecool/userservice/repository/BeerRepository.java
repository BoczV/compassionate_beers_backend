package com.codecool.userservice.repository;

import com.codecool.userservice.model.Beer;
import com.codecool.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface BeerRepository extends JpaRepository<Beer, Long> {
    @Transactional
    void deleteBeerById(Long id);

    List<Beer> findByUsername(String username);


}
