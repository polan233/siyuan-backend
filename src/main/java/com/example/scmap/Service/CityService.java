package com.example.scmap.Service;

import com.example.scmap.Repository.CityRepository;
import com.example.scmap.Entity.City;
import com.example.scmap.Mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class CityService {

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private CityRepository cityRepository;

    public String addCitiesToNeo4j(){
        List<City> cities = cityMapper.selectAll();
        List<City> insertList = new LinkedList<>();
        for(City city:cities){
            insertList.add(city);
        }
        cityRepository.saveAll(insertList);
        return "success";
    }

    public List<City> getCityIdList(){
        return cityMapper.selectAll();
    }
}
