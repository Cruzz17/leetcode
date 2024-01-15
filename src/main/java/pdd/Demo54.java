package pdd;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 * [[1,2,3],
 * [4,5,6],
 * [7,8,9]]
 */
public class Demo54 {

    public String directionRight = "right";
    public String direction_Down = "down";
    public String directionLeft = "left";
    public String directionUp = "up";

    public List<Integer> spiralOrder(int[][] matrix) {

        int i = 0, j = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;
        String direction = directionRight;
        boolean[][] visited = new boolean[m][n];
        List<Integer> result = new ArrayList<>();
        while (count < m * n) {
            if (direction.equals(directionRight)) {
                while (j < n && !visited[i][j]) {
                    visited[i][j] = true;
                    count++;
                    result.add(matrix[i][j]);
                    j++;
                }
                j--;
                i++;
                direction = direction_Down;
            } else if (direction.equals(direction_Down)) {
                while (i < m && !visited[i][j]) {
                    visited[i][j] = true;
                    count++;
                    result.add(matrix[i][j]);
                    i++;

                }
                i--;
                j--;
                direction = directionLeft;
            } else if (direction.equals(directionLeft)) {
                while (j >= 0 && !visited[i][j]) {
                    visited[i][j] = true;
                    count++;
                    result.add(matrix[i][j]);
                    j--;

                }
                j++;
                i--;
                direction = directionUp;
            } else if (direction.equals(directionUp)) {
                while (i >= 0 && !visited[i][j]) {
                    visited[i][j] = true;
                    count++;
                    result.add(matrix[i][j]);
                    i--;

                }
                i++;
                j++;
                direction = directionRight;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        Demo54 demo54 = new Demo54();
        List<Integer> integers = demo54.spiralOrder(matrix);
        System.out.println(integers);
    }
}
