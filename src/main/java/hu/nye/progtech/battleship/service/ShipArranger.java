package hu.nye.progtech.battleship.service;

import hu.nye.progtech.battleship.model.MapVO;
import hu.nye.progtech.battleship.model.ShipType;

/**
 * ShipArranger interface.
 */
@FunctionalInterface
public interface ShipArranger {
    MapVO placeShips(ShipType[] ships);
}

