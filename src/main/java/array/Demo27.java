package array;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo27 {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int count = 0;
        int j = nums.length - 1;
        while( i < j) {
            while( i <= j &&nums[i] != val) i++;
            while(i <= j && nums[j] == val) j--;
            if(i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }
        for (int k = 0; k < nums.length; k++) {
            if(nums[k] != val) {
                count++;
            }
        }

        return count;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Demo27 demo27 = new Demo27();
        int[] nums = new int[]{3,2,2,3};
        System.out.println(demo27.removeElement(nums, 3));
    }
}
