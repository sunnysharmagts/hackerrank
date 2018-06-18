package org.sunnyslls.sorting;

/**
 * Created by sunny on 3/9/17.
 */
public class FindKSmallestElement {

    public static void main(String[] args){
        int[] arr = new int[]{1,5,14,9,20,81,3,24};
        heapify(arr, arr.length);

        int k = 5;

        for(int i = arr.length-1; i > arr.length-k; i--){
            swap(arr, 0, i);
            heapify(arr, i);
        }

        System.out.println(k + " smallest no. is "+arr[0]);
    }

    static void heapify(int[] arr, int max){
        int i = 0;

        int length = arr.length;

        while(i < length / 2){
            int child1 = (2 * i) + 1;
            int child2 = (2 * i) + 2;
            if(child1 < max && arr[i] > arr[child1]){
                swap(arr, i, child1);
            }if(child2 < max && arr[i] > arr[child2]){
                swap(arr, i, child2);
            }
            i++;
        }
    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
