package com.quanlycauvn.main;

import com.quanlycauvn.util.ReadFileUtil;

import java.io.IOException;
import java.util.List;

public class ReadFileExel {
    public static void main(String[] args) throws IOException {
        ReadFileUtil readFileUtil =new ReadFileUtil();
        List<List<String>> data= readFileUtil.getValues();
        for(List<String> temp:data){
            int i=0;
            for(String row:temp){
                System.out.println(i++);
                System.out.print(row+" ");
            }
            System.out.println();
        }
    }
}
