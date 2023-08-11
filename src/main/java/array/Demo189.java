package array;

/**
 * @Author: {USER}
 * @Date: {DATE} {TIME}
 * @Description: 1 2 3 4 5 6 7
 * 向右轮转 2 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]*
 */
public class Demo189 {
    public void rotate(int[] nums, int k) {
        if(k > nums.length ){
            k = k % nums.length;
        }
        int[] temp = new int[k];
        System.arraycopy(nums, nums.length - k, temp, 0, k);
        System.arraycopy(nums, 0, nums, k, nums.length - k);
        System.arraycopy(temp, 0, nums, 0, k);
    }

}
