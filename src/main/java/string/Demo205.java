package string;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo205 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            if(!map.containsKey(s.charAt(i))){
                if(map.containsValue(t.charAt(i))){
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
            }else{
                if(map.get(s.charAt(i))!=t.charAt(i)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Demo205 demo205 = new Demo205();
        System.out.println(demo205.isIsomorphic("paper","title"));
    }
}
