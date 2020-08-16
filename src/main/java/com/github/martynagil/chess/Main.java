package com.github.martynagil.chess;

import com.github.martynagil.chess.engine.Console;
import com.github.martynagil.chess.engine.Game;
import com.github.martynagil.chess.engine.Part;

public class Main {
    public static void main(String[] args) {
        new Game(new Console(), Part.newPart()).run();
    }
}
