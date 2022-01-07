package hu.nye.progtech.battleship.persistance.impl;

import java.io.File;

import hu.nye.progtech.battleship.model.MapVO;
import hu.nye.progtech.battleship.persistance.GameSavesRepository;
import hu.nye.progtech.battleship.persistance.xml.PersistableMapVO;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * XML based implementation of {@link GameSavesRepository}.
 */
public class XmlGameSavesRepository implements GameSavesRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(XmlGameSavesRepository.class);

    private final Marshaller marshaller;
    private final Unmarshaller unmarshaller;

    public XmlGameSavesRepository(Marshaller marshaller, Unmarshaller unmarshaller) {
        this.marshaller = marshaller;
        this.unmarshaller = unmarshaller;
    }

    @Override
    public void save(MapVO currentMap) {
        try {
            PersistableMapVO persistableMapVO =
                    new PersistableMapVO();

            marshaller.marshal(persistableMapVO, new File("state.xml"));
        } catch (JAXBException e) {
            LOGGER.error("Error during saving state to XML", e);
            throw new RuntimeException("Failed to save XML", e);
        }
    }

    @Override
    public MapVO load() {
        try {
            PersistableMapVO persistableMapVO = (PersistableMapVO) unmarshaller.unmarshal(new File("state.xml"));

            return new MapVO();
        } catch (JAXBException e) {
            LOGGER.error("Error during loading state to XML", e);
            throw new RuntimeException("Failed to load XML", e);
        }
    }
}
