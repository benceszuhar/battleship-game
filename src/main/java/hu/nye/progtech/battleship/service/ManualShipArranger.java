package hu.nye.progtech.battleship.service;

import static java.util.Arrays.stream;

import java.util.Scanner;

import hu.nye.progtech.battleship.model.MapVO;
import hu.nye.progtech.battleship.model.ShipCoordinates;
import hu.nye.progtech.battleship.model.ShipType;

/**
 * Manual ship arranger.
 */
public class ManualShipArranger implements ShipArranger {

    private static final Scanner scanner = new Scanner(System.in);

    private MapVO mapVO;

    @Override
    public MapVO placeShips(ShipType[] ships) {
        mapVO = new MapVO();
        stream(ships).forEach(this::placeShip);
        System.out.println(mapVO);
        return mapVO;
    }

    private void placeShip(ShipType shipType) {
        System.out.println(mapVO);
        while (true) {
            System.out.println("Enter the coordinates of the " + shipType + " (" + shipType.length() + " cells):");

            final var shipCoordinates = getShipCoordinates();

            if (shipCoordinates.length() != shipType.length()) {
                System.out.println("Error! Wrong length of the " + shipType + "! Try again:");
                continue;
            }

            final var ship = mapVO.new Ship(shipType, shipCoordinates.getIndexes());

            if (ship.isFit()) {
                mapVO.addShip(ship);
                return;
            }
            System.out.println("Error! You placed it too close to another one. Try again:");
        }
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
