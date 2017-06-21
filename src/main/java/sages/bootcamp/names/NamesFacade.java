package sages.bootcamp.names;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
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
    List<String> names = new ArrayList<>();
    try {
      names = namesReader.read(namesProperties.getNamesFile());
    } catch (InvalidFileNameException e) {
      log.error("Invalid file name", e);
    } catch (FileNotFoundException e) {
      log.error("File not found", e);
    } catch (IOException e) {
      log.error("Problem when reading", e);
    }
    return namesJoiner.join(names, namesProperties.getNamesSeparator());
  }
}
