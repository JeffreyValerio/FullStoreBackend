package com.fullstr.FullStore.dao;

import com.fullstr.FullStore.entity.Country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "countries", path = "countries")
public interface iCountryRepository extends JpaRepository<Country, Integer> {

}