package hu.nye.progtech.battleship.model;

import static java.util.Arrays.fill;
import static java.util.stream.IntStream.range;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;



/**
 * Gamemap implementation.
 */
public class MapVO {
        public static final int WIDTH = 10;
        public static final int HEIGHT = 10;
        private static final Map<IntPredicate, Integer> CHECK_CELLS = Map.of(
                i -> true, 0,
                i -> i / WIDTH > 0 && i % WIDTH > 0, -WIDTH - 1,
                i -> i / WIDTH > 0, -WIDTH,
                i -> i / WIDTH > 0 && i % WIDTH < WIDTH - 1, -WIDTH + 1,
                i -> i % WIDTH > 0, -1,
                i -> i % WIDTH < WIDTH - 1, 1,
                i -> i / WIDTH < WIDTH - 1 && i % WIDTH > 0, WIDTH - 1,
                i -> i / WIDTH < WIDTH - 1, WIDTH,
                i -> i / WIDTH < WIDTH - 1 && i % WIDTH < WIDTH - 1, WIDTH + 1);



        private final CellType[] field;
        private final List<Ship> ships;

        public MapVO() {
            field = new CellType[WIDTH * HEIGHT];
            fill(field, CellType.EMPTY);
            ships = new ArrayList<>();
        }

    public void addShip(Ship ship) {
            ship.getIndexes().forEach(i -> field[i] = CellType.SHIP);
            ships.add(ship);
        }

        private boolean isShipCanPlaced(int index) {
            return CHECK_CELLS.entrySet().stream()
                    .filter(e -> e.getKey().test(index))
                    .allMatch(e -> field[index + e.getValue()] == CellType.EMPTY);
        }

        /**
        * ShotStatus.
        */
        public ShotStatus shot(int index) {
            final var isMiss = field[index] == CellType.EMPTY || field[index] == CellType.MISS;
            field[index] = isMiss ? CellType.MISS : CellType.HIT;
            if (isMiss) {
                return ShotStatus.MISS;
            }
            if (getShip(index).orElseThrow().isSank()) {
                return isAllSank() ? ShotStatus.ALL : ShotStatus.SUNK;
            }
            return ShotStatus.HIT;
        }

        public Optional<Ship> getShip(int index) {
            return ships.stream().filter(ship -> ship.getIndexes().anyMatch(i -> i == index)).findAny();
        }

        public boolean isAllSank() {
            return ships.stream().allMatch(Ship::isSank);
        }

        @Override
        public String toString() {
            return getField(false);
        }

        public String getFoggy() {
            return getField(true);
        }


    private String getField(boolean isFog) {
            return "  1 2 3 4 5 6 7 8 9 10" + range(0, field.length)
                    .mapToObj(i -> String.format(i % 10 > 0 ? " %2$c" : "%n%c %c", 'A' + i / 10,
                            isFog && field[i] == CellType.SHIP ? CellType.EMPTY.getSymbol() : field[i].getSymbol()))
                    .collect(Collectors.joining());
        }

    /**
     * Ship gets fit,index,sank.
     */

    public class Ship {
            private final ShipType type;
            private final IntUnaryOperator getIndex;

            public Ship(ShipType type, IntUnaryOperator getIndex) {
                this.type = type;
                this.getIndex = getIndex;
            }

            public boolean isFit() {
                return getIndexes().allMatch(MapVO.this::isShipCanPlaced);
            }

            public IntStream getIndexes() {
                return range(0, type.length()).map(getIndex);
            }

            public boolean isSank() {
                return getIndexes().allMatch(i -> field[i] == CellType.HIT);
            }
        }

}
