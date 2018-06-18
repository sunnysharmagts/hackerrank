package org.sunnyslls.ola;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by sunny on 11/11/17.
 */
public class BitGame {

    static int count = Integer.MIN_VALUE;

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

        int res;
        int left;
        left = Integer.parseInt(in.nextLine().trim());

        int right;
        right = Integer.parseInt(in.nextLine().trim());

        int k;
        k = Integer.parseInt(in.nextLine().trim());

        res = maxXor(left, right, k);
        bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();
    }

    static int maxXor(int left, int right, int k) {

        List<Integer> list = new ArrayList<Integer>();

        for(int i = left; i <= right; i++){
            list.add(i);
        }

        findMaxXor(list, k, 1);
        return count;
    }

    static void findMaxXor(List<Integer> list, int k, int index){
        if(index >= list.size()){
            return;
        }

        for(int i = index; i < list.size(); i++){
            int value = list.get(i) ^ list.get(i-1);
            if(count < value){
                count = value;
            }
            findMaxXor(list, k, index+1);
        }
    }
}
