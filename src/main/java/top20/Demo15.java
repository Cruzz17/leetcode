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
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int l = i + 1;
            int r = len - 1;
            while (l < r){
                int temp = nums[i] + nums[l] + nums[r];
                if(temp == 0){
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l+1] == nums[l]) l++;
                    while (l < r && nums[ r-1]== nums[r]) r--;
                    l++;
                    r--;
                }else if(temp > 0){
                    r--;
                }else{
                    l++;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Demo15 demo15 = new Demo15();
        int[] nums = new int[]{-4,-1,0,1,2};
        List<List<Integer>> res = demo15.threeSum(nums);
        System.out.println(res);

    }

}
