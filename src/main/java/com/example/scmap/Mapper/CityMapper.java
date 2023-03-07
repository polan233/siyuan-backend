package com.example.scmap.Mapper;

import com.example.scmap.Entity.City;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Repository
public interface CityMapper extends Mapper<City> , MySqlMapper<City> {

    @Select("SELECT * FROM city WHERE city_id=#{id}")
    City getCityById(@Param("id")Long id);
}
