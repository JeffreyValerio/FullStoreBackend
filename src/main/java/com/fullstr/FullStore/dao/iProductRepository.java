package com.fullstr.FullStore.dao;

import com.fullstr.FullStore.entity.Brand;
import com.fullstr.FullStore.entity.Product;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

@RepositoryRestResource
public interface iProductRepository extends JpaRepository<Product, Long> {

    // GET PRODUCT USING THE ID
    Page<Product> findProductById(@Param("id") Long id, Pageable pageable);

    Product findBySlug(@RequestParam("slug") String slug);

    Page<Product> findBySlugContaining(@RequestParam("slug") String slug, Pageable pageable);

    // BUSCAR LA MARCA DEL PRODUCTO 
    Brand findByBrandId(@Param("id") Long id);

    // TRAE LOS PRODUCTOS QUE CORRESPONDAN A LA CATEGORIA ENVIADA
    Page<Product> findByCategorySlug(@RequestParam("slug") String slug, Pageable pageable);
}
