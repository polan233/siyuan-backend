package com.example.scmap.Mapper;

import com.example.scmap.Entity.Discussion;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

@Repository
public interface DiscussionMapper extends  Mapper<Discussion>, MySqlMapper<Discussion> {

    @Select("SELECT title FROM discussion LEFT JOIN text ON text.text_id=discussion.text_id WHERE text.text_name = #{text_name}")
    List<String> getDiscussionListByTextName(@Param("text_name") String textName);
}
