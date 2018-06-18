package org.sunnyslls.recursion;

/**
 * Created by sunny on 2/1/18.
 */
public class DecodeStrings {

    public static void main(String[] args){
        System.out.println(decode("12321", 0));
    }

    static int decode(String str, int index){
        if(index == str.length()){
            return 1;
        }

        int ways = decode(str, index+1);

        if(index+1 < str.length()){
            String s = str.substring(index, index+2);
            int value = Integer.parseInt(s);
            if(value >= 10 && value <= 26)
                ways += decode(str, index+2);
        }
        return ways;
    }
}
