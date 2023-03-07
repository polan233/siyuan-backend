package com.example.scmap.Mapper;

import com.example.scmap.DTO.text.TextItem;
import com.example.scmap.Entity.Text;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

@Repository
public interface TextMapper extends Mapper<Text>, MySqlMapper<Text> {

    @Select("SELECT text_name,author_name,textbook FROM text LEFT JOIN author ON text.author_id=author.author_id")
    List<TextItem> getTextList();

}