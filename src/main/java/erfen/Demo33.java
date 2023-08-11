package erfen;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: {USER}
 * @Date: {DATE} {TIME}
 * @Description:
 */
public class Demo33 {
    public int search(int[] nums, int target) {
        int res = -1;
        int length = nums.length;
        if (length == 1) {
            if (nums[0] == target) return 0;
            else return -1;
        }
        int l = 0;
        int r = length -1;
        while (l < r){
            int mid = l + (r - l) / 2;
            if(target == nums[mid]){
                return mid;
            }
            // 如果左边比右边小，那就说明，左边是递增的
            else if (nums[l] < nums[mid]){
                //如果比左边的小或者比右边的大，那么说明可能在另一边
                if(target < nums[l] || target > nums[mid]){
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }

            }// 如果左边比右边大，则说明右边是递增的
            else {
                if(target == nums[r]){
                    return r;
                }else if (target < nums[mid] || target > nums[r]) {
                    r = mid - 1;
                }
                else {
                    l = mid + 1;
                }
            }
        }
        if(nums[l] == target){
            res = l;
        }

        return res;
    }

    public static void main(String[] args) throws Exception {
        Demo33 demo33 = new Demo33();
        int[] nums = new int[]{3,1};
        System.out.println(demo33.search(nums, 1));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String s = "2023-07-12 13:53:28";

        Timestamp timestamp = Timestamp.valueOf(s);
        String result = sdf.format(timestamp);
        System.out.println(result);
    }
}
