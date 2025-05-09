package stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class DemoBM48 {
    Map<Integer, Integer> cap =new HashMap<>();
    private int index = 0;

    public void Insert(Integer num) {
        cap.put(index++, num);
    }

    public Double GetMedian() {
        int size = cap.size();
        if (size == 0) return 0.0;
        if(size % 2 == 0) {
            return (cap.get(size / 2) + cap.get(size / 2 - 1)) / 2.0;
    }
        return cap.get(size / 2) * 1.0;
    }
}
