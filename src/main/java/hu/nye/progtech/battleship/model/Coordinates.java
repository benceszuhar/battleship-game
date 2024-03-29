package hu.nye.progtech.battleship.model;

import static java.text.MessageFormat.format;

import java.util.function.IntUnaryOperator;
import java.util.regex.Pattern;


/**
 * Coordinates.
 */
public class Coordinates {
    private static final String ROW_PATTERN = format("[A-{0}]", (char) ('A' + MapVO.HEIGHT - 1));
    private static final String COL_PATTERN = "[1-9]|10";
    private static final Pattern PATTERN_COORDINATE =
            Pattern.compile(format("({0})({1})", ROW_PATTERN, COL_PATTERN));

    private final int row;
    private final int col;

    public Coordinates(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Coordinates(String coordinates) {
        row = coordinates.charAt(0) - 'A';
        col = Integer.parseInt(coordinates.substring(1)) - 1;
    }

    public int getRow() {

        return row;
    }

    public int getCol() {

        return col;
    }

    public int getIndex() {

        return MapVO.WIDTH * row + col;
    }


    public IntUnaryOperator getIndexes(boolean isHorizontal) {
        return i -> isHorizontal ? getIndex() + i : getIndex() + MapVO.WIDTH * i;
    }

    public static boolean isValid(String coordinates) {
        return PATTERN_COORDINATE.matcher(coordinates).matches();
    }
}

