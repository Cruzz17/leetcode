package array;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo58 {
    public int lengthOfLastWord(String s) {
        s= s.trim();
        int res = 0;
        for (int i = s.length() -1; i >0 ; i--) {
            if(s.charAt(i)==' '){
                return res;
            }else {
                res++;
            }
        }
        return res;
    }
}
