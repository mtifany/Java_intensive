package edu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.awt.*;

public class Logic {

    public static int[][] openBMP(String path, char w, char b) throws IOException {

        BufferedImage image = ImageIO.read(new FileInputStream(path));


        int[][] array = new int[image.getWidth()][image.getHeight()];
        for (int i = 0; i < image.getWidth(); i++) {

            for (int j = 0; j < image.getHeight(); j++) {
                int color = image.getRGB(i,j);
                if (color == -1){
                    array[i][j] = w;
                } else if (color == -16777216){
                    array[i][j] = b;
                } else {
                    System.out.println("Wrong color on the image!");
                    System.exit(-1);
                }

            }

        }

        return array;
    }
}
