package hu.nye.progtech.battleship.service.command.impl;

import hu.nye.progtech.battleship.persistance.GameSavesRepository;
import hu.nye.progtech.battleship.service.command.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Command used to save the current game state.
 */
public class SaveCommand implements Command {

    private static final Logger LOGGER = LoggerFactory.getLogger(SaveCommand.class);
    private static final String SAVE_COMMAND = "save";

    private final GameSavesRepository gameSavesRepository;

    public SaveCommand(GameSavesRepository gameSavesRepository) {
        this.gameSavesRepository = gameSavesRepository;
    }

    @Override
    public boolean canProcess(String input) {
        return SAVE_COMMAND.equals(input);
    }

    @Override
    public void process(String input) {

    }


}

