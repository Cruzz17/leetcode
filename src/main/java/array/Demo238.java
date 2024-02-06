package array;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo238 {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int pre =1;
        int suf = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = pre;
            pre *= nums[i];
        }
        for (int j = nums.length - 1; j >= 0; j--) {
            res[j] *= suf;
            suf *= nums[j];
        }
        return res;
    }

    public static void main(String[] args) {
        Demo238 demo238 = new Demo238();
        int[] nums = new int[]{1,2,3,4};
        demo238.productExceptSelf(nums);
    }
}
