package com.github.martynagil.chess.engine;

public class Action {

    private Move move;

    public Action(Move move) {
        this.move = move;
    }

    public static Action move(Move move) {
        return new Action(move);
    }

    public static Action save() {
        return new Action(null);
    }

    public boolean isSave() {
        return move == null;
    }

    public boolean isMove() {
        return move != null;
    }

    public Move getMove() {
        return move;
    }
}
