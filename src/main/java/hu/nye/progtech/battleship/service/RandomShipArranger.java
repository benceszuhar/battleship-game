package hu.nye.progtech.battleship.service;

import static java.util.Arrays.stream;

import java.util.Random;
import java.util.Scanner;

import hu.nye.progtech.battleship.model.Coordinates;
import hu.nye.progtech.battleship.model.MapVO;
import hu.nye.progtech.battleship.model.ShipCoordinates;
import hu.nye.progtech.battleship.model.ShipType;

/**
 * RandomShipArranger.
 */
public class RandomShipArranger implements ShipArranger {
    private static final Random random = new Random();
    private static final Scanner scanner = new Scanner(System.in);
    private MapVO mapVO;

    @Override
    public MapVO placeShips(ShipType[] ships) {
        mapVO = new MapVO();
        stream(ships).forEach(this::placeShip);
        return mapVO;
    }

    private void placeShip(ShipType shipType) {
        MapVO.Ship ship;
        do {
            final var isHorizontal = random.nextBoolean();
            final var row = random.nextInt(hu.nye.progtech.battleship.model.MapVO.HEIGHT - (isHorizontal ? 0 : shipType.length() - 1));
            final var col = random.nextInt(hu.nye.progtech.battleship.model.MapVO.WIDTH - (isHorizontal ? shipType.length() - 1 : 0));
            final var bow = new Coordinates(row, col);
            ship = mapVO.new Ship(shipType, bow.getIndexes(isHorizontal));
        } while (!ship.isFit());
        mapVO.addShip(ship);
    }

    private ShipCoordinates getShipCoordinates() {
        while (true) {
            final var input = scanner.nextLine().toUpperCase();
            final var coordinates = ShipCoordinates.of(input);
            if (coordinates.isPresent()) {
                return coordinates.get();
            }
            System.out.println("Error! Wrong ship location! Try again:");
        }
    }
}

