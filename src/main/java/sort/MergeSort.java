package sort;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class MergeSort {
    public void mergeSort(int[] arr, int left, int right) {
        if(left< right) {
            int mid = (left + right) >>> 1;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int l = left;
        int r = mid + 1;
        int i = 0;
        while (l <= mid && r <= right) {
            if(arr[l] <= arr[r]) {
                temp[i++] = arr[l++];
            } else {
                temp[i++] = arr[r++];
            }
        }
        while (l <= mid) {
            temp[i++] = arr[l++];
        }
        while (r <= right) {
            temp[i++] = arr[r++];
        }
        System.arraycopy(temp, 0, arr, left, temp.length);
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] arr = {3, 2, 1, 4, 5, 6, 7, 8, 9};
        mergeSort.mergeSort(arr, 0, arr.length - 1);
        for(int i : arr) {
            System.out.println(i);
        }
    }
}
