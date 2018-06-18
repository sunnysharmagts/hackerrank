package org.sunnyslls.suisse;

import java.util.Scanner;

/**
 * Created by sunny on 19/11/17.
 */
public class DivideIntoGroups {

    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner


        */

        Scanner s = new Scanner(System.in);
        int testCases = s.nextInt();
        int MOD=1000000007;
        for(int i = 0; i < testCases; i++){
            long value = countGroups(s.nextInt(), 2);
            int finalValue = (int) (value*2 % MOD);
            System.out.println(finalValue);
        }
    }

    static long countGroups(int people, int k){
        if(people == 0 || k == 0 || k > people){
            return 0;
        }

        if (k == 1 || k == people)
            return 1;

        return  k*countGroups(people-1, k) + countGroups(people-1, k-1);
    }
}
