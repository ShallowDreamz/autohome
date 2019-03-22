package com.test;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestExcel {
    @Test
    public void test() throws IOException, InstantiationException, IllegalAccessException, InvalidFormatException {
    /*    ExcelUtil eu = new ExcelUtil();
        eu.setExcelPath("E:\\upload\\zhb.xlsx");
        System.out.println("=======测试Excel读取========");
        List<Row> list = eu.readExcel();
        System.out.println(list.size());
        List<String> list1 = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < list.get(i).getPhysicalNumberOfCells(); j++) {
                if (j < list.get(i).getPhysicalNumberOfCells() - 1) {
                    sb.append(list.get(i).getCell(j)).append("|");
                } else {
                    sb.append(list.get(i).getCell(j));
                }
            }
            list1.add(sb.toString());
        }*/
        //System.out.println(list1.toString());
        /*test1(list1);*/
        /*List list2 =  getBeans("E:\\upload\\zhb.xlsx", RequestExcelParam.class);
        for (int i = 0; i < list2.size(); i++) {
            System.out.println(list2.get(i).toString());
        }*/
    }
    public void test1(List<String> list){
        String title = list.get(0);
        System.out.println(title);
        String arr[] = StringUtils.split(title,'|');
        Map<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < list.size(); j++) {
                String param[] = StringUtils.split(list.get(j),'|');
                for (int k = i; k < param.length; k++) {
                    map.put(arr[i], param[k]);
                }
                break;
            }
        }

        for(Map.Entry entry : map.entrySet()){
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }


}
