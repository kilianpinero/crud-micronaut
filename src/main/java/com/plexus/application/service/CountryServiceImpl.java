package com.plexus.application.service;

import com.plexus.infrastructure.adapter.entity.Country;
import com.plexus.infrastructure.adapter.repository.CountryRepository;
import com.plexus.application.service.CountryService;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    @Inject
    private CountryRepository countryRepo;

    @Override
    public void save(Country country) {
        countryRepo.save(country);
    }

    @Override
    public List<Country> findAll() {
        return countryRepo.findAll().stream().toList();
    }

    @Override
    public Country findById(Long id) {
        return countryRepo.findById(id).orElseThrow(()-> new NoSuchElementException());
    }

    @Override
    public void delete(Long id) {
        countryRepo.deleteById(id);
    }

    @Override
    public void update(Country country) {
        countryRepo.update(country);
    }
}
