package org.sunnyslls.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sunny on 5/9/17.
 */
public class Knapsack {

    static int N;
    static int[] arr;
    static int[] priceArr;
    static int maxPrice = Integer.MIN_VALUE;

    public static void main(String[] args){
        priceArr = new int[]{60, 100, 120};
        arr = new int[] {10, 20, 30};
        N = 50;
        System.out.println(enumerate(0, N, 0, new HashMap<>()));
    }

    static int enumerate(int k, int weight, int price, Map<String, Integer> map){

        if(weight == 0){
            return price;
        }

        if(k >= arr.length){
            return 0;
        }

        String key = weight+"_"+arr[k];
        System.out.println(key);

        if(map.containsKey(key)){
            return map.get(key);
        }

        while(k < arr.length){
            int current = weight - arr[k];
            if(current < 0){
                k++;
                continue;
            }
            int currentPrice = enumerate(k+1, current, price + priceArr[k], map);
            maxPrice = Math.max(currentPrice, maxPrice);
            k++;
        }
        map.put(key, maxPrice);
        return maxPrice;
    }
}
