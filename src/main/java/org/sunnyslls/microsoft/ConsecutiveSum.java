package org.sunnyslls.microsoft;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * Created by sunny on 10/12/17.
 */
public class ConsecutiveSum {

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
        long num;
        num = Long.parseLong(in.nextLine().trim());

        res = consecutive(num);
        bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();
    }

    /*
     * Complete the function below.
     */

    /*static int consecutive(long num){
        int start = 1, end = 1;
        int sum = 1;
        while (start <= num/2)
        {
            if (sum < num)
            {
                end += 1;
                sum += end;
            }
            else if (sum > num)
            {
                sum -= start;
                start += 1;
            }
            else if (sum == num)
            {
                sum -= start;
                start += 1;
            }
        }
        return sum;
    }*/

    static int consecutive(long num) {
        int count = 0;
        for (int i = 1; i * (i + 1) < 2 * num; i++) {
            float a = (float) ((1.0 * num - (i * (i + 1)) / 2) / (i + 1));
            if (a - (int) a == 0.0)
                count++;
        }
        return count;
    }
}
