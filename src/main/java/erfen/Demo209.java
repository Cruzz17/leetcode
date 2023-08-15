package erfen;

/**
 * @Author: {USER}
 * @Date: {DATE} {TIME}
 * @Description:给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组
 * [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * <p>
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 */
public class Demo209 {
    public int minSubArrayLen(int target, int[] nums) {
        //
        int res = Integer.MAX_VALUE;
        int l = 0;
        int r = 0;
        int valid = 0;
        while (r < nums.length) {
            // 如果小于则移动r，如果大于则移动l
            int temp = nums[r];
            r++;
            valid+=temp;
            while (valid >= target){
                res = Math.min(res, r - l );
                valid -= nums[l++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        Demo209 demo209 = new Demo209();
        int[] nums = new int[]{1,2,3,4,5};
        System.out.println(demo209.minSubArrayLen(11, nums));
    }
}
