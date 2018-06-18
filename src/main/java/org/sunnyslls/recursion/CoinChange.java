package org.sunnyslls.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by sunny on 2/9/17.
 */
public class CoinChange {

    static int[] arr;
    static int N;

    public static void main(String[] args){
        arr = new int[] {1,2,3};
        N = 3;
        List<Integer> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        System.out.println(makeChange(N, 0, list, map));
        System.out.println(map);
        //System.out.println(new CoinChange().coinChange(arr, N));

    }

    static int makeChange(int money, int k, List<Integer> list, HashMap<String, Integer> map){
        int ways = 0;

        String key = money +"_"+arr[k];
        System.out.println(key);

        if(map.containsKey(key)){
            System.out.println("Already there "+key);
            return map.get(key);
        }

        if(money == 0){
            return 1;
        }

        else if(money < 0){
            map.put(key, 0);
            return 0;
        }

        while(k < arr.length) {
            ways += makeChange(money - arr[k], k, list, map);
            k++;
        }
        map.put(key, ways);
        return ways;
    }
}
