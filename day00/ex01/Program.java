package com.company;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        boolean status = true;
        int i = 1;

        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        if (number <= 1){
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
        else if (number == 2 || number == 3)
        {
            System.out.println(status + " " + i);
        }
        else {
            while (i <= mySqrt(number)) {
                if (number % (++i) == 0) {
                    status = false;
                    break;
                }
            }
            System.out.println(status + " " + (i - 1));
        }
        System.exit(0);
    }

    private static int mySqrt(int input){
        long start = 1;
        long iter = 1;
        long result = 0;

        while(start - input <= 0){
            iter += 2;
            start += iter;
            result++;
        }
        return (int)result;

    }

}
