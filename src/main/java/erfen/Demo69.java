package erfen;

/**
 * @Author: {USER}
 * @Date: {DATE} {TIME}
 * @Description:
 */
public class Demo69 {
    public int mySqrt(int x) {
        int l = 0;
        int r = x;
        while( l <= r) {
            int mid = l + ( r - l) / 2;
            long temp = (long)mid * mid;
            if((temp) == x) {
                return mid;
            }else if( temp > x) {
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }

        return l - 1;
    }

    public static void main(String[] args) {
        Demo69 demo69 = new Demo69();
        System.out.println(demo69.mySqrt(2147395599));
    }
}
