package hu.nye.progtech.battleship.service.command.impl;

import hu.nye.progtech.battleship.persistance.GameSavesRepository;
import hu.nye.progtech.battleship.service.command.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Command used to load a previously saved game state.
 */
public class LoadCommand implements Command {

    private static final String LOAD_COMMAND = "load";

    private GameSavesRepository gameSavesRepository;

    public LoadCommand(GameSavesRepository gameSavesRepository) {
        this.gameSavesRepository = gameSavesRepository;
    }

    @Override
    public boolean canProcess(String input) {
        return LOAD_COMMAND.equals(input);
    }

    @Override
    public void process(String input) {

    }


}

