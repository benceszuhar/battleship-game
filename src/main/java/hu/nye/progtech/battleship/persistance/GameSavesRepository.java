package hu.nye.progtech.battleship.persistance;


import hu.nye.progtech.battleship.model.MapVO;

/**
 * Interface for storing and retrieving current Sudoku game states.
 */
public interface GameSavesRepository {

    void save(MapVO currentMap);

    MapVO load();

}

