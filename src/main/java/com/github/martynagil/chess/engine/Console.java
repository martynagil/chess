package com.github.martynagil.chess.engine;

import java.util.Scanner;
import java.util.function.Predicate;

public class Console {

    private Scanner scanner = new Scanner(System.in);

    public Action askForAction(Predicate<Move> isMovePossible) {
        while (true) {
            try {
                System.out.print("Action: ");
                String action = scanner.nextLine().trim();
                if (action.equalsIgnoreCase("save")) {
                    return Action.save();
                }

                Move move = new Move(action);
                if (isMovePossible.test(move)) {
                    return Action.move(move);
                } else {
                    System.out.println("This move is not possible");
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }

    }

    public boolean askForLoad() {
        System.out.println("Do you want to load the save?");
        return scanner.nextLine().equals("yes");
    }

    public void printWinner(boolean whitePlaying) {
        if (whitePlaying) {
            System.out.println("The winner is BLACK");
        } else {
            System.out.println("The winner is WHITE");
        }
    }

}
