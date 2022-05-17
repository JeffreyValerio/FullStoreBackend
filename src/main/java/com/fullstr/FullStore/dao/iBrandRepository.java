package com.fullstr.FullStore.dao;


import com.fullstr.FullStore.entity.Brand;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface iBrandRepository extends JpaRepository<Brand, Long>{
    
}
