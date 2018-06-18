package org.sunnyslls.microsoft;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by sunny on 20/1/18.
 */
public class ModifyTheMatrix {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        //final String fileName = System.getenv("OUTPUT_PATH");
        //BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int[][] res;

        int _arr_rows = 0;
        int _arr_cols = 0;
        _arr_rows = Integer.parseInt(in.nextLine().trim());
        _arr_cols = Integer.parseInt(in.nextLine().trim());

        int[][] _arr = new int[_arr_rows][_arr_cols];
        for(int _arr_i=0; _arr_i<_arr_rows; _arr_i++) {
            for(int _arr_j=0; _arr_j<_arr_cols; _arr_j++) {
                _arr[_arr_i][_arr_j] = in.nextInt();

            }
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }

        res = modifyMatrix(_arr);
        int res_rowLength = res.length;
        int res_colLength = res[0].length;
        for(int res_i=0; res_i < res_rowLength; res_i++) {
            for(int res_j=0; res_j < res_colLength; res_j++) {
                System.out.print(String.valueOf(res[res_i][res_j]) + " ");
            }
            //bw.newLine();
        }

        //bw.close();
    }

    static int[][] modifyMatrix(int[][] arr) {
        int row = arr.length;
        int column = arr[0].length;
        int[][] result = new int[row][column];

        for(int i=0; i<row; i++) {
            for(int j=0; j<column; j++) {
                if(arr[i][j] == 1) {
                    for (int x = 0; x < row; x++) {
                        result[x][j] = 1;
                    }

                    for (int y = 0; y < column; y++) {
                        result[i][y] = 1;
                    }
                }

            }
        }
        return result;

    }

}
