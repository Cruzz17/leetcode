package array;

import java.util.Arrays;
import java.util.Map;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo135 {

    /**
     * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
     * <p>
     * 你需要按照以下要求，给这些孩子分发糖果：
     * <p>
     * 每个孩子至少分配到 1 个糖果。
     * 相邻两个孩子评分更高的孩子会获得更多的糖果。
     * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：ratings = [1,0,2]
     * 输出：5
     * 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
     * 示例 2：
     * <p>
     * 输入：ratings = [1,2,2,1,3,4]
     * 输出：          1,2,2,1,2,3 = 11
     *                1,1,2,1,2,3
     * 解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
     * 第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
     *
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        Arrays.fill(candy, 1);
        for (int i = 0; i < ratings.length; i++) {
            int l = i - 1;
            int r = i + 1;
            if (l >= 0) {
                if (ratings[l] < ratings[i]) {
                    candy[i] = candy[l] + 1;
                }
            }
            if (r < ratings.length) {
                if (ratings[r] < ratings[i]) {
                    candy[i] = Math.max(candy[r] + 1, candy[i]);
                }
            }
        }
        for (int i = ratings.length - 1; i >= 0; i--) {
            int l = i - 1;
            int r = i + 1;
            if (l >= 0) {
                if (ratings[l] < ratings[i]) {
                    candy[i] = candy[l] + 1;
                }
            }
            if (r < ratings.length) {
                if (ratings[r] < ratings[i]) {
                    candy[i] = Math.max(candy[r] + 1, candy[i]);
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < candy.length; i++) {
            sum += candy[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Demo135 demo135 = new Demo135();

        int[] nums = new int[]{1,2,87,87,87,2,1};
        System.out.println(demo135.candy(nums));
    }
}
