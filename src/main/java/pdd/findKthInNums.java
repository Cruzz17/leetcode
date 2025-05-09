package pdd;

/**
 * @Author: {USER}
 * @Date: {DATE} {TIME}
 * @Description:
 */
public class findKthInNums {

    public int getKthElement(int[] nums1, int[] nums2, int k) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int index1= 0;
        int index2=0;
        while(true) {
            // 说明n1的都被排除了，那么n2的就是k大的
            if(index1 == l1) {
                return nums1[index2 + k -1];
            }
            if(index2 == l2) {
                return nums2[index1 + k - 1];
            }
            if(k == 1) {
                return Math.min(nums1[index1],nums2[index2]);
            }
            int half = k /2;
            int newIndex1 = Math.min((index1 + half), l1) - 1;
            int newIndex2 = Math.min((index2 + half), l2) - 1;
            int pivot1 = nums1[newIndex1];
            int pivot2 = nums2[newIndex2];
            if(pivot1 <= pivot2) {
                k -= newIndex1 -index1 + 1;
                index1 = newIndex1 +1;
            }else {
                k -= newIndex2 - index2 + 1;
                index2 = newIndex2 + 1;
            }

        }

    }

    public static void main(String[] args) {
        findKthInNums solution = new findKthInNums();
        int[] nums1 = {1, 3, 5};
        int[] nums2 = {2, 4, 6};
        int k = 4;
        System.out.println("The " + k + "th smallest element is: " + solution.getKthElement(nums1, nums2, k));
    }
}
