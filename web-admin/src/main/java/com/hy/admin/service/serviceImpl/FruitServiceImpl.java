package com.hy.admin.service.serviceImpl;

import com.hy.admin.bean.Fruit;
import com.hy.admin.mapper.FruitMapper;
import com.hy.admin.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hy
 * @version 1.0
 * @Desctiption
 * @date 2022/3/15 13:28
 */

@Service
public class FruitServiceImpl implements FruitService {
    @Autowired
    FruitMapper fruitMapper;

    @Override
    public Fruit getFruitById(Integer fid) {
        return fruitMapper.selectById(fid);
    }
}
