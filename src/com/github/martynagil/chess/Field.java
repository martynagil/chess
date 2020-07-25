package com.github.martynagil.chess;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

public class Field {

    private static final List<String> LETTERS = asList("A", "B", "C", "D", "E", "F", "G", "H");
    private static final List<String> NUMBERS = asList("1", "2", "3", "4", "5", "6", "7", "8");

    private int x;
    private int y;

    public Field(String field) {
        field = field.trim();
        if (field.length() != 2) {
            throw new IllegalArgumentException("Field's length must be 2");
        }

        String letter = field.substring(0, 1).toUpperCase();
        String number = field.substring(1);

        if (!LETTERS.contains(letter) || !NUMBERS.contains(number)) {
            throw new IllegalArgumentException("Field must be in format [letter][number]");
        }

        this.x = LETTERS.indexOf(letter);
        this.y = NUMBERS.indexOf(number);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
