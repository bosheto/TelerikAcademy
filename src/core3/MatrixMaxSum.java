package core3;

import java.util.List;
import java.util.Scanner;

public class MatrixMaxSum {

    /*
    On the first line, you receive an integer N - the number of rows in the matrix
    On the next N lines, each row of the matrix is given, with columns separated by a space
    On the last line, the R and C coordinates are given, separated by space

    N will be an integer between 5 and 20, inclusive.
    All rows have the exact same length, also between 5 and 20, inclusive.
    The R and C coordinates will always be valid and inside the matrix.
    The R C pairs will be at least 1 and no more than 20.
    Matrix elements will have values in range -5000 and 5000.
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int matrixRows = Integer.parseInt(scanner.nextLine());
        String[] rawRows = new String[matrixRows];
        for(int i = 0; i < matrixRows; i++)
        {
            rawRows[i] = scanner.nextLine();
        }
        int matrixColumns = rawRows[0].split(" ").length;
        String[] rawCoords = scanner.nextLine().split(" ");

        long[][] matrix = new long[matrixRows][matrixColumns];

        for(int y = 0; y < matrix.length; y++)
        {
            for(int x = 0; x < matrix[0].length; x++)
            {
                String[] row = rawRows[y].split(" ");
                matrix[y][x] = Long.getLong(row[x]);
            }
        }
        int[][] coords = new int[rawCoords.length / 2][2];
        for(int i=0; i < coords.length; i += 2)
        {

        }
    }
}
