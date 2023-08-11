package pdd;

/**
 * @Author: {USER}
 * @Date: {DATE} {TIME}
 * @Description:
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数nums1 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 *
 * 先合成一个数组，然后 用二分法
 *

 */
public class Demo2 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int i=0,j=0,k = 0;
        int[] res = new int[m+n];
        while (i < m && j < n ){
            if(nums1[i] <= nums2[j]){
                res[k++] = nums1[i++];
            }else {
                res[k++] = nums2[j++];
            }
        }
        while (i < m){
            res[k++] = nums1[i++];
        }
        while (j < n){
            res[k++] = nums2[j++];
        }
        int mid = (m + n) /2;
        if ((m+n)%2 ==0){
            return (res[mid - 1] + res[mid]) / 2.0;
        }else {
            return res[mid];
        }
    }





}
