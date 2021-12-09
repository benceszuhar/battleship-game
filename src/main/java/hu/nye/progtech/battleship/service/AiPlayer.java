package hu.nye.progtech.battleship.service;


import hu.nye.progtech.battleship.model.ShipType;

public class AiPlayer extends HumanPlayer {

    public AiPlayer(String name) {
        super(name);
    }

    @Override
    public void placeShips(ShipType[] ships) {
        MapVO = new RandomShipArranger().placeShips(ships);
    }

}

