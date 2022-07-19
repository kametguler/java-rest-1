package com.kametguler.tutorial.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kametguler.tutorial.model.City;
import com.kametguler.tutorial.service.CityService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/cities")
@AllArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping
    public ResponseEntity<List<City>> getCities() {

        return ResponseEntity.ok(cityService.getAllCities());
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCitById(@PathVariable String id) {

        return new ResponseEntity<>(this.cityService.getCity(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<City> addNewCity(@RequestBody City city) {

        return new ResponseEntity<>(this.cityService.addCity(city), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<City> updateCityById(@RequestBody City city, @PathVariable String id) {

        return new ResponseEntity<City>(this.cityService.updateCity(city, id), HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCityById(@PathVariable String id) {
        this.cityService.deleteCity(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // private City getCityById(String id) {
    // return this.cityService.getCityById(id);
    // }
}
