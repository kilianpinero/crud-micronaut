package com.plexus.infrastructure.adapter.repository;

import com.plexus.infrastructure.adapter.entity.Country;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

}
