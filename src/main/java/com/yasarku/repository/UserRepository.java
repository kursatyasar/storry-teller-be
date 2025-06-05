package com.yasarku.repository;

import com.yasarku.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Common query method to find a user by email
    Optional<User> findByEmail(String email);
    
    // Custom query methods can be added here if needed
}