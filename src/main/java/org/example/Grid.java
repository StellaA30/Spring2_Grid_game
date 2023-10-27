package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Grid {
    private char[][] grid;
    private int rows;
    private int cols;
    private int numOfTreasures;
    private static final char TREASURE_SYMBOL = 'T';
    private List<Monster> monsters = new ArrayList<>();


    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new char[rows][cols];
        this.numOfTreasures = (rows*cols)/8; // making the number of treasures 1/8 of the total cells
        initializeGrid();
        placeTreasuresOnGrid();

        Monster monster1 = new Monster('V', "Venom says pssst....", "venom");
        Monster monster2 = new Monster('N', "Dragon says says hi!", "dragon");
        Monster monster3 = new Monster('D', "Gotcha", "red demon");
        monsters.add(monster1);
        monsters.add(monster2);
        monsters.add(monster3);

        placeMonstersOnGrid();
    }

    // getter and setters
    public int getNumOfTreasures() {
        return numOfTreasures;
    }

    public void setNumOfTreasures(int numOfTreasures) {
        this.numOfTreasures = numOfTreasures;
    }


    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
    }

    private void initializeGrid() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = '-';
        }
    }
    }

    public void printGrid() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }


    private void placeTreasuresOnGrid(){
        Random random = new Random();
        for (int i = 0; i < numOfTreasures; i++) {
            while (true){
                int treasureRow = random.nextInt(rows);
                int treasureCol = random.nextInt(cols);
                if (this.getCell(treasureRow, treasureCol) != TREASURE_SYMBOL) {
                    this.setCell(treasureRow, treasureCol, TREASURE_SYMBOL);
                    break; // Exit the loop once a valid treasure placement is made
                }
            }
        }
    }

    // return character a specified cell
    public char getCell(int row, int col) {
        return grid[row][col];
    }

    // set the state of a specific cell in the grid, e.g., adding 'P' for player to place player at a specific location on the grid
    public void setCell(int row, int col, char value) {
        grid[row][col] = value;
    }

    private void placeMonstersOnGrid() {
        Random random = new Random();
        for (Monster monster : monsters) {
            while (true) {
                int monsterRow = random.nextInt(rows);
                int monsterCol = random.nextInt(cols);
                if (this.getCell(monsterRow, monsterCol) != TREASURE_SYMBOL && !hasMonsterAtCell(monsterRow, monsterCol)) {
                    this.setCell(monsterRow, monsterCol, monster.getSymbol());
                    break;
                }
            }
        }
    }

    private boolean hasMonsterAtCell(int row, int col) {
        for (Monster monster : monsters) {
            if (getCell(row, col) == monster.getSymbol()) {
                return true;
            }
        }
        return false;
    }





}
