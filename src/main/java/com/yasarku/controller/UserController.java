package com.yasarku.controller;

import com.yasarku.dto.CreateUserRequest;
import com.yasarku.dto.UserDTO;
import com.yasarku.entity.User;
import com.yasarku.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * REST controller for managing user-related operations.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Creates a new user.
     *
     * @param request The user creation request
     * @return The created user
     */
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody CreateUserRequest request) {
        User user = request.toEntity();
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(UserDTO.fromEntity(createdUser), HttpStatus.CREATED);
    }

    /**
     * Retrieves all users.
     *
     * @return List of all users
     */
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        List<UserDTO> userDTOs = users.stream()
                .map(UserDTO::fromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(userDTOs);
    }
}