package array;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo167 {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;

        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target)
                return new int[]{i + 1, j + 1};
            else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{i + 1, j + 1};
    }

    public static void main(String[] args) {
        Demo167 demo167 = new Demo167();
        int[] nums = new int[]{1, 4, 6, 8};
        demo167.twoSum(nums, 10);
    }
}
