package windows;

import java.util.List;
import java.util.ArrayList;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class DemoBM52 {
    public int[] FindNumsAppearOnce (int[] nums) {
        // write code here
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int mask = 1;
        while ((xor & mask) == 0) {
            mask <<= 1;
        }
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        //需要排序
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        return new int[]{a, b};

    }
}
