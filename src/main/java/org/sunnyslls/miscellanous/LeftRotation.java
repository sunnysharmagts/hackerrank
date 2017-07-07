package org.sunnyslls.miscellanous;
import java.util.Scanner;

/*A left rotation operation on an array of size  shifts each of the array's elements  unit to the left. For example, if  left rotations are performed on array , then the array would become .

Given an array of  integers and a number, , perform  left rotations on the array. Then print the updated array as a single line of space-separated integers.

Input Format

The first line contains two space-separated integers denoting the respective values of  (the number of integers) and  (the number of left rotations you must perform). 
The second line contains  space-separated integers describing the respective elements of the array's initial state.

Constraints

Output Format

Print a single line of  space-separated integers denoting the final state of the array after performing  left rotations.

Sample Input

5 4
1 2 3 4 5
Sample Output

5 1 2 3 400
Explanation

When we perform  left rotations, the array undergoes the following sequence of changes:

Thus, we print the array's final state as a single line of space-separated values, which is 5 1 2 3 4.*/
public class LeftRotation {

		public static int[] arrayLeftRotation(int[] a, int n, int k) {
			
			int[] arr = new int[n];
			for(int i = k, j = 0; i < n; i++, j++){
				arr[j] = a[i];
			}
			for(int i = 0, j = n-k; i < k; i++, j++){
				arr[j] = a[i];
			}
			return arr;
	    }
		
		public static int[] arrayLeftRotationUsingRecursion(int[] a, int n, int k) {
			
			for(int i = 0; i < k; i++)
			    a = leftRotateByOne(a);
			
			return a;
	    }
		
		static int[] leftRotateByOne(int[] a){
			int n = a.length;
			int temp = a[0];
			for(int i = 1; i < n; i++){
				a[i-1] = a[i];
			}
			a[n-1] = temp;
			return a;
		}
	    
	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int k = in.nextInt();
	        int a[] = new int[n];
	        for(int a_i=0; a_i < n; a_i++){
	            a[a_i] = in.nextInt();
	        }
	      
	        int[] output = new int[n];
	        //output = arrayLeftRotation(a, n, k);
	        //output = arrayLeftRotationUsingRecursion(a, n, k);
	        //output = jugglingAlgorithm(a, n, k);
	        for(int i = 0; i < n; i++)
	            System.out.print(output[i] + " ");
	      
	        System.out.println();
	}

}
