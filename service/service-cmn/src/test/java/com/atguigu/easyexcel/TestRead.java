package com.atguigu.easyexcel;

import com.alibaba.excel.EasyExcel;

import java.util.List;
import java.util.Map;

/**
 * @author: xia liang
 * @create: 2021/04/03 16:14
 */
public class TestRead {
    public static void main(String[] args) {
        //读取文件路径
        String fileName = "D:\\excel\\01.xlsx";
        //调用方法实现读取操作
        EasyExcel.read(fileName,UserData.class,new ExcelListener()).sheet().doRead();
        List<UserData> list = ExcelListener.list;
        Map<Integer, String> map = ExcelListener.map;
        System.out.println("list:"+list);
        System.out.println("map:"+map);
    }
}
