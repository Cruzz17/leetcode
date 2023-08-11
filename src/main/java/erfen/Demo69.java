package erfen;

/**
 * @Author: {USER}
 * @Date: {DATE} {TIME}
 * @Description:
 */
public class Demo69 {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long tar = (long) mid * mid;
            if (tar == x) {
                return mid;
            } else if (tar < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            res = left;
        }
        while (res * res > x){
            res--;

        }
        return res;
    }

    public static void main(String[] args) {
        Demo69 demo69 = new Demo69();
        System.out.println(demo69.mySqrt(2147395599));
    }
}
