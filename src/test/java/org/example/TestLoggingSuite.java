package org.example;

import org.example.data.LogLine;
import org.example.helper.Helper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class TestLoggingSuite extends BaseTest {
    @BeforeMethod
    public void setup() {
        super.setup();
    }

    @Test
    public void testLogDuplicates() {
        Map<LogLine, Integer> data = Helper.calculateData(super.dataList);

        for (Map.Entry<LogLine, Integer> entry : data.entrySet()) {
            Assert.assertEquals((int) entry.getValue(), 1, "Repeated value!!!" + entry.getKey());
        }
    }

}
