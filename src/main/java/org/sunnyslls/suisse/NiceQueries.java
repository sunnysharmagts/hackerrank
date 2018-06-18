package org.sunnyslls.suisse;

import java.util.*;

/**
 * Created by sunny on 19/11/17.
 */
public class NiceQueries {

    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input */

        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        String[] inputArr = input.split(" ");
        int arrayLength = Integer.parseInt(inputArr[0]);
        int queriesLength = Integer.parseInt(inputArr[1]);

        int[] arr = new int[arrayLength+1];

        List<Integer> result = new ArrayList<>();
        List<Integer> set = new ArrayList<>();

        for(int i = 0; i < queriesLength; i++){
            String[] queries = s.nextLine().split(" ");
            int index = Integer.parseInt(queries[1]);
            if(queries[0].equals("1")){
                arr[index] = -1;
                set.add(index);
                Collections.sort(set);
            }else{
                result.add(binarySearch(set, index));
            }
        }
        System.out.println(result);

    }

    static int binarySearch(List<Integer> set, int index){
        if(set.isEmpty()){
            return -1;
        }
        int start = 0;
        int end = set.size()-1;

        if(set.get(end) < index){
            return -1;
        }

        int result = -1;

        while (start <= end){
            int mid = (start + end) / 2;

            if(set.get(mid) >= index){
                result = set.get(mid);
                start = mid + 1;
            }
            else if(set.get(mid) > index){
                end = mid - 1;
            }
        }

        return result;
    }
}
