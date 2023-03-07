package com.example.scmap;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;
import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@CrossOrigin
@SpringBootApplication
@MapperScan("com.example.scmap.mapper")
@EnableNeo4jRepositories("com.example.scmap.Repository")
@EntityScan(basePackages = {
        "com.example.scmap.entity",
        "com.example.scmap.relationship"
})
public class ScmapApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScmapApplication.class, args);
    }

}
