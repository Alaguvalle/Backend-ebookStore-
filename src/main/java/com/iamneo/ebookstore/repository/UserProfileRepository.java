package com.iamneo.ebookstore.repository;

import com.iamneo.ebookstore.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserProfileRepository extends JpaRepository <Users, Integer> {
    Optional<Users> findByEmail(String email);
    Optional<Users> deleteByEmail(String email);
}
