package array;

/**
 * @Author: {USER}
 * @Date: {DATE} {TIME}
 * @Description:
 */
public class Demo283 {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                nums[index++] = nums[i];
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }


    }



    public static void main(String[] args) {
        Demo283 demo283 = new Demo283();
        int[] arr = new int[]{0,0,1};
        demo283.moveZeroes(arr);
    }
}
