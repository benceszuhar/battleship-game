package hu.nye.progtech.battleship.persistance.xml;

import java.util.List;
import java.util.Map;
import java.util.function.IntPredicate;

import hu.nye.progtech.battleship.model.CellType;
import hu.nye.progtech.battleship.model.MapVO;

/**
 * Gamemap copy for xml save.
 */
public class PersistableMapVO {

    public static int WIDTH = 10;
    public static int HEIGHT = 10;
    private static Map<IntPredicate, Integer> CHECK_CELLS = Map.of(
            i -> true, 0,
            i -> i / WIDTH > 0 && i % WIDTH > 0, -WIDTH - 1,
            i -> i / WIDTH > 0, -WIDTH,
            i -> i / WIDTH > 0 && i % WIDTH < WIDTH - 1, -WIDTH + 1,
            i -> i % WIDTH > 0, -1,
            i -> i % WIDTH < WIDTH - 1, 1,
            i -> i / WIDTH < WIDTH - 1 && i % WIDTH > 0, WIDTH - 1,
            i -> i / WIDTH < WIDTH - 1, WIDTH,
            i -> i / WIDTH < WIDTH - 1 && i % WIDTH < WIDTH - 1, WIDTH + 1);

    private CellType[] field;
    private List<MapVO.Ship> ships;


    public PersistableMapVO() {
        this.field = field;
        this.ships = ships;
    }
}
