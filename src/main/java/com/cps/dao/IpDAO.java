package com.cps.dao;

import com.cps.model.Ip;
import com.cps.model.Ip_coor_res;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Yale on 16/10/7.
 */
@Mapper
public interface IpDAO {
    String TABLE_NAME = "ip_t";
    String SELECT_FIELDS = " id, name, password, salt, head_url";
    String SELECT_COORDINATE_FIELDS = " coordinate, count(*) as count";

    @Select({"select ", SELECT_COORDINATE_FIELDS, " from ", TABLE_NAME, " group by coordinate having count(*) > #{num}"})
    List<Ip_coor_res> selectAllWithCoordinateAndCount(int num);
}
