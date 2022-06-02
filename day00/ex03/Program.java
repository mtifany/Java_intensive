package com.company;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        long result = 0;
        long reverse = 0;
        int i = 1;
        Scanner sc = new Scanner(System.in);
        while(true) {
            String  week = (sc.next());
              if (week.equals("42")){
               break;
            }
            week = (week + " " + sc.next());

            if (!week.equals("Week " + i) || i > 18) {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }
            int  number = sc.nextInt();
            if (number < 1 || number > 10){
                System.err.println("IllegalArgument");
                System.exit(-1);

            }
            for (int j = 0; j < 4; j++) {
                int next = sc.nextInt();
                if (next < 1 || next> 10){
                    System.err.println("IllegalArgument");
                    System.exit(-1);
                }
                if (number > next) {
                    number = next;
                }
            }
            result = result * 10 + number;
        i++;
        }

        while(result != 0){
            reverse = reverse * 10 + result % 10;
            result = result / 10;
        }
           Printer(reverse, 1);
    }
    private static void Printer(long result, int k){

       if (result == 0) {
            return;
        }
            System.out.print("Week ");
            System.out.print(k);
            System.out.print(" ");
           for(long j = 0; j < result % 10; j++) {
               System.out.print("=");
           }
            System.out.print(">");
            System.out.println();
            result = result / 10;
            ++k;
            Printer(result, k);

    }
}
