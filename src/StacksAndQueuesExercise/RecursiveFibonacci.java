package StacksAndQueuesExercise;

import java.util.Scanner;

public class RecursiveFibonacci {
    public static long[] memorization;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        int n = Integer.parseInt(scan.nextLine());

        memorization = new long[n + 1];


        for (int i = 0; i < n; i++) {
            System.out.print(findFibonacci(i) + " ");
        }
    }

    public static long findFibonacci(int n) {
        if(n <= 1){
            return 1;
        }
        if(memorization[n] != 0 ){
            return memorization[n];
        }else{
            memorization [n] = findFibonacci(n - 1) + findFibonacci(n - 2);
        }
        return memorization[n];
    }
}
