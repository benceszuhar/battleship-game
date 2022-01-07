package hu.nye.progtech.battleship.configuration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import hu.nye.progtech.battleship.model.GameState;
import hu.nye.progtech.battleship.service.command.InputHandler;
import hu.nye.progtech.battleship.service.game.GameController;
import hu.nye.progtech.battleship.service.game.GameStepPerformer;
import hu.nye.progtech.battleship.service.input.UserInputReader;
import hu.nye.progtech.battleship.service.ui.PrintWrapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Spring Java configuration class for generic application related Spring Beans.
 */
@Configuration
public class Applicationconfiguration {

    @Bean(initMethod = "start")
    GameController gameController(GameStepPerformer gameStepPerformer) {
        return new GameController(gameStepPerformer);
    }

    @Bean
    GameStepPerformer gameStepPerformer(UserInputReader userInputReader, InputHandler inputHandler) {
        return new GameStepPerformer(userInputReader, inputHandler);
    }

    @Bean
    UserInputReader userInputReader() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return new UserInputReader(bufferedReader);
    }

    @Bean
    PrintWrapper printWrapper() {
        return new PrintWrapper();
    }
}

