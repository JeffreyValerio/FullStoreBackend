package com.fullstr.FullStore.dao;

import java.util.List;

import com.fullstr.FullStore.entity.Order;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface iOrderRepository extends JpaRepository<Order, Long> {
    Page<Order> findByCustomerEmail(@Param("email") String email, Pageable pageable);

    Page<Order> findByShippingAddress(@Param("id") Long id, Pageable pageable);
 
    @Query("select o.id from Order o")
    List<Order> findAll();

    Page<Order> findByCustomerEmailOrderByIdDesc(@Param("email") String email, Pageable pageable);

} 