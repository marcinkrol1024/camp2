package sages.bootcamp.names;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class NamesApp {

  private final static Logger log = LoggerFactory.getLogger(NamesApp.class);

  public static void main(String[] args) {
    log.debug("Starting names app");

    NamesProperties namesProperties = null;
    try {
      namesProperties = new NamesPropertiesFactory()
          .createNamesProperties("application.properties");
    } catch (IOException e) {
      log.error("Failed to load properties file.", e);
    }

    NamesFacade namesFacade = new NamesFacade(
        namesProperties,
        new NamesJoiner(),
        new NamesReader()
    );

    // wypisywanie
    System.out.println(namesFacade.constructJoinedNames());

    log.debug("Finishing names app");
  }
}
