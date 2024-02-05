package com.plexus.infrastructure.rest;

import com.plexus.infrastructure.adapter.entity.Country;
import com.plexus.application.service.CountryService;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;

import java.util.List;


@Controller("/country")
@RequiredArgsConstructor
@ExecuteOn(value = TaskExecutors.IO)
public class CountryController {

    @Inject
    private CountryService service;

    @Get("/list/{id}")
    public Country findById(Long id){
        return service.findById(id);
    }

    @Get("/list")
    public List<Country> findAll(){
        return service.findAll();
    }

    @Post("/add")
    @Status(HttpStatus.CREATED)
    public void save(@Body Country country){
        service.save(country);
    }

    @Put("/update")
    public void update(@Body Country country){
        service.update(country);
    }

    @Delete("/{id}")
    @Status(HttpStatus.OK)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}
