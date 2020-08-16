package com.github.martynagil.chess.engine;

import com.github.martynagil.chess.chessmen.*;
import com.sun.deploy.net.MessageHeader;

import java.util.ArrayList;
import java.util.List;

public class ChessmanFactory {

    public static List<Chessman> defaultSetup() {
        List<Chessman> chessmen = new ArrayList<>();
        chessmen.add(new RookChessman(Color.BLACK, new Field(0, 0)));
        chessmen.add(new KnightChessman(Color.BLACK, new Field(1, 0)));
        chessmen.add(new BishopChessman(Color.BLACK, new Field(2, 0)));
        chessmen.add(new QueenChessman(Color.BLACK, new Field(3, 0)));
        chessmen.add(new KingChessman(Color.BLACK, new Field(4, 0)));
        chessmen.add(new BishopChessman(Color.BLACK, new Field(5, 0)));
        chessmen.add(new KnightChessman(Color.BLACK, new Field(6, 0)));
        chessmen.add(new RookChessman(Color.BLACK, new Field(7, 0)));
        chessmen.add(new PawnChessman(Color.BLACK, new Field(0, 1)));
        chessmen.add(new PawnChessman(Color.BLACK, new Field(1, 1)));
        chessmen.add(new PawnChessman(Color.BLACK, new Field(2, 1)));
        chessmen.add(new PawnChessman(Color.BLACK, new Field(3, 1)));
        chessmen.add(new PawnChessman(Color.BLACK, new Field(4, 1)));
        chessmen.add(new PawnChessman(Color.BLACK, new Field(5, 1)));
        chessmen.add(new PawnChessman(Color.BLACK, new Field(6, 1)));
        chessmen.add(new PawnChessman(Color.BLACK, new Field(7, 1)));
        chessmen.add(new RookChessman(Color.WHITE, new Field(0, 7)));
        chessmen.add(new KnightChessman(Color.WHITE, new Field(1, 7)));
        chessmen.add(new BishopChessman(Color.WHITE, new Field(2, 7)));
        chessmen.add(new QueenChessman(Color.WHITE, new Field(3, 7)));
        chessmen.add(new KingChessman(Color.WHITE, new Field(4, 7)));
        chessmen.add(new BishopChessman(Color.WHITE, new Field(5, 7)));
        chessmen.add(new KnightChessman(Color.WHITE, new Field(6, 7)));
        chessmen.add(new RookChessman(Color.WHITE, new Field(7, 7)));
        chessmen.add(new PawnChessman(Color.WHITE, new Field(0, 6)));
        chessmen.add(new PawnChessman(Color.WHITE, new Field(1, 6)));
        chessmen.add(new PawnChessman(Color.WHITE, new Field(2, 6)));
        chessmen.add(new PawnChessman(Color.WHITE, new Field(3, 6)));
        chessmen.add(new PawnChessman(Color.WHITE, new Field(4, 6)));
        chessmen.add(new PawnChessman(Color.WHITE, new Field(5, 6)));
        chessmen.add(new PawnChessman(Color.WHITE, new Field(6, 6)));
        chessmen.add(new PawnChessman(Color.WHITE, new Field(7, 6)));
        return chessmen;
    }
}
