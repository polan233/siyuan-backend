package com.example.scmap.Repository;

import com.example.scmap.Entity.City;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CityRepository extends Neo4jRepository<City,Long> {

    City getCityByName(String name);
    City getCityByCityId(Long cityId);
}
