package org.sunnyslls.recursion;

import java.util.ArrayList;

/**
 * Created by sunny on 8/9/17.
 */
public class PartitionArrayProblem {

    static int[] arr;
    static ArrayList<Integer> leftList;
    static ArrayList<Integer> rightList;

    public static void main(String[] args){
        arr = new int[] {1, 5, 11, 5};
        int right = 0;
        for(int i : arr){
            right += i;
        }
        enumerate(0, 0, right);
    }

    static boolean enumerate(int index, int left, int right){
        System.out.println(index +" "+left +" "+right);
        if(left == right){
            System.out.println("Found one");
            return true;
        }
        while (index < arr.length){
            if(enumerate(index + 1, left + arr[index], right - arr[index])){
                return true;
            }
            index++;
        }
        return false;
    }
}
