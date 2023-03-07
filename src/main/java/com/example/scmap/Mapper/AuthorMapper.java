package com.example.scmap.Mapper;

import com.example.scmap.Entity.Author;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Repository
public interface AuthorMapper extends  Mapper<Author>, MySqlMapper<Author> {

    @Select("SELECT * FROM author WHERE author_id=#{id}")
    Author getAuthorById(@Param("id")Long id);
}
