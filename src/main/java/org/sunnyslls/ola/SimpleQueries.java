package org.sunnyslls.ola;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by sunny on 11/11/17.
 */
public class SimpleQueries {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = null;
        if (fileName != null) {
            bw = new BufferedWriter(new FileWriter(fileName));
        }
        else {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        int[] res;
        int nums_size = 0;
        nums_size = Integer.parseInt(in.nextLine().trim());

        int[] nums = new int[nums_size];
        for(int i = 0; i < nums_size; i++) {
            int nums_item;
            nums_item = Integer.parseInt(in.nextLine().trim());
            nums[i] = nums_item;
        }

        int maxes_size = 0;
        maxes_size = Integer.parseInt(in.nextLine().trim());

        int[] maxes = new int[maxes_size];
        for(int i = 0; i < maxes_size; i++) {
            int maxes_item;
            maxes_item = Integer.parseInt(in.nextLine().trim());
            maxes[i] = maxes_item;
        }

        res = counts(nums, maxes);
        for(int res_i = 0; res_i < res.length; res_i++) {
            bw.write(String.valueOf(res[res_i]));
            bw.newLine();
        }

        bw.close();
    }

    static int[] counts(int[] nums, int[] maxes) {
        Arrays.sort(nums);
        int[] result = new int[maxes.length];
        int count = 0;
        for(int value : maxes){
            result[count++] = findCount(nums, value);
        }

        return result;
    }

    static int findCount(int[] nums, int value){
        final int length = nums.length;

        if(value < nums[0]){
            return 0;
        }else if(value > nums[length-1]){
            return length;
        }

        int start = 0;
        int end = length - 1;

        int result = 0;
        while(start <= end){
            int mid = (start + end) / 2;

            if(value == nums[mid]){
                return mid + 1;
            }
            else if(value < nums[mid]){
                result = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return result;
    }
}
