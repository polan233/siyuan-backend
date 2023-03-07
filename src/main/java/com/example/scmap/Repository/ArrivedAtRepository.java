package com.example.scmap.Repository;

import com.example.scmap.Entity.City;
import com.example.scmap.Relationship.ArrivedAt;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface ArrivedAtRepository extends Neo4jRepository<ArrivedAt,Long> {

    @Query("match (a:author)-[:ArrivedAt]->(c:city) where a.authorId={authorId} return c")
    List<City> getAuthorPath(Long authorId);
}
