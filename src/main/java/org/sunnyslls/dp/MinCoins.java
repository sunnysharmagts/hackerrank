package org.sunnyslls.dp;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by sunny on 5/8/17.
 */
public class MinCoins {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[m];
        for(int i = 0; i < m; i++){
            arr[i] = scanner.nextInt();
        }

        MinCoins coinChange = new MinCoins();
        //System.out.println(coinChange.coinChange(arr, n, n, 0));
        System.out.println(coinChange.minCoins(arr, n, 0, new HashMap<String, Long>()));
    }

    private long minCoins(int[] arr, int n, int total, int k){
        if(total == 0){
            return 1;
        }
        if(total < 0 || total > n || k >= arr.length){
            return 0;
        }
        long count = minCoins(arr, n, total-arr[k], k);
        count += minCoins(arr, n, total, k+1);
        return count;
    }

    private long minCoins(int[] arr, int money, int k, HashMap<String, Long> map){

        if(money == 0){
            return 1;
        }

        if(k >= arr.length){
            return 0;
        }

        String key = money +" with coin " +arr[k];
        if(map.containsKey(key)){
            return map.get(key);
        }
        int amountWithCoin = 0;
        long ways = 0;
        while(amountWithCoin <= money){
            int remaining = money - amountWithCoin;
            System.out.println(key +" , "+ remaining);
            ways += minCoins(arr, remaining, k + 1, map);
            amountWithCoin += arr[k];
        }
        map.put(key, ways);
        return ways;
    }
}
