package com.example.fooddatafassos.repository;

import com.example.fooddatafassos.entity.DishData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishDataRepository extends MongoRepository<DishData, String> {
}
