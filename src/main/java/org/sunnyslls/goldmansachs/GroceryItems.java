package org.sunnyslls.goldmansachs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by sunny on 25/11/17.
 */
public class GroceryItems {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = null;
        if (fileName != null) {
            bw = new BufferedWriter(new FileWriter(fileName));
        }
        else {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        String res;
        int salary;
        salary = Integer.parseInt(in.nextLine().trim());

        int itemsToBuyForCashback;
        itemsToBuyForCashback = Integer.parseInt(in.nextLine().trim());

        int cashback;
        cashback = Integer.parseInt(in.nextLine().trim());

        String prices;
        try {
            prices = in.nextLine();
        } catch (Exception e) {
            prices = null;
        }

        res = getMaxGroceryItems(salary, itemsToBuyForCashback, cashback, prices);
        bw.write(res);
        bw.newLine();

        bw.close();
    }

    static String getMaxGroceryItems(int salary, int itemsToBuyForCashback, int cashback, String prices) {
        String[] arr = prices.split(",");
        int[] priceList = new int[arr.length];
        int count = 0;
        for(String s : arr){
            priceList[count++] = Integer.parseInt(s);
        }
        Arrays.sort(priceList);
        int itemsBought = 0;
        int totalItemsBought = 0;
        for(int i = 0; i < priceList.length; i++){
            salary -= priceList[i];
            if(salary < 0){
                salary += priceList[i];
                break;
            }
            itemsBought++;
            if(itemsBought == itemsToBuyForCashback){
                salary += cashback;
                itemsBought = 0;
            }
            totalItemsBought++;
            if(totalItemsBought == 5){
                salary += 10;
            }
        }

        return totalItemsBought +" "+salary;
    }
}
