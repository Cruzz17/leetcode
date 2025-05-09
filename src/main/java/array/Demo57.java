package array;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        // Add all intervals that come before the new interval
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }
        // Merge overlapping intervals
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        // Add the merged interval
        res.add(newInterval);
        // Add all intervals that come after the new interval
        while (i < intervals.length) {
            res.add(intervals[i]);
            i++;
        }
        // Convert the list to a 2D array
        int[][] result = new int[res.size()][2];
        for (int j = 0; j < res.size(); j++) {
            result[j] = res.get(j);
        }
        return result;
    }
    public static void main(String[] args) {
        Demo57 demo57 = new Demo57();
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        int[][] result = demo57.insert(intervals, newInterval);
        for (int[] interval : result) {
            System.out.print("[" + interval[0] + ", " + interval[1] + "] ");
        }
    }
}
