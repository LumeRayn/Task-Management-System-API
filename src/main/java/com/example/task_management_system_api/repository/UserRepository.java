package com.example.task_management_system_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

    Optional<com.example.task_management_system_api.model.User> findByLogin(String username);

    com.example.task_management_system_api.model.User getByLogin(String login);

    List<com.example.task_management_system_api.model.User> getAll();
}