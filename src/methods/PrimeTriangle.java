package methods;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeTriangle {

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

    public static void Primes(List<Integer> primeList, int N)
    {
        for(int i=1; i <= N; i++)
        {
            if(isPrime(i))
                primeList.add(i);
        }
    }

    public static void DrawTriangle(List<Integer> primeList)
    {
        for(int i=0; i < primeList.size(); i++)
        {
            for(int j=1; j <= primeList.get(i); j++)
            {
                if(isPrime(j))
                    System.out.print(1);
                else
                    System.out.print(0);
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        List<Integer> primeNumbers = new ArrayList<>();
        Primes(primeNumbers, N);
        DrawTriangle(primeNumbers);
    }
}
