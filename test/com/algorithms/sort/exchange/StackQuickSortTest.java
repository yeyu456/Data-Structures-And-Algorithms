package com.algorithms.sort.exchange;

import com.algorithms.data.DataRepository;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
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
        this.scaleIndex++;
        if (this.scaleIndex >= DataRepository.DATA_SET_SCALE) {
            this.typeIndex++;
            this.scaleIndex = 0;
        }
        Map<String, List<int[]>> map = (Map<String, List<int[]>>) context.getAttribute(DataRepository.DATA_SET_KEY);
        int[] oData = map.get(DataRepository.DATA_TYPE[this.typeIndex]).get(this.scaleIndex);
        this.data = new int[oData.length];
        System.arraycopy(oData, 0, this.data, 0, oData.length);
    }

    @Test(invocationCount = 25)
    public void sort() throws Exception {
        QuickSort sort = new StackQuickSort();
        long count = sort.sort(this.data);
        System.out.println("Stack quick sort with type:" +
                DataRepository.DATA_TYPE[this.typeIndex] + " scale:" + this.scaleIndex + " count:" + count);
    }

    @AfterMethod
    public void valid() {
        int max = this.data.length - 1;
        int time = 0;
        for (int i = 0; i <= max; i++) {
            if (i != max && this.data[i] > this.data[i+1]) {
                time++;
                System.out.println("Error with type:" +
                        DataRepository.DATA_TYPE[this.typeIndex] + " scale:" + this.scaleIndex + " time:" + time);
            }
        }
        if (time == 0) {
            System.out.println("Success with type:" +
                    DataRepository.DATA_TYPE[this.typeIndex] + " scale:" + this.scaleIndex);
        }
    }
}