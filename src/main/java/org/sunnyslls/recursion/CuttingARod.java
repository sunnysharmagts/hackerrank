package org.sunnyslls.recursion;

import java.util.HashMap;

/**
 * Created by sunny on 5/9/17.
 */
public class CuttingARod {

    static int maxPrice = Integer.MIN_VALUE;

    static int[] rod;
    static int[] priceArr;

    public static void main(String[] args){
        /*rod = new int[] {1,2,3,4,5,6,7};
        priceArr = new int[] {1,5,8,10,13,17,18};*/
        rod = new int[] {1,2,3};
        priceArr = new int[] {1,5,8};
        maxPrice = cuttingRod(0, 8, 0, new HashMap<>());
        System.out.println(maxPrice);
    }

    static int cuttingRod(int k, int lengthLeft, int price, HashMap<String, Integer> map){

        String key = rod[k] +"_"+lengthLeft;

        System.out.println(key +" ---> "+price);

        if(lengthLeft == 0){
            System.out.println("Current "+price);
            return price;
        }

        if(map.containsKey(key)){
            System.out.println("Already contain "+key + " "+price +" "+maxPrice);
            System.out.println(map);
            return maxPrice;
        }

        int currentPrice;
        while(k < rod.length){
            if(lengthLeft - rod[k] < 0){
                k++;
                continue;
            }
            currentPrice = cuttingRod(k, lengthLeft - rod[k], price + priceArr[k], map);
            maxPrice = Math.max(currentPrice, maxPrice);
            k++;
        }
        map.put(key, maxPrice);
        return maxPrice;
    }
}
