package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();

        System.out.print("Enter the number of columns: ");
        int cols = scanner.nextInt();

        Game game = new Game(rows, cols);

        scanner.nextLine();


        while (!game.isGameWon() && !game.isGameOver()) {
            game.displayGame();
            System.out.print("Enter a direction (U/D/L/R): ");
            String input = scanner.next();
            char direction = input.charAt(0);
            game.movePlayer(direction);
        }

        if (game.isGameWon()) {
            System.out.println("Congratulations! You found all the treasures and won the game.");
        }


        scanner.close();
    }
}