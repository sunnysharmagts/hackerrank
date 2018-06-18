package org.sunnyslls.ola;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by sunny on 11/11/17.
 */
public class PurchaseTickets {

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

        long res;
        int tickets_size = 0;
        tickets_size = Integer.parseInt(in.nextLine().trim());

        int[] tickets = new int[tickets_size];
        for(int i = 0; i < tickets_size; i++) {
            int tickets_item;
            tickets_item = Integer.parseInt(in.nextLine().trim());
            tickets[i] = tickets_item;
        }

        int p;
        p = Integer.parseInt(in.nextLine().trim());

        res = waitingTime(tickets, p);
        bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();
    }

    static long waitingTime(int[] tickets, int position){

        long count = 0;
        final int length = tickets.length;
        //if the position is greater than the no of tickets then return 0;
        if(position >= length || position < 0){
            return -1;
        }

        final Queue<Integer> queue = new LinkedList<Integer>();

        for(int i : tickets){
            queue.offer(i);
        }

        while(true){
            int currentValue = queue.poll();
            currentValue--;

            if(position == 0 && currentValue <= 0){
                count++;
                break;
            }

            if(currentValue > 0) {
                queue.offer(currentValue);
            }
            if(position > 0){
                position--;
            }else{
                position = queue.size()-1;
            }
            count++;
        }
        return count;

    }
}
