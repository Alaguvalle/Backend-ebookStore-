//UserService.java

package com.iamneo.ebookstore.service;

import com.iamneo.ebookstore.impl.UserRequest;
import com.iamneo.ebookstore.impl.UserResponse;
import com.iamneo.ebookstore.model.UserRepository;
import com.iamneo.ebookstore.model.Users;
import com.iamneo.ebookstore.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private final UserProfileRepository repository; // You need to create a UserRepository interface

    public UserResponse getUserProfile(String userEmail) {
        Optional<Users> userOptional = repository.findByEmail(userEmail);

        if (userOptional.isPresent()) {
            Users user = userOptional.get();

            UserResponse userResponse = new UserResponse();
            userResponse.setFirstName(user.getFirstName());
            userResponse.setLastName(user.getLastName());
            userResponse.setEmail(user.getEmail());
            // Set other fields as needed

            return userResponse;
        } else {
            return null; // or return an appropriate response if the user is not found
        }
    }

    public ResponseEntity<String> updateUserProfile(String userEmail, UserRequest userRequest) {
        // Get the user by email
        Optional<Users> userOptional = repository.findByEmail(userEmail);

        if (userOptional.isPresent()) {
            Users user = userOptional.get();

            // Update the user's information based on the request
            if (userRequest.getFirstName() != null) {
                user.setFirstName(userRequest.getFirstName());
            }
            if (userRequest.getLastName() != null) {
                user.setLastName(userRequest.getLastName());
            }

            // Save the updated user
            repository.save(user);

            return ResponseEntity.status(HttpStatus.OK).body("Profile updated successfully"); // Return a success message
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User not found"); // Return a success message
        }
    }

    public ResponseEntity<String> deleteUserProfile(String email) {
        // Check if the user exists
        Optional<Users> user = repository.findByEmail(email);

        if (user.isPresent()) {
            // If the user exists, you can delete the user from the database
            repository.delete(user.get());
            return ResponseEntity.noContent().build();
        } else {
            // User not found, return an error response
            return ResponseEntity.notFound().build();
        }
    }
}