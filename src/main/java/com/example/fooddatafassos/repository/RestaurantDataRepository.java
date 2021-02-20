package com.example.fooddatafassos.repository;

import com.example.fooddatafassos.entity.RestaurantData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantDataRepository extends MongoRepository<RestaurantData, String> {
}
