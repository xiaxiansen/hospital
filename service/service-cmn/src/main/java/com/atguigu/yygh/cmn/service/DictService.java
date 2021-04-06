package com.atguigu.yygh.cmn.service;

import com.atguigu.yygh.model.cmn.Dict;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface DictService  {
    
    //导出数据字典接口
    void exportDictData(HttpServletResponse response);
    
    /**
     * 根据数据id查询子数据列表
     * @param id
     * @return
     */
    List<Dict> findChlidData(Long id);
}
