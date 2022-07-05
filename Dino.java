/*
Assignment 2 Java program
Written by: Khanh Linh Tran
Registration numer: 200188605
*/

import sheffield.*;
public class Dino {

    public static void main (String[]args) {

        //Read in the file
        EasyReader fileInput = new EasyReader("dino.txt");
        String text = fileInput.readString();

        //Constants
        int SCALE = 4;
        int COLUMNS = 123;
        int ROWS = 35;
        int WIDTH = (COLUMNS-1) *SCALE *2; //(-1) because the starting point is 0
        int HEIGHT = (ROWS-1) *SCALE; //(-1) because the starting point is 0
        int MAX_FILE_SIZE = 4305;

        EasyGraphics g = new EasyGraphics(WIDTH, HEIGHT);
        //colour the background in black 
        g.setColor(1,2,11);
        g.fillRectangle(0,0,WIDTH,HEIGHT);

        //create stars
        for (int x=0; x<50; x++) {
            int row = (int)(Math.random()*(ROWS-7)); //random numbers from 0 to (ROWS-7)
            int col = (int)(Math.random()*((COLUMNS-1)*2)); //random numbers from 0 to (COLUMNS-1)*2)

            g.setColor(250,250,250); //colour the stars
            g.fillRectangle(col*SCALE, Math.abs(HEIGHT-row*SCALE),1,1); //draw the stars
        }

        //set up a 2D array
        int [][] array = new int[ROWS][COLUMNS];

        //store file values into the array
        for (int index = 0; index<MAX_FILE_SIZE; index++) {
            int row = index/ COLUMNS;
            int col = index - row*COLUMNS;
            array[row][col] = (int)text.charAt(index);
        }

        //colour the third dinosaur (counting from the left)
        for (int row = 0; row<ROWS; row++) {
            for (int col = 0; col<COLUMNS; col++) {
                int pixel = array[row][col];
                if (pixel %2==0) {
                    g.setColor(12,133,65); //colour the dinosaur
                    g.fillRectangle((col+COLUMNS)*SCALE, Math.abs(HEIGHT-row*SCALE), SCALE, SCALE); //draw the dinosaur
                }
                else {
                    if (row >(ROWS-7)) {
                        g.setColor(117,76,23); //colour the horizon
                        g.fillRectangle((col+COLUMNS)*SCALE, Math.abs(HEIGHT-row*SCALE), SCALE, SCALE); //colour the horizon
                    }
                }
            }
        }

        //colour the second dinosaur (counting from the left)
        for (int row = 0; row<ROWS; row++) {
            for (int col = 0; col<COLUMNS; col++) {
                int pixel = array[row][col];
                if (pixel %2==0) {
                    g.setColor(12,133,65); //colour the dinosaur
                    g.fillRectangle((int)(col+COLUMNS/2)*SCALE, Math.abs(HEIGHT-row*SCALE), SCALE, SCALE); //draw the dinosaur
                }
            }
        }

        
        //colour the first dinosaur (counting from the left)
        for (int row = 0; row<ROWS; row++) {
            for (int col = 0; col<COLUMNS; col++) {
                int pixel = array[row][col];
                if (pixel %2==0) {
                    g.setColor(12,133,65); //colour the dinosaur
                    g.fillRectangle(col*SCALE, Math.abs(HEIGHT-row*SCALE), SCALE, SCALE); //draw the dinosaur
                }
                else {
                    if (row >(ROWS-7)) {
                        g.setColor(117,76,23); //colour the horizon
                        g.fillRectangle(col*SCALE, Math.abs(HEIGHT-row*SCALE), SCALE, SCALE); //draw the horizon
                    }
                }
            }
        }
        
    }
}