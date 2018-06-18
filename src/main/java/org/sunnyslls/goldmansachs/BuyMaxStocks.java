package org.sunnyslls.goldmansachs;

/**
 * Created by sunny on 19/8/17.
 */

import java.util.Scanner;

public class BuyMaxStocks {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        long k = in.nextLong();
        long result = buyMaximumProducts(n, k, arr);
        System.out.println(result);
        in.close();
    }

    static long buyMaximumProducts(int n, long k, int[] a) {
        long maxStocks = 0;
        long day = 1;
        for(int stock : a){
            if(k < stock){
                day++;
                continue;
            }
            long stockToBuy = stock * day;
            if(k < stockToBuy){
                while(k >= stock){
                    k = k - stock;
                    maxStocks++;
                }
            }
            else {
                k = k - stockToBuy;
                maxStocks += day;

            }
            day++;
        }
        return maxStocks;
    }
}
