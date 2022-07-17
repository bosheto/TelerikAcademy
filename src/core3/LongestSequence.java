package core3;

import java.util.Scanner;

public class LongestSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arrLength = Integer.parseInt(scanner.nextLine());
        int[] numberArray = new int[arrLength];
        for(int i = 0; i < numberArray.length; i++)
        {
            numberArray[i] = Integer.parseInt(scanner.nextLine());
        }

        int longestSequence = 1;
        int sequence = 1;
        for(int i = 1; i < numberArray.length; i++)
        {
            if(numberArray[i] > numberArray[i-1])
            {
                sequence++;
            }else{
                if(sequence > longestSequence)
                    longestSequence = sequence;
                sequence = 1;
            }
        }
        System.out.println(longestSequence);
    }
}
