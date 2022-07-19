package com.kametguler.tutorial.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kametguler.tutorial.model.City;
import com.kametguler.tutorial.repository.CityRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CityService {
    private final CityRepository cityRepository;

    public List<City> getAllCities() {
        return this.cityRepository.findAll();
    }

    public City getCity(String id) {
        return this.cityRepository.findById(id).orElseThrow(() -> new RuntimeException("City is not found"));
    }

    public City addCity(City city) {
        return this.cityRepository.save(city);
    }

    public City updateCity(City city, String id) {
        City update_city = this.getCity(id);
        update_city.setName(city.getName());

        return this.cityRepository.save(update_city);
    }

    public void deleteCity(String id) {
        this.cityRepository.deleteById(id);
    }

    public City getCityById(String id) {
        return this.cityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("City is not found"));
    }
}
