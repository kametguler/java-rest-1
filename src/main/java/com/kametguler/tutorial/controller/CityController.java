package com.kametguler.tutorial.controller;

import java.sql.Date;
import java.util.ArrayList;
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

@RestController
@RequestMapping("/cities")
public class CityController {
    private static final List<City> cities = new ArrayList<>();

    public CityController() {
        if (cities.isEmpty()) {
            City c1 = new City();
            c1.setCreated_at(new Date(0));
            c1.setId("06");
            c1.setName("Ankara");
            City c2 = new City();
            c2.setCreated_at(new Date(0));
            c2.setId("34");
            c2.setName("Istanbul");
            City c3 = new City();
            c3.setId("44");
            c3.setName("Malatya");
            City c4 = new City(new Date(0), "07", "Antalya");

            CityController.cities.add(c1);
            CityController.cities.add(c2);
            CityController.cities.add(c3);
            CityController.cities.add(c4);
        }
    }

    @GetMapping
    public ResponseEntity<List<City>> getCities() {

        return ResponseEntity.ok(CityController.cities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCity(@PathVariable String id) {

        City cty = this.getCityById(id);

        return ResponseEntity.ok(cty);
    }

    @PostMapping
    public ResponseEntity<City> addCity(@RequestBody City city) {
        city.setCreated_at(new Date(0));
        CityController.cities.add(city);

        return new ResponseEntity<>(city, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<City> updateCity(@RequestBody City city, @PathVariable String id) {
        City update_city = this.getCityById(id);

        update_city.setCreated_at(city.getCreated_at());
        update_city.setId(city.getId());
        update_city.setName(city.getName());

        return new ResponseEntity<City>(update_city, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable String id) {
        City delete_City = this.getCityById(id);
        CityController.cities.remove(delete_City);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private City getCityById(String id) {
        return CityController.cities.stream().filter(city -> city.getId().equals(id)).findFirst()
                .orElseThrow(() -> new RuntimeException("City is not found!"));
    }
}
