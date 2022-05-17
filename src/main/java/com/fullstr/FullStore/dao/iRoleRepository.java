package com.fullstr.FullStore.dao;

import java.util.Optional;

import com.fullstr.FullStore.entity.ERole;
import com.fullstr.FullStore.entity.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface iRoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);
}
