package org.sunnyslls.recursion;

/**
 * Created by sunny on 30/12/17.
 */
public class LongestCommonSubstring {

    public static void main(String[] args){
        String x = "unnys";
        String y = "butny";
        System.out.println(lcs(x, y));
    }

    static int lcs(String s1, String s2){
        return lcs(s1, s2, s1.length()-1, s2.length()-1);
    }

    static int lcs(String s1, String s2, int l1, int l2){

        if(l1 == 0 || l2 == 0)
            return 0;

        if(s1.charAt(l1) == s2.charAt(l2)){
            return 1 + lcs(s1, s2, l1-1, l2-1);
        }
        else{
            return Math.max(lcs(s1, s2, l1-1, l2), lcs(s1, s2, l1, l2-1));
        }
    }
}