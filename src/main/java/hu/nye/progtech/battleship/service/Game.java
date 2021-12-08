package hu.nye.progtech.battleship.service;

import hu.nye.progtech.battleship.model.ShipType;
import hu.nye.progtech.battleship.model.ShotStatus;

import java.util.Scanner;
import static java.util.stream.IntStream.range;
import static hu.nye.progtech.battleship.model.ShipType.*;
/**
 * 
 */
public class Game {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ShipType[] SHIPS_SET = new ShipType[]
            {AIRCRAFT_CARRIER, BATTLESHIP, SUBMARINE, CRUISER, DESTROYER};

    private int currentPlayer;
    private final Player[] players;

    public Game() {
        players = new Player[]{
                new Player1("Player1"),
                new Player2("Player2")
        };
        players[0].setSide(players[1]);
        players[1].setSide(players[0]);
        currentPlayer = 0;
    }


    public void start() {
        currentPlayer()
                .placeShips(SHIPS_SET);
        switchPlayer();
        currentPlayer()
                .placeShips(SHIPS_SET);
        startGame();
    }

    private void startGame() {
        System.out.println("The game starts!");
        ShotStatus shotStatus;
        do {
            switchPlayer();
            shotStatus = currentPlayer().makeShot();
            System.out.println(shotStatus);
        } while (shotStatus != ShotStatus.ALL);

        System.out.println(currentPlayer() + " won the battle!");
    }

    private Player currentPlayer() {
        return players[currentPlayer];
    }

    private void switchPlayer() {
        currentPlayer = 1 - currentPlayer;
        System.out.println("Press Enter and pass the move to " + currentPlayer());
        scanner.nextLine();
        clearScreen();
    }

    private void clearScreen() {
        range(0, 5).forEach(i -> System.out.println());
    }

}

