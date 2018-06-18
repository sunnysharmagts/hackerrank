package org.sunnyslls.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunny on 2/1/18.
 */
public class MinJumpsToReachEndOfArray {

    public static void main(String[] args){
        int[] arr = {1,4,3,7,1,2,6,7,6,10};
        minJumps(arr, 0, arr.length-1, new ArrayList<>());
    }

    static void minJumps(int[] arr, int start, int end, List<Integer> list){
        if(start >= end){
            return;
        }

        list.add(arr[start]);
        minJumps(arr, arr[start], end, list);
        list.remove(list.size()-1);
    }
}
