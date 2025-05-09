package windows;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class DemoBM51 {
    public int MoreThanHalfNum_Solution (int[] numbers) {
        // write code here
        Map<Integer, Integer> cap = new HashMap<>();
        for (int number : numbers) {
            int num = cap.getOrDefault(number, 0) + 1;
            if (num >= numbers.length / 2) {
                return number;
            } else {
                cap.put(number, num);
            }
        }
        return -1;
    }
}
