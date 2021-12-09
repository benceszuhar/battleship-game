package hu.nye.progtech.battleship.service;

import hu.nye.progtech.battleship.model.Coordinates;
import hu.nye.progtech.battleship.model.MapVO;
import hu.nye.progtech.battleship.model.ShipType;

import java.util.Random;
import static java.util.Arrays.stream;

    public class RandomShipArranger implements ShipArranger {
        private static final Random random = new Random();
        private MapVO MapVO;

        @Override
        public MapVO placeShips(ShipType[] ships) {
            MapVO = new MapVO();
            stream(ships).forEach(this::placeShip);
            return MapVO;
        }

        private void placeShip(ShipType shipType) {
            MapVO.Ship ship;
            do {
                final var isHorizontal = random.nextBoolean();
                final var row = random.nextInt(hu.nye.progtech.battleship.model.MapVO.HEIGHT - (isHorizontal ? 0 : shipType.length() - 1));
                final var col = random.nextInt(hu.nye.progtech.battleship.model.MapVO.WIDTH - (isHorizontal ? shipType.length() - 1 : 0));
                final var bow = new Coordinates(row, col);
                ship = MapVO.new Ship(shipType, bow.getIndexes(isHorizontal));
            } while (!ship.isFit());
            MapVO.addShip(ship);
        }
}

