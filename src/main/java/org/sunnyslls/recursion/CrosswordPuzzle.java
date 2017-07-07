/**
 * A  Crossword grid is provided to you, along with a set of words (or names of places) which need to be filled into the grid.
 * The cells in the grid are initially, either + signs or - signs.
 * Cells marked with a + have to be left as they are. Cells marked with a - need to be filled up with an appropriate character.
 * <p>
 * Input Format
 * <p>
 * The input contains  lines, each with  characters (which will be either + or - signs).
 * After this follows a set of words (typically nouns and names of places), separated by semi-colons (;).
 * <p>
 * Constraints
 * <p>
 * There will be no more than ten words. Words will only be composed of upper-case A-Z characters. There will be no punctuation (hyphen, dot, etc.) in the words.
 * <p>
 * Output Format
 * <p>
 * Position the words appropriately in the  grid, and then display the  grid as the output. So, your output will consist of  lines with  characters each.
 * <p>
 * Sample Input 0
 * <p>
 * +-++++++++
 * +-++++++++
 * +-++++++++
 * +-----++++
 * +-+++-++++
 * +-+++-++++
 * +++++-++++
 * ++------++
 * +++++-++++
 * +++++-++++
 * LONDON;DELHI;ICELAND;ANKARA
 * Sample Output 0
 * <p>
 * +L++++++++
 * +O++++++++
 * +N++++++++
 * +DELHI++++
 * +O+++C++++
 * +N+++E++++
 * +++++L++++
 * ++ANKARA++
 * +++++N++++
 * +++++D++++
 * Sample Input 1
 * <p>
 * +-++++++++
 * +-++++++++
 * +-------++
 * +-++++++++
 * +-++++++++
 * +------+++
 * +-+++-++++
 * +++++-++++
 * +++++-++++
 * ++++++++++
 * AGRA;NORWAY;ENGLAND;GWALIOR
 * Sample Output 1
 * <p>
 * +E++++++++
 * +N++++++++
 * +GWALIOR++
 * +L++++++++
 * +A++++++++
 * +NORWAY+++
 * +D+++G++++
 * +++++R++++
 * +++++A++++
 * ++++++++++
 */
package org.sunnyslls.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class CrosswordPuzzle {

    private static final char PLUS = '+';
    private static final char EMPTY = '-';
    private static final int VERTICAL = 1;
    private static final int HORIZONTAL = 2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] grid = new char[10][10];
        for (int i = 0; i < grid.length; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < grid.length; j++) {
                grid[i][j] = line.charAt(j);
            }
        }
        String word = sc.nextLine();
        sc.close();
        String[] words = word.split(";");
        List<String> set = new ArrayList<>();
        for (String w : words) {
            set.add(w);
        }
        new CrosswordPuzzle().crossword(grid, set);
    }

    public char[][] crossword(char[][] grid, List<String> wordSet) {
        crossword(grid, wordSet, new HashSet<String>(), 0, 0);
        return grid;
    }

    public boolean crossword(char[][] grid, List<String> wordSet, HashSet<String> usedWords, int row, int column) {
        Coordinate c = new Coordinate(row, column);
        if (!emptyCell(grid, c)) {
            printSolution(grid);
            return true;
        }
        row = c.row;
        column = c.column;
        int type = checkVerticalOrHorizontal(grid, c);
        int wordSize = getWordSize(grid, c, type);

        for (int i = 0; i < wordSet.size(); i++) {
            String currentWord = getWordBasedOnSize(i, wordSize, wordSet, usedWords, grid, type, c);
            if (currentWord != null) {
                setWord(grid, c, type, wordSize, currentWord);
                printSolution(grid);
                if (crossword(grid, wordSet, usedWords, row, column)) {
                    return true;
                } else {
                    setWord(grid, c, type, wordSize, revertWord(wordSize));
                    printSolution(grid);
                    usedWords.remove(currentWord);
                }
            }
        }
        return false;
    }

    String revertWord(int wordSize) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < wordSize; i++) {
            sb.append(EMPTY);
        }
        return sb.toString();
    }

    String getWordBasedOnSize(int index, int wordSize, List<String> wordSet, HashSet<String> usedWords, char[][] grid,
                              int type, Coordinate c) {
        String word = wordSet.get(index);
        if (word.length() != wordSize) {
            return null;
        }
        if (!usedWords.contains(word) && checkWord(word, wordSize, grid, type, c)) {
            usedWords.add(word);
            return word;
        }
        return null;
    }

    boolean checkWord(String word, int wordSize, char[][] grid, int type, Coordinate c) {
        int index = 0;
        if (type == HORIZONTAL) {
            for (int i = c.column; i < wordSize; i++) {
                if ((grid[c.row][i] != EMPTY) && grid[c.row][i] != word.charAt(index)) {
                    return false;
                }
                index++;
            }
        } else {
            for (int i = c.row; i < wordSize; i++) {
                if ((grid[i][c.column] != EMPTY) && grid[i][c.column] != word.charAt(index)) {
                    return false;
                }
                index++;
            }
        }
        return true;
    }

    void setWord(char[][] grid, Coordinate c, int type, int wordSize, String word) {

        int index = 0;
        if (type == HORIZONTAL) {
            for (int i = c.column; i < wordSize + c.column; i++) {
                grid[c.row][i] = word.charAt(index);
                index++;
            }
        } else {
            for (int i = c.row; i < wordSize + c.row; i++) {
                grid[i][c.column] = word.charAt(index);
                index++;
            }
        }
    }

    int checkVerticalOrHorizontal(char[][] grid, Coordinate c) {
        if (c.column < grid.length - 1 && grid[c.row][c.column + 1] == EMPTY) {
            return HORIZONTAL;
        } else if (c.row < grid.length - 1 && grid[c.row + 1][c.column] == EMPTY) {
            return VERTICAL;
        }
        return -1;
    }

    int getWordSize(char[][] grid, Coordinate c, int type) {
        int wordSize = 0;
        int prevFilled = 0;
        if (type == HORIZONTAL) {
            for (int i = c.column - 1; i >= 0; i--) {
                if (grid[c.row][i] != PLUS) {
                    prevFilled++;
                } else {
                    break;
                }
            }
            for (int i = c.column; i < grid.length; i++) {
                if (grid[c.row][i] != PLUS) {
                    wordSize++;
                } else {
                    break;
                }
            }
            wordSize += prevFilled;
            c.column -= prevFilled;
        } else {
            for (int i = c.row - 1; i >= 0; i--) {
                if (grid[i][c.column] != PLUS) {
                    prevFilled++;
                } else {
                    break;
                }
            }
            for (int i = c.row; i < grid.length; i++) {
                if (grid[i][c.column] != PLUS) {
                    wordSize++;
                } else {
                    break;
                }
            }
            wordSize += prevFilled;
            c.row -= prevFilled;
        }
        return wordSize;
    }

    boolean emptyCell(char[][] grid, Coordinate coordinate) {
        int row = coordinate.row;
        int column = coordinate.column;

        for (row = 0; row < grid.length; row++) {
            for (column = 0; column < grid.length; column++) {
                if (grid[row][column] == EMPTY) {
                    coordinate.row = row;
                    coordinate.column = column;
                    return true;
                }
            }
        }
        return false;
    }

    static void printSolution(char sol[][]) {
        int N = sol.length;
        for (int i = 0; i < sol.length; i++) {
            for (int j = 0; j < sol.length; j++)
                System.out.print(sol[i][j]);
            System.out.println();
        }
        System.out.println();
    }

    static class Coordinate {
        int row;
        int column;

        public Coordinate(int row, int column) {
            this.row = row;
            this.column = column;
        }

        @Override
        public String toString() {
            return "Row :" + row + " Column: " + column;
        }
    }
}
