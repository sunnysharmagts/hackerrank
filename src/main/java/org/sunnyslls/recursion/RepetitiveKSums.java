package org.sunnyslls.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by sunny on 15/7/17.
 */
public class RepetitiveKSums {

    private int n;
    private int k;
    private int index;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        RepetitiveKSums kSum = new RepetitiveKSums();
        for(int i = 0; i < testCases; i++){
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            scanner.nextLine();
            String s = scanner.nextLine();
            String[] kSums = s.split(" ");
            int[] kSumArray = new int[kSums.length];
            for(int s1 = 0; s1 < kSums.length; s1++){
                kSumArray[s1] = Integer.valueOf(kSums[s1]);
            }
            int[] output = kSum.checkKSums(n, k, kSumArray);
            for(int j : output){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    public int[] checkKSums(int n, int k, int[] kSumArray) {
        this.n = n;
        this.k = k;
        index = 0;
        int[] output = new int[n];
        int startingValue = kSumArray[0]/k;
        output[0] = startingValue;
        for(int i = 1; i < n; i++){
            output[i] = output[i-1]+1;
        }
        for(int element = 0; element < kSumArray.length;){
            //checkKSums(0, element, output, 1);
            boolean result = enumerate(0, output, 1, kSumArray[element], 0);
            if(!result){
                if(index >= n){
                    index--;
                    element--;
                    output[index] = output[index] + 1;
                }
                output[index] = output[index] + 1;
            }else{
                element++;
            }
        }
        return output;
    }

    private boolean enumerate(int value, int[] output, int counter, int element, int k){
        if(value == element){
            index++;
            return true;
        }


        if(counter > this.k){
            return false;
        }

        for(int i = k; i < n; i++){
            value += output[i];
            if(enumerate(value, output, counter + 1, element, k)){
                return true;
            }
            value -= output[i];
        }
        return false;
    }

    private boolean checkKSums(int value, int element, int[] output, int counter){
        if(value == element){
            output[index] = value - output[index];
            index++;
            System.out.println("----------------------------------------");
            return true;
        }

        if(counter > k){
            output[index] = output[index] + 1;
            return false;
        }

        for(int i = 0; i < n; i++){
            value += output[i];
            display(output);

            if(checkKSums(value, element, output, counter+1)){
                    return true;
            }
            value -= output[i];
        }
        return false;
    }

    private boolean canBacktrack(int counter){
        if(counter < k){
            return false;
        }
        return true;
    }

    private void display(int[] output){
        for(int i : output){
            System.out.print(i+" ");
        }
        System.out.println();
    }


}
