package array;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo56 {
    public int[][] merge(int[][] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[i][0] > intervals[j][0]) {
                    int[] temp = intervals[i];
                    intervals[i] = intervals[j];
                    intervals[j] = temp;
                }
            }
        }
        int[][] res = new int[intervals.length][2];
        int index = -1;
        for (int i = 0; i < intervals.length; i++) {
            if (index == -1 || res[index][1] < intervals[i][0]) {
                res[++index] = intervals[i];
            } else {
                res[index][1] = Math.max(res[index][1], intervals[i][1]);
            }
        }
        int[][] result = new int[index + 1][2];
        for (int i = 0; i <= index; i++) {
            result[i] = res[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Demo56 demo56 = new Demo56();
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        demo56.merge(intervals);
    }
}
