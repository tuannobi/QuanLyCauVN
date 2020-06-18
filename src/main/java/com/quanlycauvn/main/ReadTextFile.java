package com.quanlycauvn.main;

import com.quanlycauvn.util.ReadFileUtil;

import java.io.IOException;
import java.util.List;

public class ReadTextFile {
    public static void main(String[] args) throws IOException {
        ReadFileUtil readFileUtil=new ReadFileUtil();
        List<String> line=readFileUtil.readTextFile("TaiTrongThietKe.txt");
        System.out.println(line);
    }
}
