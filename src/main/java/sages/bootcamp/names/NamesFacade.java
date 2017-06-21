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

  // używa readera do wczytania imion
  // używa joinera do połączenia imion
  // zwraca wartość domyślną, jeśli reader zfailuje
  public String constructJoinedNames() {
    String namesFile = namesProperties.getNamesFile();
    String namesSeparator = namesProperties.getNamesSeparator();

    List<String> names = new ArrayList<>();
    try {
      names = namesReader.read(namesFile);
    } catch (InvalidFileNameException e) {
      log.error("Invalid file name", e);
    } catch (FileNotFoundException e) {
      log.error("File not found", e);
    } catch (IOException e) {
      log.error("Problem when reading", e);
    }
    return namesJoiner.join(names, namesSeparator);
  }
}
