package com.github.martynagil.chess.engine;

import com.github.martynagil.chess.chessmen.*;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

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

    @Test
    void shouldChessmanPlaceProperlyOnBoard() {
        Field fieldFrom = new Field(5, 5);
        Chessman chessman = new KingChessman(Color.WHITE, fieldFrom);
        Board board = new Board(asList(chessman));
        Field fieldTo = new Field(4, 5);
        Move move = new Move(fieldFrom, fieldTo);

        board.move(move);

        assertThat(board.getFieldValue(fieldFrom)).isEqualTo(null);
        assertThat(board.getFieldValue(fieldTo)).isEqualTo(chessman);
    }

    @Test
    void shouldMoveChessmanToOccupiedField() {
        Field fieldFrom = new Field(4, 4);
        Field fieldTo = new Field(4, 5);
        Chessman chessmanBeating = new KingChessman(Color.BLACK, fieldFrom);
        Chessman chessmanBeaten = new RookChessman(Color.WHITE, fieldTo);
        Board board = new Board(asList(chessmanBeating, chessmanBeaten));
        Move beat = new Move(fieldFrom, fieldTo);

        board.move(beat);

        assertThat(board.getFieldValue(fieldFrom)).isEqualTo(null);
        assertThat(board.getFieldValue(fieldTo)).isEqualTo(chessmanBeating);
    }
}

/*
użyć potem sobie
Field fieldFrom = new Field(4, 4);
        Field fieldTo1 = new Field(4, 5);
        Field fieldTo2 = new Field(4, 3);
        Chessman chessmanBeating = new KingChessman(Color.BLACK, fieldFrom);
        Chessman chessmanBeaten1 = new QueenChessman(Color.BLACK, fieldTo1);
        Chessman chessmanBeaten2 = new RookChessman(Color.WHITE, fieldTo2);
        Board board = new Board(asList(chessmanBeating, chessmanBeaten1, chessmanBeaten2));
        Move beat1 = new Move(fieldFrom, fieldTo1);
        Move beat2 = new Move(fieldFrom, fieldTo2);

        board.move(beat1);

 */