package com.example.scmap.Mapper;

import com.example.scmap.DTO.event.EventItem;
import com.example.scmap.Entity.Event;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

@Repository
public interface EventMapper extends Mapper<Event>, MySqlMapper<Event> {

    @Select("SELECT place_id as city,description as event,time,true as isBC FROM event WHERE author_id = #{author_id} AND BC=1 ORDER BY place_id,time DESC")
    List<EventItem> getAuthorPathBC(@Param("author_id")Long authorId);

    @Select("SELECT place_id as city,description as event,time,false as isBC FROM event WHERE author_id = #{author_id} AND BC=0 ORDER BY place_id,time ASC")
    List<EventItem> getAuthorPathNotBC(@Param("author_id")Long authorId);

}
