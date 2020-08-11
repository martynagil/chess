package com.github.martynagil.chess.engine;

import com.github.martynagil.chess.chessmen.Chessman;
import com.github.martynagil.chess.chessmen.Color;
import com.github.martynagil.chess.chessmen.KingChessman;
import com.github.martynagil.chess.chessmen.QueenChessman;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void shouldPlaceChessmenOnBoard() {
        Field kingPosition = new Field(5, 6);
        Field queenPosition = new Field(4, 1);
        Board board = new Board(asList(
                new KingChessman(Color.BLACK, kingPosition),
                new QueenChessman(Color.WHITE, queenPosition)
        ));

        Chessman chessmanKing = board.getFieldValue(kingPosition);
        assertThat(chessmanKing).isInstanceOf(KingChessman.class);
        assertThat(chessmanKing.getColor()).isEqualTo(Color.BLACK);

        Chessman chessmanQueen = board.getFieldValue(queenPosition);
        assertThat(chessmanQueen).isInstanceOf(QueenChessman.class);
        assertThat(chessmanQueen.getColor()).isEqualTo(Color.WHITE);

    }

}