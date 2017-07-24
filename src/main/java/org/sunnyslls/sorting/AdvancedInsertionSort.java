package org.sunnyslls.sorting;

import java.util.Scanner;

/**
 * Created by sunny on 17/7/17.
 */
public class AdvancedInsertionSort {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        AdvancedInsertionSort sort = new AdvancedInsertionSort();
        for(int t = 0; t < testCases; t++) {
            int arrLength = scanner.nextInt();
            int[] arr = new int[arrLength];
            for (int i = 0; i < arrLength; i++) {
                arr[i] = scanner.nextInt();
            }
            System.out.println(sort.calculateSwap(arr));
        }
    }

    /*public int calculateSwap(int[] arr){
        int swap = 0;
        int length = arr.length;
        if(length == 0 || length == 1){
            return 0;
        }

        for(int i = 0; i < length; i++){
            int temp = i;
            while(temp > 0){
                if(arr[temp] < arr[temp-1]){
                    swap(arr, temp, temp-1);
                    swap++;
                }
                temp--;
            }
        }

        return swap;
    }*/

    public int calculateSwap(int[] arr){
        int length = arr.length;
        int swap = 0;
        if(length == 0 || length == 1){
            return 0;
        }
        int mid = length/2;
        /*calculateSwap(arr, 0, mid);
        calculateSwap(arr, mid+1, length-1);*/
        return swap;
    }

    private void calculateSwap(){

    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
