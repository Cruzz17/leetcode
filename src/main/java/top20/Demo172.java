package top20;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo172 {

    public int trailingZeroes(int n) {
        int cnt = 0;
        while (n > 0) {
            cnt += n / 5;
            n /= 5;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Demo172 demo172 = new Demo172();
        System.out.println(demo172.trailingZeroes(10));
    }
}
