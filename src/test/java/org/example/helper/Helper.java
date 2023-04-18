package org.example.helper;

import org.example.data.LogLine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Helper {

    private Helper() {
    }

    public static Map<LogLine, Integer> calculateData(List<LogLine> list){
        Map<LogLine, Integer> map = new HashMap<>();
        for (LogLine data : list) {
            if (map.containsKey(data)) {
                int count = map.get(data);
                map.put(data, count + 1);
            } else {
                map.put(data, 1);
            }
        }
        return map;
    }

}
