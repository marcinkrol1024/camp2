package sages.bootcamp.names;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class NamesFacade {

  private final static Logger log = LoggerFactory.getLogger(NamesFacade.class);

  private final NamesProperties namesProperties;
  private final NamesJoiner namesJoiner;
  private final NamesReader namesReader;

  public NamesFacade(NamesProperties namesProperties, NamesJoiner namesJoiner, NamesReader namesReader) {
    this.namesProperties = namesProperties;
    this.namesJoiner = namesJoiner;
    this.namesReader = namesReader;
  }

  public String constructJoinedNames() {
    NamesReader namesReader = new NamesReader();
    NamesJoiner namesJoiner = new NamesJoiner();

    List<String> names = null;
    try {
      names = namesReader.read(namesProperties.getNamesFile());
    } catch (IOException e) {
      log.error("Failed to load names file.", e);
    }
    return namesJoiner.join(names, namesProperties.getNamesSeparator());
  }
}
