package string;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo125 {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        s = s.toLowerCase();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(('0' <= c && c <= '9')||('a'<= c && c <= 'z')){
                stringBuilder.append(c);
            }
        }
        while (l < r) {
            if(stringBuilder.charAt(l) != stringBuilder.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
