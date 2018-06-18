package org.sunnyslls;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by sunny on 28/8/17.
 */
public class AshleyLovesNumbers {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int _arr_rows = 0;
        int _arr_cols = 0;
        _arr_rows = Integer.parseInt(in.nextLine().trim());
        _arr_cols = Integer.parseInt(in.nextLine().trim());

        int[][] _arr = new int[_arr_rows][_arr_cols];
        for(int _arr_i=0; _arr_i<_arr_rows; _arr_i++) {
            for(int _arr_j=0; _arr_j<_arr_cols; _arr_j++) {
                _arr[_arr_i][_arr_j] = in.nextInt();

            }
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }

        countNumbers(_arr);

    }

    static void countNumbers(int[][] arr) {

        for(int[] i : arr){
            int m = i[0];
            int n = i[1];

            int count = 0;
            for(int k = m; k < n; k++){
                HashSet<Integer> set = new HashSet<>();
                boolean duplicate = false;
                while(k > 0){
                    int val = k % 10;
                    if(set.contains(val)){
                        duplicate = true;
                        break;
                    }else{
                        set.add(val);
                    }
                    k = k / 10;
                }
                if(!duplicate){
                    count++;
                }
            }
            System.out.println(count);
        }


    }
}
