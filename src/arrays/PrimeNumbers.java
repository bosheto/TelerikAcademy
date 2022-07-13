package arrays;

import java.util.Scanner;

public class PrimeNumbers {

    static boolean isPrime(int n)
    {
        if(n==1)
            return true;
        for(int i=2; i<n; i++)
        {
            if(n%i==0)
                return false;
        }
        return true;
    }

    public static void main(String[] args)
    {
      Scanner scanner = new Scanner(System.in);
      int N = Integer.parseInt(scanner.nextLine());

      for(int i=1; i <= N; i++)
      {
            if(isPrime(i))
                System.out.print(i + " ");
      }

    }
}

