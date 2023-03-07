package com.example.scmap.Repository;

import com.example.scmap.Entity.Author;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends Neo4jRepository<Author,Long> {

   Author getAuthorByAuthorName(String authorName);
   Author getAuthorByAuthorId(Long authorId);
}
