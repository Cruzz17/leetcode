package array;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo452 {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        return 1;
    }
    public static void main(String[] args) {
        Demo452 demo452 = new Demo452();
        int[][] points = {{-2147483646,-2147483645},{2147483646,2147483647}};
        int result = demo452.findMinArrowShots(points);
        System.out.println(result); // Output: 2
    }
}
