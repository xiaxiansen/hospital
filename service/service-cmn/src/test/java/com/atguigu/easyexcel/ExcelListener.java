package com.atguigu.easyexcel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: xia liang
 * @create: 2021/04/03 16:11
 */
public class ExcelListener  extends AnalysisEventListener<UserData> {
    static List<UserData> list = new ArrayList<>();
    static Map<Integer,String> map = new HashMap<>();
    //一行一行读取excel内容
    @Override
    public void invoke(UserData userData, AnalysisContext analysisContext) {
//        System.out.println(userData);
        list.add(userData);
    }
    
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
//        System.out.println("表头信息:"+headMap);
        map = headMap;
    }
    
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
    
    }
}
