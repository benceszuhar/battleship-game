package hu.nye.progtech.battleship.persistance.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import hu.nye.progtech.battleship.model.MapVO;
import hu.nye.progtech.battleship.persistance.GameSavesRepository;
import hu.nye.progtech.battleship.service.util.MapToStringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * JDBC based implementation of {@link GameSavesRepository}.
 */

public class JdbcGameSavesRepository implements GameSavesRepository, AutoCloseable {

    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcGameSavesRepository.class);

    static final String INSERT_STATEMENT = "INSERT INTO game_saves (id, map, fixed) VALUES (1, ?, ?);";
    static final String DELETE_STATEMENT = "DELETE FROM game_saves WHERE id = 1;";
    static final String SELECT_STATEMENT = "SELECT * FROM game_saves WHERE id = 1;";

    private Connection connection;
    private MapToStringUtil mapToStringUtil;

    public JdbcGameSavesRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(MapVO currentMap) {

    }

    @Override
    public MapVO load() {
        return null;
    }



    @Override
    public void close() throws Exception {
        connection.close();
    }

    private void deleteCurrentlyStoredSave() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(DELETE_STATEMENT);
        }
    }



}