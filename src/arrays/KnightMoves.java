package arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KnightMoves {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int boardSize = Integer.parseInt(scanner.nextLine());
        int[][] board = new int[boardSize][boardSize];
        List<Integer> pastMoves = new ArrayList<>();
        board[1][2] = 1;


        // Knight move table
        int[][] knightMoves = {
                {1, 2},
                {2, 1},
                {1, -2},
                {2, -1},
                {-2, -1},
                {-1, -2},
                {-2, 1},
                {-1, 2}
        };

        Position pos = new Position(0, 0);
        while(true)
        {

            // Get possible moves
            List<Position> possibleMoves = new ArrayList<>();
            for (int[] move : knightMoves) {
                Position new_pos = new Position(pos.x + move[1],pos.y + move[0]);
                if(new_pos.x < 0 || new_pos.x > boardSize || new_pos.y < 0 || new_pos.y >boardSize)
                    continue;
                possibleMoves.add(new_pos);
            }

            // Find best move
            Position bestMove = null;
            for (Position move : possibleMoves) {

                if(bestMove == null)
                {
                    bestMove = move;
                }else{
                    if(board[move.y][move.x] == 0 && move.x < bestMove.x && move.y < bestMove.y)
                    {
                        bestMove = move;
                    }
                }
            }

            pastMoves.add(board[bestMove.y][bestMove.x]);
            System.out.println(pastMoves.get(1));
            bestMove.Print();
            break;

        }
    }

    public static class Position
    {
        public int x;
        public int y;

        public Position(int X, int Y) {
            x = X;
            y = Y;
        }

        public void Print(){
            System.out.println(y + " " + x);

        }
    }
}
