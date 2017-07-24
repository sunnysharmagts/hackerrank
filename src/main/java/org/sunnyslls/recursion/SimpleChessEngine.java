package org.sunnyslls.recursion;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by sunny on 12/7/17.
 */
public class SimpleChessEngine {

    private static final int[] knightMoveX = {2, 2, -2, -2, 1, -1, 1, -1};
    private static final int[] knightMoveY = {1, -1, 1, -1, 2, 2, -2, -2};

    private Piece[][] grid = new Piece[4][4];
    private int maxMoves;
    private static final HashMap<String, String> map = new HashMap<>();
    private static final HashMap<String, Integer> locationMap = new HashMap<>();

    static {
        map.put("N", "Knight");
        map.put("R", "Rook");
        map.put("Q", "Queen");
        map.put("B", "Bishop");

        locationMap.put("A", 0);
        locationMap.put("B", 1);
        locationMap.put("C", 2);
        locationMap.put("D", 3);
    }

    public static void main(String[] args){
        new SimpleChessEngine().populate();
    }

    public void populate(){
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for(int i = 0; i < testCases; i++){
            int numberOfWhites = scanner.nextInt();
            int numberOfBlacks = scanner.nextInt();
            maxMoves = scanner.nextInt();

            for(int w = 0; w < numberOfWhites; w++){
                String value = scanner.next();
                int locationY = locationMap.get(scanner.next());
                int locationX = scanner.nextInt()-1;

                grid[locationX][locationY] = new White(value);
            }

            for(int b = 0; b < numberOfBlacks; b++){
                String value = scanner.next();
                int locationY = locationMap.get(scanner.next());
                int locationX = scanner.nextInt()-1;

                grid[locationX][locationY] = new Black(value);
            }
            display();
        }
    }

    abstract class Piece{

    }

    private void display(){

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }

    class Black extends Piece{

        String piece;

        Black(String piece){
            this.piece = piece;
        }

        @Override
        public int hashCode() {
            return 1;
        }

        @Override
        public boolean equals(Object o) {
            if(!(o instanceof Black)) return false;
            Black black = (Black) o;
            return black.piece == piece;
        }

        @Override
        public String toString() {
            return "Black "+map.get(piece);
        }
    }

    class White extends Piece{

        String piece;

        White(String piece){
            this.piece = piece;
        }

        @Override
        public int hashCode() {
            return 2;
        }

        @Override
        public boolean equals(Object o) {
            if(!(o instanceof White)) return false;
            White black = (White) o;
            return black.piece == piece;
        }

        @Override
        public String toString() {
            return "White "+map.get(piece);
        }
    }
}
