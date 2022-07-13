package methods;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Navigation {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());
        BigInteger[][] board = new BigInteger[rows][columns];

        // Fill board
        for(int r = board.length-1; r >= 0; r--){
            for(int c = 0; c < board[0].length; c++)
            {
                if(r == board.length-1){
                    if(c == 0)
                        board[r][c] = BigInteger.valueOf(1);
                    else{
                        board[r][c] = board[r][c-1].multiply(BigInteger.valueOf(2));
                    }
                }else {
                    if (c == 0)
                    {
                        board[r][c] = board[r+1][c].multiply(BigInteger.valueOf(2));
                        continue;
                    }
                    board[r][c] = board[r][c-1].multiply(BigInteger.valueOf(2));
                }
            }
        }

        int numberOfMoves = Integer.parseInt(scanner.nextLine());

        // Get codes
        String[] rawCODES = scanner.nextLine().split(" ");
        int[] CODES = new int[rawCODES.length];
        for(int i = 0; i < CODES.length; i++)
        {
            CODES[i] = Integer.parseInt(rawCODES[i]);
        }

        int[][] targetCells = new int[CODES.length][2];
        int COEF = Math.max(rows,columns);
        for (int i=0; i < CODES.length; i++ ) {
            targetCells[i][0] = CODES[i] / COEF;
            targetCells[i][1] = CODES[i] % COEF;
        }

        int[] pawn = {4,0};
        BigInteger sum = new BigInteger("0");
        for (int[] cell : targetCells) {
            System.out.println(Arrays.toString(cell));
            for(int x = 0; x <= cell[1]; x++)
            {
                int move = x;
                if(cell[1] < pawn[1])
                    move = -x;
                //ERROR AT CELL [0, 5] PAWN IS STARTS AT [0, 1]
                sum = sum.add(board[pawn[0]][pawn[1] + move]);
            }
            pawn[1] = cell[1];

            if(cell[0] < pawn[0])
                pawn[0] -= 1;
            else
                pawn[0] += 1;

            if(pawn[0] > 0){
                for(int y = 0; y < cell[0]; y++)
                {
                    int move = y;
                    if(cell[0] > pawn[0])
                        move = -y;
                    sum = sum.add(board[pawn[0] + move][pawn[1]]);
                }
                pawn[0] = cell[0];
            }

        }
        /*
        5
        6
        4
        14 27 1 5
         */
        System.out.println(sum);
        System.out.println("FUCK THIS SHIT");
    }
}
