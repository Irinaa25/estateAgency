package com.example.agency.repository;
import com.example.agency.entity.Client;
import com.example.agency.entity.Estate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EstateRepository extends JpaRepository<Estate, Long>{
    boolean existsByName(String name);
}
