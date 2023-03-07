package com.example.scmap.Mapper;

import com.example.scmap.Entity.Problem;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Repository
public interface ProblemMapper extends Mapper<Problem>, MySqlMapper<Problem> {
}
