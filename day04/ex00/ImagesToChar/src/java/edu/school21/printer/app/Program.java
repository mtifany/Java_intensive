package edu.school21.printer.app;


import edu.school21.printer.logic.Logic;

import java.io.IOException;

public class Program {

    public static void main(String[] args) throws IOException {

        if(args.length != 3){
            System.out.println("Wrong arguments!");
            System.exit(-1);
        }

        char white = args[0].charAt(0);
        char black = args[1].charAt(0);
        String path = args[2];

        int[][] array = Logic.openBMP(path, white, black);
        int[][] array_new =new int[array[0].length][array.length];
        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array[x].length; y++) {
                array_new[y][x] = array[x][y];
            }
        }
        for (int i = 0; i < array_new.length; i++) {
            for (int j = 0; j < array_new[i].length; j++) {
                System.out.print((char) array_new[i][j]);

            }
            System.out.println();
        }

    }
}