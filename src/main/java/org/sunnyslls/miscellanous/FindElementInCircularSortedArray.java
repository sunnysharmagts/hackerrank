package org.sunnyslls.miscellanous;

/**
 * Created by sunny on 25/9/17.
 */
public class FindElementInCircularSortedArray {

    public static void main(String[] args){
        int[] arr = {11,12,13,1,2,3,4,5};
        System.out.println(find(arr, 2));
    }

    static int find(int[] arr, int element){

        int start = 0;
        int end = arr.length-1;

        while(start<=end){
            int mid = (start + end) / 2;
            if(arr[mid] == element){
                return mid;
            }
            else if(arr[mid] < arr[mid-1] && arr[mid] < arr[mid+1]){
                if(element > arr[mid]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }else if(arr[mid] > arr[mid-1] && arr[mid] < arr[mid+1]){
                start = mid + 1;
            }
        }

        return -1;
    }
}
