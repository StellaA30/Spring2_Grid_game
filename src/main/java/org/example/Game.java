package org.example;

public class Game {
    private Grid grid;
    private Player player;
    private int treasuresCollected;
    private int totalTreasures;
    private boolean isGameOver;

    public Game(int rows, int cols) {
        this.grid = new Grid(rows, cols);
        this.player = new Player(rows, cols); // Initialize player with random starting position
        this.treasuresCollected = 0;
        this.totalTreasures = grid.getNumOfTreasures();
        this.isGameOver = false;

    }

    public void displayGame(){

        grid.printGrid();
        displayProximityToTreasure();
    }

    public boolean isGameWon(){
        return treasuresCollected==totalTreasures;
    }

    public void movePlayer(char direction) {
        int newRow = player.getRow();
        int newColumn = player.getColumn();

        switch (direction) {
            case 'U':
                newRow--;
                break;
            case 'D':
                newRow++;
                break;
            case 'L':
                newColumn--;
                break;
            case 'R':
                newColumn++;
                break;
        }


        if (isMoveValid(newRow, newColumn)) {
            char cellValue = grid.getCell(newRow, newColumn);
            if (cellValue == '-') {
                grid.setCell(player.getRow(), player.getColumn(), '-');
                player.move(newRow, newColumn);
                grid.setCell(newRow, newColumn, 'P'); // 'P' represents the player
            } else if (cellValue == 'T') {
                System.out.println("You found a treasure! ");
                grid.setCell(player.getRow(), player.getColumn(), '-');
                treasuresCollected++;
                grid.setCell(newRow, newColumn, 'P');
                grid.setCell(newRow, newColumn, '-'); // Replace the treasure cell with '-'
            }  else if (isMonsterAtPosition(newRow, newColumn)) {
                // Handle encounter with a monster
                handleMonsterEncounter(newRow, newColumn);
            }
        }
    }



    //check if move is valid
    private boolean isMoveValid(int newRow, int newCol){
        if (newRow >= 0 && newRow < grid.getRows() && newCol >= 0 && newCol < grid.getCols()) {
            return true;
        }
        return false;

    }

    private void displayProximityToTreasure() {
        int playerRow = player.getRow();
        int playerColumn = player.getColumn();

        int closestTreasureDistance = Integer.MAX_VALUE;

        for (int row = 0; row < grid.getRows(); row++) {
            for (int col = 0; col < grid.getCols(); col++) {
                if (grid.getCell(row, col) == 'T') {
                    int distance = Math.abs(playerRow - row) + Math.abs(playerColumn - col); // Manhattan distance
                    closestTreasureDistance = Math.min(closestTreasureDistance, distance);
                }
            }
        }

        System.out.println("Distance to the nearest treasure: " + closestTreasureDistance);
    }

    private boolean isMonsterAtPosition(int row, int col) {
        for (Monster monster : grid.getMonsters()) {
            if (grid.getCell(row, col) == monster.getSymbol()) {
                return true;
            }
        }
        return false;
    }

    private void handleMonsterEncounter(int newRow, int newColumn) {
        for (Monster monster : grid.getMonsters()) {
            if (grid.getCell(newRow, newColumn) == monster.getSymbol()) {
                System.out.println(monster.getGreeting());
                System.out.println("Game Over! You encountered " + monster.getName() + ".");
                isGameOver = true;
                break;
            }
        }
    }



    // GETTERS AND SETTERS
    public Player getPlayer() {
        return player;
    }

    public int getTreasuresCollected() {
        return treasuresCollected;
    }

    public void setTreasuresCollected(int treasuresCollected) {
        this.treasuresCollected = treasuresCollected;
    }

    public int getTotalTreasures() {
        return totalTreasures;
    }

    public void setTotalTreasures(int totalTreasures) {
        this.totalTreasures = totalTreasures;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }
}
