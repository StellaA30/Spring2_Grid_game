package org.example;

public class Monster {
    private char symbol;
    private String greeting;
    private String name;

    public Monster(char symbol, String greeting, String name) {
        this.symbol = symbol;
        this.greeting = greeting;
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
