package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public int[][] merge2(int[][] intervals) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] index = intervals[0];
        int start = index[0];
        int end = index[1];
        for(int i = 1; i < intervals.length; i++) {
            int[] temp = intervals[i];
            int newStart=temp[0];
            int newEnd = temp[1];
            if(newStart > end) {
                res.add(start);
                res.add(end);
                start = newStart;
                end = newEnd;
            }else {
                start = Math.min(start, newStart);
                end = newEnd;
            }
        }
        res.add(start);
        res.add(end);
        int[][] cur = new int[res.size()/2][2];
        int j = 0;
        for(int i = 0;i < res.size() /2; i++) {
            int[] temp = new int[2];
            temp[0] = res.get(j++);
            temp[1] = res.get(j++);
            cur[i] = temp;
        }
        return cur;
    }

    public static void main(String[] args) {
        Demo56 demo56 = new Demo56();
        int[][] intervals = new int[][]{{1, 4}, {0, 4}, {8, 10}, {15, 18}};
        demo56.merge2(intervals);
    }
}
