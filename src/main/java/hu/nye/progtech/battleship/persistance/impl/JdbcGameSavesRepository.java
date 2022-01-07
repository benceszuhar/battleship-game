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

    static final String INSERT_STATEMENT = "";
    static final String DELETE_STATEMENT = "";
    static final String SELECT_STATEMENT = "";

    private final Connection connection;

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