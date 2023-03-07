package com.example.scmap.Relationship;

import com.example.scmap.Entity.Author;
import com.example.scmap.Entity.City;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "ArrivedAt")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArrivedAt {

    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private Author person;

    @EndNode
    private City city;
}
