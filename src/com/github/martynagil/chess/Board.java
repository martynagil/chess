package com.github.martynagil.chess;

public class Board {

    private Chessman[][] board = new Chessman[8][8];

    public Board() {
        board[0][0] = Chessman.BLACK_ROOK;
        board[1][0] = Chessman.BLACK_KNIGHT;
        board[2][0] = Chessman.BLACK_BISHOP;
        board[3][0] = Chessman.BLACK_QUEEN;
        board[4][0] = Chessman.BLACK_KING;
        board[5][0] = Chessman.BLACK_BISHOP;
        board[6][0] = Chessman.BLACK_KNIGHT;
        board[7][0] = Chessman.BLACK_ROOK;
        board[0][1] = Chessman.BLACK_PAWN;
        board[1][1] = Chessman.BLACK_PAWN;
        board[2][1] = Chessman.BLACK_PAWN;
        board[3][1] = Chessman.BLACK_PAWN;
        board[4][1] = Chessman.BLACK_PAWN;
        board[5][1] = Chessman.BLACK_PAWN;
        board[6][1] = Chessman.BLACK_PAWN;
        board[7][1] = Chessman.BLACK_PAWN;

        board[0][7] = Chessman.WHITE_ROOK;
        board[1][7] = Chessman.WHITE_KNIGHT;
        board[2][7] = Chessman.WHITE_BISHOP;
        board[3][7] = Chessman.WHITE_QUEEN;
        board[4][7] = Chessman.WHITE_KING;
        board[5][7] = Chessman.WHITE_BISHOP;
        board[6][7] = Chessman.WHITE_KNIGHT;
        board[7][7] = Chessman.WHITE_ROOK;
        board[0][6] = Chessman.WHITE_PAWN;
        board[1][6] = Chessman.WHITE_PAWN;
        board[2][6] = Chessman.WHITE_PAWN;
        board[3][6] = Chessman.WHITE_PAWN;
        board[4][6] = Chessman.WHITE_PAWN;
        board[5][6] = Chessman.WHITE_PAWN;
        board[6][6] = Chessman.WHITE_PAWN;
        board[7][6] = Chessman.WHITE_PAWN;
    }
}
