package com.yasarku.dto;

import com.yasarku.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for creating a new user.
 * Contains all necessary fields for user creation including password.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {
    
    private String username;
    private String password;
    private String email;
    private String fullName;
    private User.UserRole role;
    
    /**
     * Converts this request to a User entity.
     *
     * @return The converted User entity
     */
    public User toEntity() {
        User user = new User();
        user.setUsername(this.username);
        user.setPassword(this.password); // In a real application, this should be encrypted
        user.setEmail(this.email);
        user.setFullName(this.fullName);
        user.setRole(this.role);
        return user;
    }
}