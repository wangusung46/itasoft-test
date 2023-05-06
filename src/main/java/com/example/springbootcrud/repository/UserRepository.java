package com.example.springbootcrud.repository;

import com.example.springbootcrud.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByName(String name);
}
