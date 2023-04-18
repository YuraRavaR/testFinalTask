package org.example.utils;

import org.example.data.LogLine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    private Reader() {
    }
    public static List<LogLine> readUsingFileReader(String filePath) {
        List<LogLine> dataList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains("TMobClient3")) {
                    String[] splitStr = line.split("\\s+");
                    String data = splitStr[0] + " " + splitStr[1];
                    String id = "";
                    String type = "";
                    String status = "";
                    if (line.contains("Send:")) {
                        type = "Send";
                        String[] idArr = line.split("\"id\":")[1].split(",");
                        id = idArr[0];
                    } else if (line.contains("Http Code: 200")) {
                        type = "Response";
                        status = "Http Code: 200";
                        String[] idArr = line.split("\"id\":")[1].split("}");
                        id = idArr[0];
                    }
                    LogLine logLine = new LogLine(data, id, type, status);
                    dataList.add(logLine);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataList;
    }
}
