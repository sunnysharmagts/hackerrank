package org.sunnyslls.recursion;

/**
 * Created by sunny on 6/10/17.
 */
public class DistinctBinaryStringOfLengthN {

    static int N = 0;

    public static void main(String[] args){
        N = 5;
        cbs("0");
        cbs("1");
    }

    static void cbs(String str){
        if(str.length() == N){
            System.out.println(str);
            return;
        }

        if(str.endsWith("0")){
            cbs(str + "0");
            cbs(str + "1");
        }
        else{
            cbs(str +"0");
        }
    }
}
