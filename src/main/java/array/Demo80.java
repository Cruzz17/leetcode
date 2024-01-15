package array;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo80 {
    public int removeDuplicates(int[] nums) {
        int k = 2;
        if (nums.length < k) return nums.length;

        int slow = 0, fast = k;
        while (fast < nums.length) {
            if (nums[slow ] != nums[fast]) {
                nums[slow + k] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;

    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,1,1,2,2,3};
        int res = new Demo80().removeDuplicates(nums);
        System.out.println(res);

    }
}
