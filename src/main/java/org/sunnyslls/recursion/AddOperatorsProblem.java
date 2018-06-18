package org.sunnyslls.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunny on 8/9/17.
 */
public class AddOperatorsProblem {

    static int[] arr;
    static int N;

    public static void main(String[] args){
        arr = new int[] {1,2,3,4};
        N = 4;
        enumerate(1, new ArrayList<>(), arr[0], "+");
    }

    static void enumerate(int index, List<String> list, int total, String symbol){
        if(total == N){
            if(index == arr.length){
                list.add(symbol);
                System.out.println(list);
            }
            return;
        }
        if(index >= arr.length){
            return;
        }

        list.add(symbol);
        enumerate(index + 1, list, total + arr[index], "+");
        list.remove(list.size()-1);
        enumerate(index + 1, list, total - arr[index], "-");
    }
}
