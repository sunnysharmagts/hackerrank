package org.sunnyslls.deloitte;

import java.io.IOException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		int output = 0;
		int ip1 = Integer.parseInt(in.nextLine().trim());
		int ip2 = Integer.parseInt(in.nextLine().trim());
		int ip3_size = 0;
		ip3_size = Integer.parseInt(in.nextLine().trim());
		int[] ip3 = new int[ip3_size];
		int ip3_item;
		for (int ip3_i = 0; ip3_i < ip3_size; ip3_i++) {
			ip3_item = Integer.parseInt(in.nextLine().trim());
			ip3[ip3_i] = ip3_item;
		}
		output = GetJumpCount(ip1, ip2, ip3);
		System.out.println(String.valueOf(output));
	}

	public static int GetJumpCount(int input1,int input2,int[] input3){
	    
		int realPositionAfterJump = input1;
		
		int jumps = 0;
		int i = 0;
		while(i < input3.length){
			if(realPositionAfterJump >= input3[i]){
				jumps++;
				i++;
				realPositionAfterJump = input1;
			}else{
				jumps++;
				realPositionAfterJump += input3[i] - (realPositionAfterJump - input2);
			}
		}
		return jumps;
    }

}
