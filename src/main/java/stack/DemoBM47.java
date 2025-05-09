package stack;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class DemoBM47 {
    public int findKth(int[] a, int n, int K) {
        // write code here
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int mid = quickSort(a, l, r);
            if (mid == K - 1) {
                return a[mid];
            } else if (mid < K - 1) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return a[l];
    }

    public int quickSort(int[] a, int left, int right) {
        int pivot = a[left];
        int l = left + 1;
        int r = right;
        while (l <= r) {
            while (l <= r && a[l] >= pivot) {
                l++;
            }
            while (l <= r && a[r] < pivot) {
                r--;
            }
            if (l < r) {
                swap(a, l, r);
            }

        }
        swap(a, left, r);
        return r;
    }

    public void swap(int[] num, int l, int r) {
        int temp = num[l];
        num[l] = num[r];
        num[r] = temp;
    }

    public static void main(String[] args) {
        DemoBM47 demoBM47 = new DemoBM47();
        int[] num = {1, 3, 5, 2, 2};
        int res = demoBM47.findKth(num, num.length, 3);
        System.out.println(res);
    }
}
