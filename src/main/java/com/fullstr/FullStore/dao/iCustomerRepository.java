package com.fullstr.FullStore.dao;

import com.fullstr.FullStore.entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface iCustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByEmail(String theEmail);
}
