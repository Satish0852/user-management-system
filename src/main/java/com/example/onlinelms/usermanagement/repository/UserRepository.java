package com.example.onlinelms.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onlinelms.usermanagement.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
