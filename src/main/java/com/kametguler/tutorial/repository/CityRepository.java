package com.kametguler.tutorial.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kametguler.tutorial.model.City;

public interface CityRepository extends MongoRepository<City, String> {

}
