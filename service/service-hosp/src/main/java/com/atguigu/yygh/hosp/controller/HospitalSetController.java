package com.atguigu.yygh.hosp.controller;

/**
 * @program: yygh-parent -- com.atguigu.yygh.hosp.controller
 * @description: TODO
 * @author: Hong FanFan
 * @create: 2021-03-22 22:31
 */

import com.atguigu.yygh.common.exception.YyghException;
import com.atguigu.yygh.common.result.Result;
import com.atguigu.yygh.common.result.ResultCodeEnum;
import com.atguigu.yygh.common.utils.MD5;
import com.atguigu.yygh.hosp.service.HospitalSetServicTe;
import com.atguigu.yygh.model.hosp.HospitalSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/admin/hosp/hospitalSet")
public class HospitalSetController {
    @Autowired
    private HospitalSetServicTe hospitalSetService;
    @GetMapping("/findAll")
    @CrossOrigin
    public Result findAll(){
        List<HospitalSet> list = hospitalSetService.list();
        return Result.ok(list);
    }
    @PostMapping("/saveHospitalSet")
    public Result saveHospitalSet(@RequestBody HospitalSet hospitalSet){
        hospitalSet.setStatus(1);
        Random random = new Random();
        hospitalSet.setSignKey(MD5.encrypt(System.currentTimeMillis()+""+random.nextInt(1000)));
        boolean save = hospitalSetService.save(hospitalSet);
        if(save){
            return Result.ok();
        }else {
            return Result.fail();
        }
    }
    @GetMapping("/getHospitalById/{id}")
    public Result getHospitalById(@PathVariable(value = "id") String id){
        try {
            int a = 10 / 0;
        }catch (Exception e){
            throw new YyghException(ResultCodeEnum.SERVICE_ERROR);
        }
        HospitalSet hospitalSet = hospitalSetService.getById(id);
        return Result.ok(hospitalSet);
    }
    @PostMapping("/updateById")
    public Result updateById(@RequestBody HospitalSet hospitalSet){
        boolean flag = hospitalSetService.updateById(hospitalSet);
        if(flag){
            return Result.ok();
        }else {
            return Result.fail();
        }
    }
    @DeleteMapping("/deleteByIds")
    public Result deleteByIds(@RequestBody  List<String> ids){
        hospitalSetService.deleteByIds(ids);
        return Result.ok();
    }
    @PutMapping("/lockHospitalSet/{id}/{status}")
    public Result lockHospitalSet(@PathVariable(value = "id") String id,
                                  @PathVariable(value = "status") Integer status){
        HospitalSet hospitalSet = hospitalSetService.getById(id);
        hospitalSet.setStatus(status);
        hospitalSetService.updateById(hospitalSet);
        return Result.ok();
    }
    @PutMapping("/sendKey/{id}")
    public Result lock(@PathVariable(value = "id") String id){
        HospitalSet hospitalSet = hospitalSetService.getById(id);
        String signKey = hospitalSet.getSignKey();
        String hoscode = hospitalSet.getHoscode();
        return Result.ok(signKey+"     "+hoscode);
    }
}