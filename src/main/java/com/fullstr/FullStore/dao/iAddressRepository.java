package com.fullstr.FullStore.dao;

import com.fullstr.FullStore.entity.Address;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface iAddressRepository extends JpaRepository<Address, Long> {

    Page<Address> findAddressById(@Param("id") Long id, Pageable pageable);

    Address findByOrderId(@Param("id") Long id);
}
