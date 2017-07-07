package org.sunnyslls.miscellanous;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * https://www.hackerrank.com/contests/university-codesprint-2/challenges/game-of-two-stacks
 * 
 * Alexa has two stacks of non-negative integers, stack  and stack where index  denotes the top of the stack. Alexa challenges Nick to play the following game:

In each move, Nick can remove one integer from the top of either stack  or stack .
Nick keeps a running sum of the integers he removes from the two stacks.
Nick is disqualified from the game if, at any point, his running sum becomes greater than some integer  given at the beginning of the game.
Nick's final score is the total number of integers he has removed from the two stacks.
Given , , and  for  games, find the maximum possible score Nick can achieve (i.e., the maximum number of integers he can remove without being disqualified) during each game and print it on a new line.

Input Format

The first line contains an integer,  (the number of games). The  subsequent lines describe each game in the following format:

The first line contains three space-seperated integers describing the respective values of  (the number of integers in stack ),  (the number of integers in stack ), and  (the number that the sum of the integers removed from the two stacks cannot exceed).
The second line contains  space-seperated integers describing the respective values of .
The third line contains  space-seperated integers describing the respective values of .
Constraints

Subtasks

 for  of the maximum score.
Output Format

For each of the  games, print an integer on a new line denoting the maximum possible score Nick can achieve without being disqualified.

Sample Input 0

1
5 4 10
4 2 4 6 1
2 1 8 5
Sample Output 0

4
Explanation 0

The two stacks initially look like this:

image

The image below depicts the integers Nick should choose to remove from the stacks. We print  as our answer, because that is the maximum number of integers that can be removed from the two stacks without the sum exceeding .

image

(There can be multiple ways to remove the integers from the stack, the image shows just one of them.)
 * 
 */
public class RemoveElementsFromStack {

	public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int g = in.nextInt();
	        for(int a0 = 0; a0 < g; a0++){
	            int n = in.nextInt();
	            int m = in.nextInt();
	            int x = in.nextInt();
	            int[] a = new int[n];
	            for(int a_i=0; a_i < n; a_i++){
	                a[a_i] = in.nextInt();
	            }
	            int[] b = new int[m];
	            for(int b_i=0; b_i < m; b_i++){
	                b[b_i] = in.nextInt();
	            }
	            
	            System.out.println(getMaxElements(a, b, 0, x));
	        }
	        in.close();
	}
	
	static int getMaxElements(int[] A, int[] B, int total, int max){
		
		List<Integer> result = new ArrayList<>();
		List<Integer> value = new ArrayList<>();
		value = getMax(A, max, value);
		value = getMax(B, max, value);
		
		result.add(value.size());
		
		value.clear();
		
		value = getMax(B, max, value);
		value = getMax(A, max, value);
		
		result.add(value.size());
		
		int finalVal = Integer.MIN_VALUE;
		for(int i : result){
			if(finalVal < i){
				finalVal = i;
			}
		}
		return finalVal;
	}
	
	static List<Integer> getMax(int[] arr, int max, List<Integer> value){
		int total = 0;
		for(int i : value){
			total += i;
		}
		
		for(int i = 0; i < arr.length; i++){
			total += arr[i];
			if(total > max){
				break;
			}
			value.add(arr[i]);
		}
		
		return value;
	}

}
