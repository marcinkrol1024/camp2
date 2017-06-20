package sages.bootcamp.names;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class NamesApp {

  private final static Logger log = LoggerFactory.getLogger(NamesApp.class);

  public static void main(String[] args) {
    log.debug("Starting names app");

    NamesReader namesReader = new NamesReader();
    NamesJoiner namesJoiner = new NamesJoiner();
    NamesProperties namesProperties = null;
    try {
      namesProperties = new NamesPropertiesFactory()
          .createNamesProperties("application.properties");
    } catch (IOException e) {
      log.error("Failed to load properties file.", e);
    }

    List<String> names = null;
    try {
      names = namesReader.read(namesProperties.getNamesFile());
    } catch (IOException e) {
      log.error("Failed to load names file.", e);
    }
    String joinedNames = namesJoiner.join(names, namesProperties.getNamesSeparator());

    // wypisywanie
    System.out.println(joinedNames);

    log.debug("Finishing names app");
  }
}
