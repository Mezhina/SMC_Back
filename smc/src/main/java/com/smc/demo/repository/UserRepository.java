package com.smc.demo.repository;

import com.smc.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    // Найти пользователей по имени
    List<User> findByNameContainingIgnoreCase(String name);
    
    // Найти пользователя по email
    User findByEmail(String email);
}
