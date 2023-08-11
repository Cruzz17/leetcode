package array;

import java.util.Arrays;

/**
 * @Author: {USER}
 * @Date: {DATE} {TIME}
 * @Description:
 */
public class Demo88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, nums1.length);
            return;
        }
        int l1 = 0;
        int l2 = 0;
        int index1 = 0;
        while (index1 < m && l2 < n) {
            if (nums1[l1] <= nums2[l2]) {
                l1++;
                index1++;
            } else {
                removeOneIndex(nums1, l1);
                nums1[l1] = nums2[l2];
                l2++;
                l1++;
            }
        }

        if ( l2 < n) {
            for (int i = l1 ; i < nums1.length; i++) {
                if(l2 == n) break;
                nums1[i] = nums2[l2++];
            }
        }
    }

    public void removeOneIndex(int[] nums, int index) {
        for (int i = nums.length - 1; i > index ; i--) {
            nums[i] = nums[i-1];
        }
    }

    public static void main(String[] args) {
        Demo88 demo88 = new Demo88();
        // 1,2,3,4,5,6,0

        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{1};
        demo88.merge(nums1,0,nums2,1);
        System.out.println(Arrays.toString(nums1));
    }
}
