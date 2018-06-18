package org.sunnyslls.goldmansachs;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.List;

/**
 * Created by sunny on 17/2/18.
 */
public class NumberChecker {

    public static void main(String[] args) throws IOException {
        int[] arr = {1456, 345671, 43218, 123};
        System.out.println(findQualifiedNumbers(arr));
    }

    /*
     * Complete the function below.
     */
    static String findQualifiedNumbers(int[] numberArray) {
        if(numberArray == null) return String.valueOf(-1);

        List<Integer> list = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int num : numberArray){
            int currentNum = num;
            map.put(1, 0);
            map.put(2, 0);
            map.put(3, 0);
            while(num > 0){
                int val = num % 10;
                if(val == 1 || val == 2 || val == 3){
                    int curr = map.get(val);
                    map.put(val, ++curr);
                }
                num = num / 10;
            }
            if(map.get(1) > 0 && map.get(2) > 0 && map.get(3) > 0){
                list.add(currentNum);
            }
        }
        if(list.isEmpty()){
            return String.valueOf(-1);
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(int val : list){
            sb.append(val);
            sb.append(",");
        }
        sb.setLength(sb.length()-1);
        return sb.toString();
    }
}
