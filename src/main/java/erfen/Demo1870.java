package erfen;

import java.util.Map;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo1870 {
    public int minSpeedOnTime(int[] dist, double hour) {
        int left = 1;
        int right = 10000000;
        int res = -1;
        if(hour <= dist.length - 1) {
            return -1;
        }
        // 这里不对，这样结果不对

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(arrive(dist, hour, mid)) {
                res = mid;
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return res;
    }

    public boolean arrive(int[] dist, double hour, int speed) {
        double time = 0;

        for(int i = 0; i < dist.length; i++) {
            if(i != dist.length - 1) {
                time += Math.ceil((double) dist[i] / speed);
            }else {
                time += (double) dist[i] / speed;

            }
        }
        return time <= hour;
    }
}
