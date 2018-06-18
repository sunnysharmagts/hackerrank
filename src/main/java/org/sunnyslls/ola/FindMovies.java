package org.sunnyslls.ola;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by sunny on 13/1/18.
 */
public class FindMovies {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        String[] res;
        String _substr;
        try {
            _substr = in.nextLine();
        } catch (Exception e) {
            _substr = null;
        }

        res = getMovieTitles(_substr);
        for(int res_i=0; res_i < res.length; res_i++) {
            bw.write(String.valueOf(res[res_i]));
            bw.newLine();
        }

        bw.close();
    }

    static String[] getMovieTitles(String substr) {
        if(substr == null){
            return null;
        }
        return null;
    }
}
