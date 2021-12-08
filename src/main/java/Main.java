import hu.nye.progtech.battleship.service.Game;

/**
 * Entry point of the Battleship game.
 */
public class Main {
    /**
     * Entrypoint of the game.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {

        Game game = new Game();
        game.start();

    }
}
