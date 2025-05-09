package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: san.m
 * Date:  {DATE} {TIME}
 * Description:
 */
public class Demo {


    public void test(List<Integer> list) {
        list.add(6);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        Demo demo = new Demo();
        demo.test(list);
        System.out.println(list);
    }
}
