package org.sunnyslls.sorting;

/**
 * Created by sunny on 3/9/17.
 */
public class ArrayPartition {

    public static void main(String[] args){
        int[] arr = new int[] {1,5,14,9,20,81,3,24};
        partition(arr);

        for(int i : arr){
            System.out.print(i + " ");
        }
    }

    static void partition(int[] arr){

        int i = 0;
        int j = arr.length-1;

        int pivot = arr[(i+j)/2];

        System.out.println(pivot);

        while(i != j){

            while(arr[i] < pivot){
                i++;
            }

            while(arr[j] > pivot){
                j--;
            }

            if(i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
}
