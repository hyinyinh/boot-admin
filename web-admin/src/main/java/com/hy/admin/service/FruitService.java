package com.hy.admin.service;

import com.hy.admin.bean.Fruit;
import com.hy.admin.mapper.FruitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hy
 * @version 1.0
 * @Desctiption
 * @date 2022/3/15 13:27
 */

public interface FruitService {

    Fruit getFruitById(Integer fid);

}
