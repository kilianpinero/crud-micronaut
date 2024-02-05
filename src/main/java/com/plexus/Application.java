package com.plexus;

import com.plexus.infrastructure.adapter.entity.Country;
import com.plexus.infrastructure.adapter.repository.CountryRepository;
import io.micronaut.context.event.StartupEvent;
import io.micronaut.runtime.Micronaut;
import io.micronaut.runtime.event.annotation.EventListener;
import io.micronaut.transaction.annotation.Transactional;

import java.util.Arrays;

public class Application {

    private final CountryRepository repository;

    public Application(CountryRepository repository){
        this.repository = repository;
    }

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }

    @EventListener
    @Transactional
    public void init(StartupEvent startupEvent) {
        repository.saveAll(Arrays.asList(
                new Country(1L, "India"),
                new Country(2L, "Brazil"),
                new Country(3L, "USA")));
    }
}