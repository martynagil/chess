package com.github.martynagil.chess;

import java.util.Scanner;

public class Game {

    private Board board = new Board();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        do {
            String move = askForMovement();
            String[] split = move.split(" ");


        } while (!isFinished());
    }

    private String askForMovement() {
        System.out.print("Move: ");
        return scanner.nextLine();
    }

    private boolean isFinished() {
        return true;
    }
}
