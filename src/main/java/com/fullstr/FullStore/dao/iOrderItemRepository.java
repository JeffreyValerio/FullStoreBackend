package com.fullstr.FullStore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

import com.fullstr.FullStore.entity.OrderItem;

@RepositoryRestResource
public interface iOrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findByOrderId(@Param("orderId") Long orderId);
}