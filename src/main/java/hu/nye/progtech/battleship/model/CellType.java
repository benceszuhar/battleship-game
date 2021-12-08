package hu.nye.progtech.battleship.model;

public enum CellType {
    EMPTY('~'),
    SHIP('O'),
    HIT('+'),
    MISS('x');

    private final char symbol;

    CellType(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

}
