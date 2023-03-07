package com.example.scmap.Service;

import com.example.scmap.Repository.ArrivedAtRepository;
import com.example.scmap.Repository.AuthorRepository;
import com.example.scmap.Repository.CityRepository;
import com.example.scmap.Entity.Author;
import com.example.scmap.Entity.City;
import com.example.scmap.Entity.Event;
import com.example.scmap.Mapper.AuthorMapper;
import com.example.scmap.Mapper.CityMapper;
import com.example.scmap.Mapper.EventMapper;
import com.example.scmap.Relationship.ArrivedAt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventService {

    @Autowired
    private ArrivedAtRepository arrivedAtRepository;

    @Autowired
    private EventMapper eventMapper;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private AuthorMapper authorMapper;

    @Autowired
    private CityMapper cityMapper;

    public String addEventsToNeo4j(){
        List<Event> eventList = eventMapper.selectAll();
        for(Event event:eventList){
            Long authorId = event.getAuthorId();
            Long cityId = event.getPlaceId();
            if(authorId!=null && cityId!=null){
                Author author = authorRepository.getAuthorByAuthorId(authorId);
                City city = cityRepository.getCityByCityId(cityId);
                if(author!=null && city!=null){
                    ArrivedAt relationship = ArrivedAt.builder().id(null).city(city).person(author).build();
                    arrivedAtRepository.save(relationship);
                }
            }

        }
        return "success";
    }
}
