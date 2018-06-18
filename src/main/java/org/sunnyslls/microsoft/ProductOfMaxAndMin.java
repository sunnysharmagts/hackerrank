package org.sunnyslls.microsoft;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by sunny on 10/12/17.
 */
public class ProductOfMaxAndMin {

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

        long[] res;
        int operations_size = 0;
        operations_size = Integer.parseInt(in.nextLine().trim());

        String[] operations = new String[operations_size];
        for(int i = 0; i < operations_size; i++) {
            String operations_item;
            try {
                operations_item = in.nextLine();
            } catch (Exception e) {
                operations_item = null;
            }
            operations[i] = operations_item;
        }

        int x_size = 0;
        x_size = Integer.parseInt(in.nextLine().trim());

        int[] x = new int[x_size];
        for(int i = 0; i < x_size; i++) {
            int x_item;
            x_item = Integer.parseInt(in.nextLine().trim());
            x[i] = x_item;
        }

        res = maxMin(operations, x);
        for(int res_i = 0; res_i < res.length; res_i++) {
            bw.write(String.valueOf(res[res_i]));
            bw.newLine();
        }

        bw.close();
    }

    static long[] maxMin(String[] operations, int[] x) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();
        Stack<Integer> maxStack = new Stack<>();

        int length = operations.length;

        long[] result = new long[length];

        for(int i = 0; i < length; i++){
            if(operations[i].equals("push")){
                stack.push(x[i]);
                if(minStack.isEmpty()) minStack.push(x[i]);

                else if(x[i] <= minStack.peek()){
                    minStack.push(x[i]);
                }else{
                    minStack.push(minStack.peek());
                }

                if(maxStack.isEmpty()) maxStack.push(x[i]);
                else if(x[i] >= maxStack.peek()){
                    maxStack.push(x[i]);
                }else{
                    maxStack.push(maxStack.peek());
                }
            }else{
                stack.pop();
                minStack.pop();
                maxStack.pop();
            }
            result[i] = minStack.peek() * maxStack.peek();
        }
        return result;
    }

}
