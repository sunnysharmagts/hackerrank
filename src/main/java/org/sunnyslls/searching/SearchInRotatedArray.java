package org.sunnyslls.searching;

/**
 * Created by sunny on 14/10/17.
 */
public class SearchInRotatedArray {

    public static void main(String[] args){
        int[] arr = {11,12,13,14,1,2,3};
        int[] arr1 = {21, 12};
        System.out.println(search(arr, 13));
    }

    static int search(int[] arr, int N){
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = (start + end) / 2;
            if(arr[mid] == N){
                return mid;
            }
            else if(arr[start] <= arr[mid]){
                if(arr[start] <= N && N <= arr[mid]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }else{
                if(arr[mid] < N){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
