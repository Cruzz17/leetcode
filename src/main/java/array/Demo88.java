package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: {USER}
 * @Date: {DATE} {TIME}
 * @Description:
 */
public class Demo88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null) {
            return;
        }
        if (m == 0) {
            if (n >= 0) System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        if (n == 0) {
            return;
        }
        int i = 0;


    }

    public int removeDuplicates(int[] nums) {
        int index = 0;
        int tail = 0;
        Set<Integer> set = new HashSet<>();
        while(tail < nums.length) {
            if(!set.contains(nums[tail])){
                nums[index] = nums[tail];
                set.add(nums[tail]);
            }else{
                tail++;
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        Demo88 demo88 = new Demo88();
        // 1,2,3,4,5,6,0

        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{ 3, 5, 6};
        demo88.merge(nums1, 3, nums2, 3);
    }
}
