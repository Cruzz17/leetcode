package top20;

import java.util.Arrays;

public class Demo88 {
    /**
     * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，
     * 分别表示 nums1 和 nums2 中的元素数目。
     * <p>
     * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
     * <p>
     * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，
     * nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，
     * 应忽略。nums2 的长度为 n 。
     * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * 输出：[1,2,2,3,5,6]
     * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
     * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = nums1.length - 1;
        int mIndex = m - 1;
        int nIndex = n - 1;
        while (index >= 0){
            if(mIndex == -1){
                nums1[index] = nums2[nIndex];
                nIndex--;
            }else if(nIndex == -1){
                nums1[index] = nums1[mIndex];
                mIndex--;
            }else if(nums1[mIndex] >= nums2[nIndex]){
                nums1[index] = nums1[mIndex];
                mIndex--;
            }else if(nums1[mIndex] < nums2[nIndex]){
                nums1[index] = nums2[nIndex];
                nIndex--;
            }
            index--;
        }
    }

    public static void main(String[] args) {
        Demo88 demo88 = new Demo88();
        int [] nums1 = new int[]{0};
        int[] nums2 = new int[]{1};
        demo88.merge(nums1, 0, nums2, 1);

        System.out.println(Arrays.toString(nums1));
    }
}
