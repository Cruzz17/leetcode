import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class VolatileAtomicityDemo {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> win = new HashMap<>();
        int n = s.length();
        int ans = 0;
        int i =0;
        int j = 0;
        while (i <= j && j < n) {
            if(win.containsKey(s.charAt(j))){
                win.remove(s.charAt(i));
                i++;
            }else {
                win.put(s.charAt(j),1);
                ans = Math.max(ans, j - i + 1);
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        VolatileAtomicityDemo demo = new VolatileAtomicityDemo();
        System.out.println(demo.lengthOfLongestSubstring("pwwkew"));
    }

}
