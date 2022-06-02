package com.company;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        int result = 0;
        Scanner sc = new Scanner(System.in);
        while (true) {
            int number = sc.nextInt();

            if (number < 2) {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }
            int c = getnumber(number);
            if (primecheck(c))
                result++;
            if (number == 42) {
                break;
            }

        }
        System.out.println("Count of coffee - request - " + result);
    }

    private static int getnumber(int input) {
        int i = 0;

        while (input != 0) {
            i += input % 10;
            input /= 10;

        }

        return i;
    }
    private static boolean primecheck(int number) {
        int i = 1;
        if (number <= 1) {
            return (false);
        } else if (number == 2 || number == 3) {
            return (true);
        }
        else {
            while (i <= mySqrt(number)) {
                if (number % (++i) == 0) {
                    return (false);
                }
            }
            return (true);
        }

    }
    private static int mySqrt(int input) {
        long start = 1;
        long iter = 1;
        long result = 0;

        while (start - input <= 0) {
            iter += 2;
            start += iter;
            result++;
        }
        return (int) result;
    }
}