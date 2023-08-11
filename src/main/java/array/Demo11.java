package array;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * @Author: {USER}
 * @Date: {DATE} {TIME}
 * @Description:
 */
public class Demo11 {
    public int maxArea(int[] height) {

        int res = 0;
        int len = height.length;
        int l = 0;
        int r = len -1;
        while(l < r){
            res = Math.max(res, (r - l) * Math.min(height[r],height[l]));
            if(height[l] > height[r]){
                r--;
            }else {
                l++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        // 创建 Gson 对象
        Demo11 demo11= new Demo11();
        int[] arr = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(demo11.maxArea(arr));
    }


}
