/*
 * A queen is standing on an  chessboard. The chessboard's rows are numbered from  to , going from bottom to top; its columns are numbered from  to , going from left to right. Each square on the board is denoted by a tuple, , describing the row, , and column, , where the square is located.

The queen is standing at position  and, in a single move, she can attack any square in any of the eight directions (left, right, up, down, or the four diagonals). In the diagram below, the green circles denote all the cells the queen can attack from :

image

There are  obstacles on the chessboard preventing the queen from attacking any square that has an obstacle blocking the the queen's path to it. For example, an obstacle at location  in the diagram above would prevent the queen from attacking cells , , and :

image

Given the queen's position and the locations of all the obstacles, find and print the number of squares the queen can attack from her position at .

Input Format

The first line contains two space-separated integers describing the respective values of  (the side length of the board) and  (the number of obstacles). 
The next line contains two space-separated integers describing the respective values of  and , denoting the position of the queen. 
Each line  of the  subsequent lines contains two space-separated integers describing the respective values of and , denoting the position of obstacle .

Constraints

A single cell may contain more than one obstacle; however, it is guaranteed that there will never be an obstacle at position  where the queen is located.
Subtasks

For  of the maximum score:

For  of the maximum score:

Output Format

Print the number of squares that the queen can attack from position .

Sample Input 0

4 0
4 4
Sample Output 0

9
Explanation 0

The queen is standing at position  on a  chessboard with no obstacles:

image

We then print the number of squares she can attack from that position, which is .

Sample Input 1

5 3
4 3
5 5
4 2
2 3
Sample Output 1

10
Explanation 1

The queen is standing at position  on a  chessboard with  obstacles:

image

We then print the number of squares she can attack from that position, which is .
 */

package org.sunnyslls.queenwalk;

import java.util.Scanner;

public class QueenWalk {

	private static final int OBSTACLE = 2;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int rQueen = in.nextInt();
		int cQueen = in.nextInt();
		int[][] chessBoard = new int[n + 1][n + 1];
		chessBoard[rQueen][cQueen] = 1;

		for (int a0 = 0; a0 < k; a0++) {
			int rObstacle = in.nextInt();
			int cObstacle = in.nextInt();
			chessBoard[rObstacle][cObstacle] = OBSTACLE;
		}
		
		System.out.println(move(chessBoard, rQueen, cQueen, n));
		
		print(chessBoard, n);

	}

	static void print(int[][] arr, int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	static final int move(int[][] chessBoard, int qRow, int qCol, int n) {

		int moves = 0;
		// left
		for (int i = qCol - 1; i >= 1; i--) {
			if (chessBoard[qRow][i] != OBSTACLE) {
				moves++;
				chessBoard[qRow][i] = 9;
			} else {
				break;
			}
		}

		// right
		for (int i = qCol + 1; i <= n; i++) {
			if (chessBoard[qRow][i] != OBSTACLE) {
				moves++;
				chessBoard[qRow][i] = 9;
			} else {
				break;
			}
		}

		// top
		for (int i = qRow - 1; i >= 1; i--) {
			if (chessBoard[i][qCol] != OBSTACLE) {
				moves++;
				chessBoard[i][qCol] = 9;
			} else {
				break;
			}
		}

		// bottom
		for (int i = qRow + 1; i <= n; i++) {
			if (chessBoard[i][qCol] != OBSTACLE) {
				moves++;
				chessBoard[i][qCol] = 9;
			} else {
				break;
			}
		}

		// left top diagonal

		int i = qRow - 1;
		int j = qCol - 1;
		while (i >= 1 && j >= 1) {
			if (chessBoard[i][j] != OBSTACLE) {
				moves++;
				chessBoard[i][j] = 9;
			} else {
				break;
			}
			i--;
			j--;
		}

		// right bottom diagonal
		i = qRow + 1;
		j = qCol + 1;
		while (i <= n && j <= n) {
			if (chessBoard[i][j] != OBSTACLE) {
				moves++;
				chessBoard[i][j] = 9;
			} else {
				break;
			}
			i++;
			j++;
		}

		// left bottom diagonal

		i = qRow + 1;
		j = qCol - 1;
		while (i <= n && j >= 1) {
			if (chessBoard[i][j] != OBSTACLE) {
				moves++;
				chessBoard[i][j] = 9;
			} else {
				break;
			}
			i++;
			j--;
		}

		// right top diagonal

		i = qRow - 1;
		j = qCol + 1;
		while (i >= 1 && j <= n) {
			if (chessBoard[i][j] != OBSTACLE) {
				moves++;
				chessBoard[i][j] = 9;
			} else {
				break;
			}
			i--;
			j++;
		}
		
		return moves;
	}
	

}
