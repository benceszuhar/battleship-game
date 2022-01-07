package hu.nye.progtech.battleship.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import hu.nye.progtech.battleship.persistance.GameSavesRepository;
import hu.nye.progtech.battleship.persistance.impl.JdbcGameSavesRepository;
import hu.nye.progtech.battleship.persistance.impl.XmlGameSavesRepository;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Spring Java configuration class for persistence layer specific Spring Beans.
 */

@Configuration
public class RepositoryConfiguration {

    @Bean
    Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:tcp://localhost/./progtech", "Demoo", "password");
    }

    @Bean(destroyMethod = "close")
    GameSavesRepository jdbcGameSavesRepository(Connection connection) {
        return new JdbcGameSavesRepository(connection);
    }

    @Bean
    @Primary
    GameSavesRepository xmlGameSavesRepository(Marshaller marshaller, Unmarshaller unmarshaller) {
        return new XmlGameSavesRepository(marshaller, unmarshaller);
    }
}
