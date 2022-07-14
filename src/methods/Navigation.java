package methods;

import java.math.BigInteger;
import java.util.Scanner;

public class Navigation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());
        BigInteger[][] board = new BigInteger[rows][columns];

        // Fill board
        for (int r = board.length - 1; r >= 0; r--) {
            for (int c = 0; c < board[0].length; c++) {
                if (r == board.length - 1) {
                    if (c == 0)
                        board[r][c] = BigInteger.valueOf(1);
                    else {
                        board[r][c] = board[r][c - 1].multiply(BigInteger.valueOf(2));
                    }
                } else {
                    if (c == 0) {
                        board[r][c] = board[r + 1][c].multiply(BigInteger.valueOf(2));
                        continue;
                    }
                    board[r][c] = board[r][c - 1].multiply(BigInteger.valueOf(2));
                }
            }
        }

        int numberOfMoves = Integer.parseInt(scanner.nextLine());

        // Get codes
        String[] rawCODES = scanner.nextLine().split(" ");
        int[] CODES = new int[rawCODES.length];
        for (int i = 0; i < CODES.length; i++) {
            CODES[i] = Integer.parseInt(rawCODES[i]);
        }

        // Get target cell coordinates
        int[][] targetCells = new int[CODES.length][2];
        int COEF = Math.max(rows, columns);
        for (int i = 0; i < CODES.length; i++) {
            targetCells[i][0] = CODES[i] / COEF;
            targetCells[i][1] = CODES[i] % COEF;
        }


        BigInteger sum =  BigInteger.ZERO;
        int currentR = rows - 1;
        int currentC = 0;
        for (int[] cell : targetCells) {

            int horizontalDirection;
            if (currentC <= cell[1])
                horizontalDirection = 1;
            else
                horizontalDirection = -1;

            int verticalDirection;
            if(currentR <= cell[0])
                verticalDirection = 1;
            else
                verticalDirection = -1;

            while(currentC != cell[1] || currentR != cell[0])
            {
                if(!board[currentR][currentC].equals(BigInteger.ZERO))
                {
                    sum = sum.add(board[currentR][currentC]);
                    board[currentR][currentC] = BigInteger.ZERO;
                }

                if(currentC != cell[1])
                {
                    currentC += horizontalDirection;
                    continue;
                }

                if (currentR != cell[0])
                    currentR += verticalDirection;

            }
        }
        if(!board[currentR][currentC].equals(BigInteger.ZERO))
        {
            sum = sum.add(board[currentR][currentC]);
            board[currentR][currentC] = BigInteger.ZERO;
        }

        System.out.println(sum);
    }
}
