package com.quanlycauvn.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Utils {
    public static Date StringToDateMySql(String date) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(date);
    }

    public static List<String> readLineByLineTxtFile(String path) throws IOException {
        List<String> allLines = Files.readAllLines(Paths.get(path));
        return allLines;
    }
}
