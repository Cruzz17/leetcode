package string;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo125 {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<s.length(); i++) {
            Character c = s.charAt(i);
            if(Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
        }
        String str = sb.toString().toLowerCase();
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if(str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
