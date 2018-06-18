package org.sunnyslls.miscellanous;

/**
 * Created by sunny on 25/9/17.
 */
public class NoOfTimesArrayRotated {

    public static void main(String[] args){
        int[] arr = {11,2};
        System.out.println(findElement(arr));
    }

    public static int findElement(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        if(arr[start] <= arr[end]){
            return 0;
        }
        else if(arr.length == 2){
            return 1;
        }
        while(start <= end){
            int mid = (start + end) / 2;
              if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
                  start = mid + 1;

              }else if(arr[mid] < arr[mid-1] && arr[mid] < arr[mid+1]){
                  return mid;

              }else if(arr[mid] > arr[mid-1] && arr[mid] < arr[mid+1]){
                  end = mid - 1;
              }
        }
        return -1;
    }
}
