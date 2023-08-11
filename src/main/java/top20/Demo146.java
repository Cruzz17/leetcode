package top20;

import java.util.LinkedHashMap;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author: {USER}
 * @Date: {DATE} {TIME}
 * @Description:
 */
public class Demo146 {

    private LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
    private int capacity;
    public Demo146(int capacity){
        this.capacity = capacity;
    }

    public int get(int key) {
        return cache.getOrDefault(key, 0);
    }

    public void put(int key, int value) {
        if(cache.size() == capacity){

        }
    }
}
