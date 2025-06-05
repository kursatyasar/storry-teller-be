package com.yasarku.service;

import com.yasarku.entity.User;
import java.util.List;

/**
 * Service interface for managing User-related operations.
 */
public interface UserService {
    
    /**
     * Creates a new user in the system.
     *
     * @param user The user entity to be created
     * @return The created user with generated ID
     */
    User createUser(User user);
    
    /**
     * Retrieves all users from the system.
     *
     * @return A list of all users
     */
    List<User> getAllUsers();
    
    /**
     * Finds a user by their email address.
     *
     * @param email The email address to search for
     * @return The user if found, or null if not found
     */
    User findUserByEmail(String email);
}