package hu.nye.progtech.battleship.service;

import hu.nye.progtech.battleship.model.Coordinates;
import hu.nye.progtech.battleship.model.ShipType;
import hu.nye.progtech.battleship.model.ShotStatus;

import java.util.Scanner;

public class Player2 extends Player {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ManualShipArranger SHIP_ARRANGER = new ManualShipArranger();
    public Player2(String name) {
        super(name);
    }

        @Override
        public void placeShips(ShipType[] ships) {
            System.out.println(name + ", place your ships on the game field");
            MapVO = SHIP_ARRANGER.placeShips(ships);
        }

    @Override
    public ShotStatus makeShot() {
        System.out.println(side.getFoggedField());
        System.out.println("---------------------");
        System.out.println(MapVO);
        System.out.println(name + ", it's your turn:");
        return side.shot(getCoordinates().getIndex());
    }
    private Coordinates getCoordinates() {
        while (true) {
            final var input = scanner.nextLine().toUpperCase();
            if (Coordinates.isValid(input)) {
                return new Coordinates(input);
            }
            System.out.println("Error! You entered the wrong coordinates! Try again:");
        }
    }
    }

