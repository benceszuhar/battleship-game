package hu.nye.progtech.battleship.configuration;

import java.util.List;

import hu.nye.progtech.battleship.persistance.GameSavesRepository;
import hu.nye.progtech.battleship.service.command.Command;
import hu.nye.progtech.battleship.service.command.InputHandler;
import hu.nye.progtech.battleship.service.command.impl.DefaultCommand;
import hu.nye.progtech.battleship.service.command.impl.LoadCommand;
import hu.nye.progtech.battleship.service.command.impl.SaveCommand;
import hu.nye.progtech.battleship.service.ui.PrintWrapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Spring Java configuration class for command specific Spring Beans.
 */
@Configuration
public class CommandConfiguration {

        @Bean
        InputHandler inputHandler(List<Command> commandList) {
            return new InputHandler(commandList);
        }

        @Bean
        SaveCommand saveCommand(GameSavesRepository gameSavesRepository) {
            return new SaveCommand(gameSavesRepository);
        }

        @Bean
        LoadCommand loadCommand(GameSavesRepository gameSavesRepository) {
            return new LoadCommand(gameSavesRepository);
        }

        @Bean
        DefaultCommand defaultCommand(PrintWrapper printWrapper) {
            return new DefaultCommand(printWrapper);
        }

}
