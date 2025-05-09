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
        int l = 0;
        if(nums.length == 0) return res;
        while(l < nums.length){
            StringBuilder sb = new StringBuilder();
            int temp = nums[l];
            sb.append(nums[l]);
            while(l < nums.length - 1 && nums[l+1] == nums[l] + 1){
                l++;
            }
            if(nums[l] == temp){
                res.add(sb.toString());
            }else {
                sb.append("-->");
                sb.append(nums[l]);
                res.add(sb.toString());
            }
            l++;
        }
        return res;
    }

    public static void main(String[] args) {
        Demo228 demo228 = new Demo228();
        int[] nums = new int[]{0,1,2,4,5,7};
        System.out.println(demo228.summaryRanges(nums));
    }
}
