import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
        new AnnotationConfigApplicationContext("hu.nye.progtech.battleship");

    }
}
