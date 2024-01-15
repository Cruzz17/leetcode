package pdd;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo27 {
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[j] =nums[i];
                j++;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        Demo27 demo27 = new Demo27();
        int [] nums = new int[]{ 3,2,2,3};
        System.out.println(demo27.removeElement(nums,3));

    }
}
