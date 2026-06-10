package com.devpriya.Social_Bookmarking_Discovery_Backend.repository;

import com.devpriya.Social_Bookmarking_Discovery_Backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}