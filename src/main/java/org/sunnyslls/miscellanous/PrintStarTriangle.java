package org.sunnyslls.miscellanous;
import java.util.Scanner;

public class PrintStarTriangle {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int value = scanner.nextInt();
		
		for(int i = 1; i <=value; i++){
			for(int k = value; k >=i; k--){
				System.out.print(" ");
			}
			for(int j = 1; j <=i; j++){
				System.out.print("* ");
			}
			System.out.println();
		}
	}

}
