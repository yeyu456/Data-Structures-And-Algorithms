package com.algorithms.sort.exchange;

import com.algorithms.data.DataRepository;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;

import java.util.List;
import java.util.Map;

public class QuickSortTestSuite {

    @BeforeSuite
    public void init(ITestContext context) {
        Map<String, List<int[]>> data = DataRepository.getData();
        context.setAttribute(DataRepository.DATA_SET_KEY, data);
    }
}
