package com.hy.admin.mapper;

import com.hy.admin.bean.Account;
import org.apache.ibatis.annotations.Mapper;

import javax.annotation.Resource;

/**
 * @author hy
 * @version 1.0
 * @Desctiption
 * @date 2022/3/14 18:53
 */

@Mapper
public interface AccountMapper {
    public Account getAcct(Integer id);

}
