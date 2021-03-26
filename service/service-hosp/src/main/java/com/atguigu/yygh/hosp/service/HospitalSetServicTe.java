package com.atguigu.yygh.hosp.service;

import com.atguigu.yygh.model.hosp.HospitalSet;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface HospitalSetServicTe {

    List<HospitalSet> list();
    
    boolean save(HospitalSet hospitalSet);
    
    HospitalSet getById(String id);
    
    boolean updateById(HospitalSet hospitalSet);
    
    void deleteByIds(List<String> ids);
}