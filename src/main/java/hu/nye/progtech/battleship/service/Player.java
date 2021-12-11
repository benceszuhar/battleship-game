package hu.nye.progtech.battleship.service;


import hu.nye.progtech.battleship.model.MapVO;
import hu.nye.progtech.battleship.model.ShipType;
import hu.nye.progtech.battleship.model.ShotStatus;

/**
 * ShotStatus in game.
 */
public abstract class Player {
    protected final String name;
    protected MapVO mapVO;
    protected Player side;

    protected Player(String name) {
        this.name = name;
    }

    public abstract void placeShips(ShipType[] ships);

    public void setSide(Player side) {
        this.side = side;
    }

    /**
     *getFoggedField.
     */

    public String getFoggedField() {

        return mapVO.getFoggy();

    }

    public abstract ShotStatus makeShot();

    /**
     *shot.
     */

    public ShotStatus shot(int index) {

        return mapVO.shot(index);

    }

    @Override
    public String toString() {

        return name;

    }
}

