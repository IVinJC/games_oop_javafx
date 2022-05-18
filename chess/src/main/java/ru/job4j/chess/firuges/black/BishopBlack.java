package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.OccupiedCellException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not move by diagonal from %s to %s", position, dest)
            );
        }
        int size = Math.abs(position.getX() - dest.getX());
        Cell[] steps = new Cell[size];
        int deltaX = (dest.getX() - position.getX()) / Math.abs(dest.getX() - position.getX());
        int deltaY = (dest.getY() - position.getY()) / Math.abs(dest.getY() - position.getY());
        int x = position().getX() + deltaX;
        int y = position().getY() + deltaY;
        for (int index = 0; index < size; index++) {
            steps[index] = Cell.findBy(x, y);
            x += deltaX;
            y += deltaY;
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) throws ImpossibleMoveException {
        return Math.abs(source.getX() - dest.getY()) == Math.abs(dest.getX() - source.getY());
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
