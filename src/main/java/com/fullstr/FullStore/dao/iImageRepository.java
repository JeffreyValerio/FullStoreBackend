package com.fullstr.FullStore.dao;

import java.util.List;

import com.fullstr.FullStore.entity.Image;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface iImageRepository extends JpaRepository<Image, Long> {
    
    List<Image> findByProductId(@Param("id") Long id);
    List<Image> findFirstByProductId(@Param("id") Long id);
}