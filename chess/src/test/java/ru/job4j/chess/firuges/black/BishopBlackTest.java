package ru.job4j.chess.firuges.black;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void whenPositionEqualsPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.B1);
        Assert.assertEquals(bishopBlack.position(), Cell.B1);
    }

    @Test
    public void copy() {
        Figure bishopBlack = new BishopBlack(Cell.A4);
        Figure bishopBlack2 = new BishopBlack(Cell.G7);
        assertEquals(bishopBlack2.position(), bishopBlack.copy(Cell.G7).position());
    }

    @Test
    public void way() {
        Figure bishopBlack = new BishopBlack(Cell.C1);
        Cell[] cellsExpected = bishopBlack.way(Cell.G5);
        assertEquals(cellsExpected, new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5});
    }

    @Test
    public void isDiagonal() {
        assertTrue(new BishopBlack(Cell.C1).isDiagonal(Cell.C1, Cell.H6));
    }
}