package org.sunnyslls.dp;

import java.util.Arrays;
import java.util.Scanner;

/*
 * On a positive integer, you can perform any one of the following 3 steps. 
 * 1.) Subtract 1 from it. ( n = n - 1 )  , 
 * 2.) If its divisible by 2, divide by 2. ( if n % 2 == 0 , then n = n / 2  )  , 
 * 3.) If its divisible by 3, divide by 3. ( if n % 3 == 0 , then n = n / 3  ). 
 * Now the question is, given a positive integer n, 
 * find the minimum number of steps that takes n to 1
 */

public class MinSteps {

	static int[] arr;
	
	public static void main(final String[] args){
		Scanner scanner = new Scanner(System.in);
		final int value = scanner.nextInt();
		arr = new int[value+1];
		//Arrays.fill(arr, -1);
		//getMinStepsUsingMemorization(value);
		//System.out.println("Minimum Steps : "+arr[value]);
		System.out.println("Minimum Steps : "+getMinStepsUsingDP(value));
		scanner.close();
	}
	
	private static int getMinStepsUsingMemorization(int n){
		if(n == 1){
			return 0; //base steps 
		}
		if(arr[n] != -1){	//if the problem is already solved then return the saved value
			return arr[n];
		}
		
		int val = 1 + getMinStepsUsingMemorization(n-1);
		
		if(n % 2 == 0) val = Math.min(val, 1 + getMinStepsUsingMemorization(n/2));
		if(n % 3 == 0) val = Math.min(val, 1 + getMinStepsUsingMemorization(n/3));
		
		arr[n] = val;
		return val;
	}
	
	private static final int getMinStepsUsingDP(int n){
		
		arr[1] = 0; 
		int i;
		
		for(i = 2; i<=n; i++){
			arr[i] = 1+arr[i-1];
		}
		
		if(n%2 == 0) Math.min(arr[i-1], 1+arr[(i-1)/2]);
		if(n%3 == 0) Math.min(arr[i-1], 1+arr[(i-1)/3]);
		
		return arr[n];
	}
	
}
