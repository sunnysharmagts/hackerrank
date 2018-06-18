package org.sunnyslls.sorting;

/**
 * Created by sunny on 3/9/17.
 */
public class MergeSortedArrays {

    public static void main(String[] args){
        int[] arr2 = new int[] {5,7,20,25};
        int[] arr1 = new int[] {1,9,12,30,0,0,0,0};
        int[] finalArray = merge(arr1, arr2);

        for(int i : finalArray){
            System.out.print(i + " ");
        }
    }

    static int[] merge(int[] mainArray, int[] subArray){

        int index = mainArray.length - 1;
        int i = subArray.length-1;
        int j = mainArray.length/2 -1;

        while (index > 0){
            if(mainArray[j] > subArray[i]){
                mainArray[index] = mainArray[j];
                j--;
            }else{
                mainArray[index] = subArray[i];
                i--;
            }
            index--;
        }

        if(mainArray[0] > subArray[0]){
            mainArray[0] = subArray[0];
        }

        return mainArray;
    }
}
