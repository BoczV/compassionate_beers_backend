package com.codecool.userservice.repository;

import com.codecool.userservice.model.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeerRepository extends JpaRepository<Beer, Long> {


}
