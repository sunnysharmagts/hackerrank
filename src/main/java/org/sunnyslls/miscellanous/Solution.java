package org.sunnyslls.miscellanous;
import java.util.Scanner;
 
public class Solution{
 
    public static void main(String[] args){
    	Scanner s = new Scanner(System.in);
    	while(true) {
    	    int value = s.nextInt();
    	    if(value == 42) break;
    	    System.out.println(value);
    	}
    }
}
