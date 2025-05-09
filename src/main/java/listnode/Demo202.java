package listnode;

import java.util.HashSet;
import java.util.Set;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo202 {

    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(n != 1 && !set.contains(n)){
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    public static void main(String[] args) {
        Demo202 demo202 = new Demo202();
        boolean result = demo202.isHappy(19);
        System.out.println(result);
    }

}
