package org.example;

import org.example.data.LogLine;
import java.util.List;
import org.example.utils.Reader;

public class BaseTest {
    protected List<LogLine> dataList;

    public void setup() {
        dataList = Reader.readUsingFileReader("src/test/resources/data.log");
    }
}
