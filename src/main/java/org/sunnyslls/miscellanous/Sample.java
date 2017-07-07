package org.sunnyslls.miscellanous;
import java.util.Scanner;

public class Sample {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[][] = new int[n][n];
        int i = 0;
        int j = 0;
        int leftDiagonal = 0;
        for(int x = 0; x < n; x++){
            for(int y = 0; y < n; y++){
                a[x][y] = in.nextInt();
            }
        }
        while(i < n && j < n){
            leftDiagonal += a[i++][j++]; 
        }
        
        i = 0;
        j = n-1;
        int rightDiagonal = 0;
        while(i < n && j >= 0){
            rightDiagonal += a[i++][j--];
        }
        System.out.println(Math.abs(leftDiagonal - rightDiagonal));
    }
}
