package methods;

import java.util.Scanner;

public class Move {

    /*
    Input
    0
    10,20,30,40,50
    2 forward 1
    2 backwards 1
    3 forward 2
    3 backwards 2
    exit
     */

    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        int currentPos = Integer.parseInt(scanner.nextLine());

        String[] raw_arr = scanner.nextLine().split(",");
        int[] arr = new int[raw_arr.length];

        int forward = 0;
        int backwards = 0;

        for(int i=0; i < raw_arr.length; i++)
        {
            arr[i] = Integer.parseInt(raw_arr[i]);
        }
        while(true)
        {
            String input_raw = scanner.nextLine();
            if(input_raw.equals("exit"))
                break;
            String[] input = input_raw.split(" ");
            int steps = Integer.parseInt(input[0]);
            int dir = (input[1].equals("forward")) ? 1 : 0;
            int stepSize = Integer.parseInt(input[2]);
            for(int i = 0; i < steps; i ++)
            {
                if(dir == 1)
                {
                    int nextPos = currentPos+stepSize;
                    if(nextPos >= arr.length)
                        nextPos %= arr.length;
                    forward += arr[nextPos];
                    currentPos = nextPos;
                }else{
                    int nextPos = currentPos-stepSize;
                    if(nextPos < 0)
                        nextPos = (arr.length - (Math.abs(nextPos) % arr.length)) % arr.length;
                    backwards += arr[nextPos];
                    currentPos = nextPos;
                }
            }
        }
        System.out.println("Forward: " + String.valueOf(forward));
        System.out.println("Backwards: " + String.valueOf(backwards));
    }
}
