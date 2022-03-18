package com.hy.admin.mapper;

import com.hy.admin.bean.Fruit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author hy
 * @version 1.0
 * @Desctiption
 * @date 2022/3/15 13:22
 */

@Mapper
public interface FruitMapper {

    @Select("select * from t_fruit where fid = #{fid}")
    public Fruit selectById(Integer fid);
}
