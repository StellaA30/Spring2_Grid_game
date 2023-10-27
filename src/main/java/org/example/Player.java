package org.example;

import java.util.Random;

public class Player {

    private int row;
    private int column;
    private static Random random = new Random(); //static field for random number generation

    public Player(int row, int column){
        //Initialise player at random position within the grid
        this.row = random.nextInt(row);
        this.column = random.nextInt(column);
    }


    // move method
    public void move(int newRow, int newColumn){
        this.row = newRow;
        this.column = newColumn;
    }

    public int getRow() {
        return row;
    }


    public int getColumn() {
        return column;
    }


}
