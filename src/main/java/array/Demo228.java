package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo228 {
    /**
     * 输入：nums = [0,1,2,4,5,7]
     * 输出：["0->2","4->5","7"]
     * 解释：区间范围是：
     * [0,2] --> "0->2"
     * [4,5] --> "4->5"
     * [7,7] --> "7"
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if ( j + 1 == nums.length || nums[j] + 1 != nums[j + 1]) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(nums[i]);
                if(i != j) {
                    stringBuilder.append("->").append(nums[j]);
                }
                res.add(stringBuilder.toString());
                i = j + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Demo228 demo228 = new Demo228();
        int[] nums = new int[]{0,1,2,4,5,7};
        System.out.println(demo228.summaryRanges(nums));
    }
}
