package methods;

import java.util.Scanner;

public class Bounce {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String[] boardSize = scanner.nextLine().split(" ");
        int R = Integer.parseInt(boardSize[0]);
        int C = Integer.parseInt(boardSize[1]);
        long[][] board = new long[R][C];
        int firsElem = 1;
        for(int y = 0; y < board.length; y ++)
        {
            board[y][0] = firsElem;
            for(int x = 1; x < board[0].length; x++)
            {
                board[y][x] = board[y][x-1] * 2;
            }
            firsElem *= 2;
        }

        int currentR = 0;
        int currentC = 0 ;
        long sum = 1;
        int hDir = 1;
        int vDir = 1;
        if(R == 1 || C == 1)
        {
            System.out.println(sum);
            return;
        }

        while (true)
        {

            int nextR = currentR + vDir;
            int nextC = currentC + hDir;

            if (nextR < 0 || R <= nextR)
                vDir *= -1;

            if(nextC < 0 || C <= nextC)
                hDir *= -1;

            currentC += vDir;
            currentR += hDir;

            sum += board[currentR][currentC];

            if(currentR == 0 && currentC == 0 || currentR == 0 && currentC == C-1 || currentR == R-1 && currentC == 0 || currentR == R-1 && currentC == C -1)
                break;
        }
        System.out.println(sum);
    }
}
