package com.company;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
       int result = 0;
           int j = 0;
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextLine()) {
            System.err.println("Illegal Argument");
            System.exit(-1);
        }

        char[] charArray = sc.nextLine().toCharArray();
        if (charArray.length == 0){
            System.exit(0);
        }
        int[] array = new int[65536];
        for (char c : charArray){
            array[c]++;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0)
                result++;
        }
        if (result == 0){
            System.exit(0);
        }
        int[][] array2 = new int[result][2];
        for (int i = 0; i <65536; i++)  {
            if (array[i] != 0) {
                array2[j][0] = i;
                array2[j][1] = array[i];
                j++;
            }
        }
        for (int n = result -1; n >=1; n--){
            for(int k = 0; k < n; k++){
                if(array2[k][1] > array2[k+1][1]) {
                    int tmp = array2[k][1];
                    array2[k][1] = array2[k + 1][1];
                    array2[k + 1][1] = tmp;
                    int tmp2 = array2[k][0];
                    array2[k][0] = array2[k + 1][0];
                    array2[k + 1][0] = tmp2;
                }
            }
        }

        int[][] finalarray = new int[10][2];
        for (int i = 0; ((i < 10) && (result - i - 1 >= 0)); i++){
         finalarray[i][0] =  array2[result - i - 1][0];
            finalarray[i][1]= array2[result - i - 1][1];
        }
        int max = finalarray[0][1];

        if (max > 999) {
            System.err.println("Illegal Argument");
            System.exit(-1);
        }
        int size;
        if (result < 10) {
         size = result;
        } else
           size = 10;

        for (int i = 11; i > 0; i--) {
            int height = (max * i);
            int heightNext = (max * (i - 1));

            for (j = 0; j < size; j++) {
                if (finalarray[j][1] * 10 >= height) {
                    System.out.print("  #");
                } else if (finalarray[j][1]* 10 >= heightNext) {
                    System.out.printf("  %d", finalarray[j][1]);
                } else {
                    break;
                }
            }
            System.out.println();
        }

        for (int i = 0; i < size; i++) {
            System.out.printf("  %c", (char) finalarray[i][0]);
        }
        System.out.println();

    }
}