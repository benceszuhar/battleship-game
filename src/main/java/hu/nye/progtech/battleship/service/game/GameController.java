package hu.nye.progtech.battleship.service.game;

import static hu.nye.progtech.battleship.model.ShipType.AIRCRAFT_CARRIER;
import static hu.nye.progtech.battleship.model.ShipType.BATTLESHIP;
import static hu.nye.progtech.battleship.model.ShipType.CRUISER;
import static hu.nye.progtech.battleship.model.ShipType.DESTROYER;
import static hu.nye.progtech.battleship.model.ShipType.SUBMARINE;
import static java.util.stream.IntStream.range;

import java.util.Scanner;

import hu.nye.progtech.battleship.model.ShipType;
import hu.nye.progtech.battleship.model.ShotStatus;
import hu.nye.progtech.battleship.service.AiPlayer;
import hu.nye.progtech.battleship.service.HumanPlayer;
import hu.nye.progtech.battleship.service.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Component that controls the flow of a game.
 */
public class GameController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GameController.class);

    private static final Scanner scanner = new Scanner(System.in);
    private static final ShipType[] SHIPS_SET = new ShipType[]
            {AIRCRAFT_CARRIER, BATTLESHIP, SUBMARINE, CRUISER, DESTROYER};

    private int currentPlayer;
    private final Player [] players;
    private final GameStepPerformer gameStepPerformer;

    public GameController(GameStepPerformer gameStepPerformer) {
        this.gameStepPerformer = gameStepPerformer;

        players = new Player[]{
                new HumanPlayer("Player1"),
                new AiPlayer("Player2")
        };
        players[0].setSide(players[1]);
        players[1].setSide(players[0]);
        currentPlayer = 0;
    }

    /**
     * start order.
     */

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
        gameStepPerformer.performGameStep();
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



