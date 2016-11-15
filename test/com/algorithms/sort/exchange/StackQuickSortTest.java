package com.algorithms.sort.exchange;

import com.algorithms.data.DataRepository;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class StackQuickSortTest {

    private int typeIndex = 0;
    private int scaleIndex = -1;
    private int[] data;

    @BeforeMethod
    public void before(ITestContext context) {
//        this.scaleIndex++;
//        if (this.scaleIndex >= DataRepository.DATA_SET_SCALE) {
//            this.typeIndex++;
//            this.scaleIndex = 0;
//        }
//        Map<String, List<int[]>> map = (Map<String, List<int[]>>) context.getAttribute(DataRepository.DATA_SET_KEY);
//        int[] oData = map.get(DataRepository.DATA_TYPE[this.typeIndex]).get(this.scaleIndex);
//        this.data = new int[oData.length];
//        System.arraycopy(oData, 0, this.data, 0, oData.length);
        this.data = DataRepository.getRandomData(20, 100);
    }

    @Test(invocationCount = 1)
    public void sort() throws Exception {
        QuickSort sort = new QuickSort();
        long count = sort.sort(this.data);
        System.out.println("Stack quick sort with type:" +
                DataRepository.DATA_TYPE[this.typeIndex] + " scale:" + this.scaleIndex + " count:" + count);
    }

}