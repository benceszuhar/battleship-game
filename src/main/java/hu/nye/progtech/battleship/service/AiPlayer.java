package hu.nye.progtech.battleship.service;

import hu.nye.progtech.battleship.model.ShipType;

/**
 * ShotStatus in game.
 */
public class AiPlayer extends HumanPlayer {

    public AiPlayer(String name) {
        super(name);
    }

    @Override
    public void placeShips(ShipType[] ships) {
        mapVO = new ManualShipArranger().placeShips(ships);
    }

}

