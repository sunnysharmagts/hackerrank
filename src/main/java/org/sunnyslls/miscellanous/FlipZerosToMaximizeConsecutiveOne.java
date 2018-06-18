package org.sunnyslls.miscellanous;

/**
 * Created by sunny on 27/10/17.
 */
public class FlipZerosToMaximizeConsecutiveOne {

    public static void main(String[] args){
        //int arr[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1};
        int arr[] = {0,1,1,1,1,1,0,1,0,1};
        flip(arr, 2);
    }

    static void flip(int[] A, int m){
        int wL = 0;
        int wR = 0;
        int nZero = 0;
        int bestWindowWidth = -1;
        int bestWL = 0;
        int bestWR = 0;

        while(wR < A.length){
            //expand to the right, update '0' count:
            if (nZero <= m){
                wR++;
                if (wR < A.length && A[wR] == 0) nZero++;
            }

            //shrink from left, update '0' count:
            if (nZero > m){
                if (A[wL] == 0) nZero--;
                wL++;
            };

            //update best window:
            if (wR - wL > bestWindowWidth){
                bestWindowWidth = wR - wL;
                bestWR = wR;
                bestWL = wL;
            }
        }
        System.out.println(bestWL +" "+bestWR);
    }
}
