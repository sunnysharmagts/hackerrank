package org.sunnyslls.microsoft;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * Created by sunny on 10/12/17.
 */
public class RollTheString {

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

        String res;
        String s;
        try {
            s = in.nextLine();
        } catch (Exception e) {
            s = null;
        }

        int roll_size = 0;
        roll_size = Integer.parseInt(in.nextLine().trim());

        int[] roll = new int[roll_size];
        for(int i = 0; i < roll_size; i++) {
            int roll_item;
            roll_item = Integer.parseInt(in.nextLine().trim());
            roll[i] = roll_item;
        }

        res = rollTheString(s, roll);
        bw.write(res);
        bw.newLine();

        bw.close();
    }

    static char ch[] = { 'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r',
            's', 't', 'u', 'v', 'w', 'x',
            'y', 'z' };

    /*
     * Complete the function below.
     */
    static String rollTheString(String s, int[] roll) {
        int length = s.length();
        int[] rollingCount = new int[length+1];

        for (int i = 0; i < length; i++) {
            rollingCount[0] += 1;
            rollingCount[roll[i]] -= 1;
        }
        for (int i = 1; i < length; i++)
            rollingCount[i] += rollingCount[i - 1];

        char[] arr = s.toCharArray();
        for (int i = 0; i < length; i++) {
            int x = rollingCount[i] % 26;
            int y = s.charAt(i) - 'a';
            arr[i] = ch[(x + y) % 26];
        }

        return new String(arr);
    }

    static String rollTheString(char[] s, int index, int count){
        if(count == 0){
            return new String(s);
        }

        if(s[index] == 'z'){
            s[index] = 'a';
        }else {
            s[index] = (char) (s[index] + 1);
        }
        String value = rollTheString(s, index+1,count-1);
        return value;
    }
}
