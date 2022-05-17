package com.fullstr.FullStore.dao;

import com.fullstr.FullStore.entity.UserAddress;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

@RepositoryRestResource
public interface iUserAddressRepository extends JpaRepository<UserAddress, Long> {
    Page<UserAddress> findByUserId(@RequestParam("id") Long id, Pageable pageable);
}
