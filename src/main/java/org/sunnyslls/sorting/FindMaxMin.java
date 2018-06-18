package org.sunnyslls.sorting;

/**
 * Created by sunny on 3/9/17.
 */
public class FindMaxMin {

    static int[] arr;
    static int max;
    static int min;

    public static void main(String[] args){
        arr = new int[]{20, 5, 7, 35, 30, 1, 9, 12, 42};
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        maxMin(0, arr.length-1);
        System.out.println(max +" "+min);
    }

    static void maxMin(int i, int j){
        if(i == j) max = min = arr[i];

        else if(i == j-1){
            if(arr[i] > arr[j]){
                if(max < arr[i]){
                    max = arr[i];
                }
                if(min > arr[j]){
                    min = arr[j];
                }
            }else{
                if(max < arr[j]){
                    max = arr[j];
                }
                if(min > arr[i]){
                    min = arr[i];
                }
            }
        }

        else{
            int mid = (i+j) / 2;
            maxMin(i, mid);
            maxMin(mid+1, j);
        }
    }
}
