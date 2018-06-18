package org.sunnyslls.goldmansachs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by sunny on 25/11/17.
 */
public class BookCricket {

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
        int totalScore;
        totalScore = Integer.parseInt(in.nextLine().trim());

        res = noOfWaysToDrawTheGame(totalScore);
        bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();
    }

    static int noOfWaysToDrawTheGame(int totalScore){
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(4);
        list.add(6);

        return noOfWaysToDrawTheGame(totalScore, list);
    }

    static int noOfWaysToDrawTheGame(int totalScore, List<Integer> list){
        if(totalScore == 0){
            return 1;
        }
        else if(totalScore < 0){
            return 0;
        }

        int ways = 0;

        for(int i = 0; i < list.size(); i++) {
            ways += noOfWaysToDrawTheGame(totalScore - list.get(i), list);
        }

        return ways;
    }
}
