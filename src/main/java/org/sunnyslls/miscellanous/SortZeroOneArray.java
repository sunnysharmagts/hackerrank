package org.sunnyslls.miscellanous;

/**
 * Created by sunny on 30/10/17.
 */
public class SortZeroOneArray {

    public static void main(String[] args){
        int[] arr = {0, 1, 0, 0, 1, 0, 1};
        int[] arr1 = {0,1,1,0,1,1,0,0,1};
        sort(arr1);
        for(int i : arr1){
            System.out.print(i +" ");
        }
    }

    static void sort(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while(start < end){
            while (arr[start] == 0){
                start++;
            }
            while (arr[end] == 1){
                end--;
            }
            if(start < end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }
    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
