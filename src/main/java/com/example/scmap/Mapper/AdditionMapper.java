package com.example.scmap.Mapper;

import com.example.scmap.Entity.Addition;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Repository
public interface AdditionMapper extends Mapper<Addition>, MySqlMapper<Addition> {
}
