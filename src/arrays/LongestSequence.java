package arrays;

import java.util.Scanner;

public class LongestSequence {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        int[] nums = new int[N];

        for(int i=0; i < N; i++)
        {
            nums[i] = Integer.parseInt(scanner.nextLine());
        }

        int longestSequence = 0;
        int currentSequence = 0;

        for(int i=0; i < nums.length; i++)
        {
            if(i==0)
                continue;

            if(nums[i] == nums[i-1]) {
                currentSequence++;
            }else{
                if(currentSequence > longestSequence)
                    longestSequence = currentSequence;
                currentSequence = 1;
            }
        }
        System.out.println(longestSequence);
    }

}
