package array;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo42 {
    /**
     *
     *[0,1,0,2]
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height == null) return 0;
        // 需要增加个边界，来方便计算
        Deque<Integer> stack = new LinkedList<>();
        int sum = 0;
        //寻找右侧第一个比当前值大或者相等数,从左往右构建单调递增栈
        // 右边有数比左边大，即有凹槽
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int curIndex = stack.pop();
                // 比当前值小的都pop出去
                while (!stack.isEmpty() && height[stack.peek()] == height[curIndex]){
                    stack.pop();
                }
                if(!stack.isEmpty()) {
                    sum += (Math.min(height[stack.peek()], height[i]) - height[curIndex]) * ( i - stack.peek() - 1);
                }
            }
            stack.push(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        Demo42 demo42 = new Demo42();
        int[] nums = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(demo42.trap(nums));
    }
}