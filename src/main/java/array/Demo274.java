package array;

import java.util.Arrays;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo274 {

    // [3,4,6,1,5]
    /*
    找出一个数，并且有几个数，大于这个长度
     */
    public int hIndex(int[] citations) {
        int len = citations.length;
        Arrays.sort(citations);
        int count = 0;// 引用次数
        for (int i = len - 1; i >= 0; i--) {
            if (citations[i] > 0) count++;
            if (count > citations[i]) return len - i - 1;
        }
        return count;
    }

    public int hIndex1(int[] citations) {
        int l = 0;
        int r = citations.length;
        int mid = 0;
        int cnt = 0;
        while (l < r) {
            mid = (l + r + 1) >>1;
            cnt = 0;
            for (int i = 0; i < citations.length; i++) {
                if(citations[i] >= mid) cnt++;
            }
            if (cnt >= mid) l = mid;
            else r = mid - 1;
        }
        return l;

    }

    public static void main(String[] args) {
        Demo274 demo274 = new Demo274();
        int[] nums = new int[]{0, 0, 4, 4};
        int[] nums1 = new int[]{1, 3, 4, 5, 6};
        //6,5,4,3,2,1
        System.out.println(demo274.hIndex1(nums));
        System.out.println(demo274.hIndex1(nums1));
    }
}
