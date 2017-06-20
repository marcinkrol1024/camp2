package sages.bootcamp.names;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class NamesApp {

  private final static Logger log = LoggerFactory.getLogger(NamesApp.class);

  public static void main(String[] args) throws IOException {
    log.debug("Starting names app");

    NamesReader namesReader = new NamesReader();
    NamesJoiner namesJoiner = new NamesJoiner();
    NamesProperties namesProperties = new NamesPropertiesFactory()
        .createNamesProperties("application.properties");

    List<String> names = namesReader.read(namesProperties.getNamesFile());
    String joinedNames = namesJoiner.join(names, namesProperties.getNamesSeparator());

    // wypisywanie
    System.out.println(joinedNames);

    log.debug("Finishing names app");
  }
}
