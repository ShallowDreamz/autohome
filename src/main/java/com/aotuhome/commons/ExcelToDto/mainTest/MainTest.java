package com.aotuhome.commons.ExcelToDto.mainTest;

import com.aotuhome.commons.BatchParameterNormalization;
import com.aotuhome.commons.ExcelToDto.dto.ExcelDto;
import com.aotuhome.commons.ExcelToDto.Utils.ExcelToDto;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

public class MainTest {
    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException, InvalidFormatException {
        File f = new File("E:\\upload\\zzhtestdata1.xlsx");
        ExcelToDto e = new ExcelToDto();
        //System.out.println(e.readExcel(f, ExcelDto.class));
        List<ExcelDto> list = e.readExcel(f, ExcelDto.class);
        BatchParameterNormalization parameterNormalization = new BatchParameterNormalization();
        HashMap<String,String> map = parameterNormalization.paramOverWrite(list.get(0).getParameters());
        for(Map.Entry entry : map.entrySet()){
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
        System.out.println(list.get(0));
    }
    public SortedMap get(){
        return null;
    }
}
