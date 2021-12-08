package hu.nye.progtech.battleship.service;


import hu.nye.progtech.battleship.model.MapVO;
import hu.nye.progtech.battleship.model.ShipType;
import hu.nye.progtech.battleship.model.ShotStatus;

public abstract class Player {
    protected final String name;
    protected MapVO MapVO;
    protected Player side;

    protected Player(String name) {
        this.name = name;
    }

    public abstract void placeShips(ShipType[] ships);

    public void setSide(Player side) {
        this.side = side;
    }

    public String getFoggedField() {

        return MapVO.getFoggy();

    }

    public abstract ShotStatus makeShot();

    public ShotStatus shot(int index) {

        return MapVO.shot(index);

    }

    @Override
    public String toString() {

        return name;

    }
}

