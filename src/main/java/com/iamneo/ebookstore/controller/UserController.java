package com.iamneo.ebookstore.controller;

//UserProfileController.java


import com.iamneo.ebookstore.impl.UserRequest;
import com.iamneo.ebookstore.impl.UserResponse;
import com.iamneo.ebookstore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {
    private final UserService userService;


    @GetMapping("/view-profile")
    public ResponseEntity<UserResponse> getUserProfile(@RequestParam String email) {
        // Fetch user profile data from your data source (e.g., a database)

        UserResponse userResponse = userService.getUserProfile(email); // You need to implement this service

        if (userResponse != null) {
            return ResponseEntity.ok(userResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update-profile")
    public ResponseEntity<String> updateUserProfile(
            @RequestParam String email,
            @RequestBody UserRequest userRequest
    ) {
        ResponseEntity<String> result = userService.updateUserProfile(email, userRequest);

        return result;
    }

    @DeleteMapping("/delete-profile")
    public ResponseEntity<String> deleteUserProfile(@RequestParam String email) {
        ResponseEntity<String> result2 = userService.deleteUserProfile(email);
        return result2;
    }
}