package com.fullstr.FullStore.dao;

import java.util.List;

import com.fullstr.FullStore.entity.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

@RepositoryRestResource(collectionResourceRel = "category", path = "categories")
public interface iCategoryRepository extends JpaRepository<Category, Long> {

    @Query("select distinct c from Category c " +
            "left join fetch c.parent cc " +
            "left join fetch c.children ch " +
            "where cc is null")
    List<Category> findAll(); 

    Category findBySlug(@RequestParam("slug") String slug);
}
