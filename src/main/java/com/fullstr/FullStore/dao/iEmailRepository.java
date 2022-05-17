package com.fullstr.FullStore.dao;

import com.fullstr.FullStore.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface iEmailRepository extends JpaRepository<Email, Integer> {
    
}
