package org.sunnyslls.miscellanous;
import java.util.Scanner;

public class PrintStarChakki {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int value = scanner.nextInt();
		
		for(int i = 1; i <=value/2; i++){
			for(int k = value; k >=i; k--){
				System.out.print(" ");
			}
			for(int j = 1; j <=i; j++){
				System.out.print("* ");
			}
			System.out.println();
		}
		for(int i = (value/2)-1; i >=0; i--){
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
