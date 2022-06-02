package com.company;

public class Program {

    public static void main(String[] args) {
        int number = 777777;
        int i = 0;

        i += number % 10;
        number /= 10;
        i += number % 10;
        number /= 10;
        i += number % 10;
        number /= 10;
        i += number % 10;
        number /= 10;
        i += number % 10;
        number /= 10;
        i += number % 10;

        System.out.println(i);
    }
}
