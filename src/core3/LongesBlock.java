package core3;

import java.util.Scanner;

public class LongesBlock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String longestSequence = "";
        String sequence = "";
        for(int i =1; i < input.length(); i++)
        {
           if(input.charAt(i) == input.charAt(i-1))
           {
               if(sequence.length() == 0)
                   sequence += input.charAt(i-1);
               sequence += input.charAt(i);
           }else {
               sequence = "";
           }
            if (sequence.length() > longestSequence.length())
                longestSequence = sequence;
        }
        if(longestSequence.isEmpty())
            longestSequence += input.charAt(0);
        System.out.println(longestSequence);
    }
}
