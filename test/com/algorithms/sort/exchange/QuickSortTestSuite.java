package com.algorithms.sort.exchange;

import com.algorithms.data.DataRepository;
import com.algorithms.search.binary.FibonacciSearchTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RunWith(Suite.class)
@Suite.SuiteClasses({StackQuickSort.class})
public class QuickSortTestSuite {

    @BeforeSuite
    public void init(ITestContext context) {
        Map<String, List<int[]>> data = DataRepository.getData();
        context.setAttribute(DataRepository.DATA_SET_KEY, data);
    }
}
