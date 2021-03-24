package com.atguigu.yygh.hosp.service.impl;

/**
 * @program: yygh-parent -- com.atguigu.yygh.hosp.service.impl
 * @description: TODO
 * @author: Hong FanFan
 * @create: 2021-03-22 22:30
 */

import com.atguigu.yygh.hosp.mapper.HospitalSetMapper;
import com.atguigu.yygh.hosp.service.HospitalSetService;
import com.atguigu.yygh.model.hosp.HospitalSet;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalSetServiceImpl  implements HospitalSetService {
    @Autowired
    private HospitalSetMapper hospitalSetMapper;

    @Override
    public List<HospitalSet> list() {
        List<HospitalSet> list = hospitalSetMapper.selectList(new QueryWrapper<>());
        return list;
    }
}