package top20;

import java.util.*;

/**
 * 输入：nums = [-1,0,1,2,-1,-4]
 * <p>
 * -4,-1,-1,0,1,2
 * <p>
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Demo15 {


    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int i = 0;
        while ( i < nums.length) {
            if(i >0 && nums[i] == nums[i - 1]) {
                i++;
                continue;
            }

            if(nums[i] > 0) {
                return res;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int target = nums[i] + nums[j] + nums[k];
                if(target == 0) {
                    res.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    while( j < k && nums[j] == nums[j+ 1]) j++;
                    while(j <k && nums[k] == nums[k - 1]) k--;
                    j++;
                    k--;
                }
                else if(target < 0) j++;
                else k--;
            }
            i++;

        }
        return res;
    }


    public static void main(String[] args) {
        Demo15 demo15 = new Demo15();
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> res = demo15.threeSum(nums);
        System.out.println(res);

    }

}
