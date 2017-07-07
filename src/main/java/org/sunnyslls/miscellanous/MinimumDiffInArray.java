package org.sunnyslls.miscellanous;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Consider an array of integers, . We define the absolute difference between two elements,  and  (where ), to be the absolute value of .

Given an array of  integers, find and print the minimum absolute difference between any two elements in the array.

Input Format

The first line contains a single integer denoting  (the number of integers). 
The second line contains  space-separated integers describing the respective values of .

Constraints

Output Format

Print the minimum absolute difference between any two elements in the array.

Sample Input 0

3
3 -7 0
Sample Output 0

3
Explanation 0

With  integers in our array, we have three possible pairs: , , and . The absolute values of the differences between these pairs are as follows:

Notice that if we were to switch the order of the numbers in these pairs, the resulting absolute values would still be the same. The smallest of these possible absolute differences is , so we print  as our answer.
 * 
 */
public class MinimumDiffInArray {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        
        int min = Integer.MAX_VALUE;
        Arrays.sort(a);
        for(int i = 0; i < a.length-1; i++){
        		int value = Math.abs(a[i] - a[i+1]);
        		if(value < min){
        			min = value;
        		}
        		if(min < 1) break;
        }
        System.out.println(min);
	}
}
