package com.fullstr.FullStore.dao;

import java.util.Optional;

import com.fullstr.FullStore.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface iUserRepository extends JpaRepository<User, Long> {

    // Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
