package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Tasks {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int numberOfArrays = Integer.parseInt(scanner.nextLine());
//
//        int[][] arrs = new int[numberOfArrays][];
//        for(int i = 0; i < numberOfArrays; i++)
//        {
//            String[] input = scanner.nextLine().split(", ");
//            int[] out_arr = new int[input.length];
//            for(int l = 0; l < input.length; l++) {
//                out_arr[l] = Integer.parseInt(input[l]);
//            }
//            arrs[i] = out_arr;
//        }
//
//        for(int i= 0; i < arrs.length; i++)
//        {
//
//        }
//        Scanner scanner = new Scanner(System.in);
//        int input = Integer.parseInt(scanner.nextLine());
//        List output = new ArrayList<>();
//        for(int i = 1; i <= input; i++)
//        {
//
//        }
//
//        System.out.println(output);
//        Scanner scanner = new Scanner(System.in);
//        int numberOfnumbers = Integer.parseInt(scanner.nextLine());
//        int[] numbers = new int[numberOfnumbers];
//        for(int i = 0; i < numbers.length; i++){
//            numbers[i] = Integer.parseInt(scanner.nextLine());
//        }
//
//        int longestSequence = 0;
//        int sequence = 1;
//        for(int i = 1; i < numbers.length; i++)
//        {
//            if(numbers[i] == numbers[i-1])
//            {
//                sequence ++;
//            }else{
//                if(sequence > longestSequence){
//                    longestSequence = sequence;
//                }
//                sequence = 1;
//            }
//
//        }
//        System.out.println(longestSequence);
//    }

        Scanner scanner = new Scanner(System.in);
        int grid_size = Integer.parseInt(scanner.nextLine());

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

        boolean[][] board = new boolean[grid_size][grid_size];
        board[2][1] = true;
        Position pos = new Position(0,0);

        while(true)
        {
            List<Position> possibleMoves = new ArrayList<>();
            for (int[] move : knightMoves) {
                Position new_pos = new Position(pos.x + move[0], pos.y + move[1]);
                if(new_pos.x < 0 || new_pos.x > grid_size-1 || new_pos.y < 0 || new_pos.y > grid_size -1 ) {
                    continue;
                }
                possibleMoves.add(new_pos);
            }
            Position best_move = null;
            for (Position possibleMove : possibleMoves) {
                if(best_move == null)
                {
                    best_move = possibleMove;
                }else{
                     if(possibleMove.x < best_move.x && possibleMove.y < best_move.y){
                             best_move = possibleMove;
//                             board[best_move.x][best_move.y] = true;
                     }
                }
            }
            best_move.Print();
            System.out.println(Arrays.toString(board[1]));
            break;
        }
    }

    public static class Position {
        public int x = 0;
        public int y = 0;
        public Position(int X, int Y){
            x = X;
            y = Y;
        }

        public void Print()
        {
            System.out.println(x + " " + y);
        }
    }
}
