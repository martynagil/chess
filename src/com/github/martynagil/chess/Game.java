package com.github.martynagil.chess;

import java.util.Scanner;

public class Game {

    private Board board = new Board();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        do {
            board.print();
            Movement move = askForMovement();

        } while (!isFinished());
    }

    private Movement askForMovement() {
        System.out.print("Move: ");
        String movement = scanner.nextLine();
        return new Movement(movement);
    }

    private boolean isFinished() {
        return true;
    }
}
