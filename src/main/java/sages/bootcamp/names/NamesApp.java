package sages.bootcamp.names;

import java.io.IOException;
import java.util.List;

public class NamesApp {
  public static void main(String[] args) throws IOException {

    NamesReader namesReader = new NamesReader();
    NamesJoiner namesJoiner = new NamesJoiner();
    NamesProperties namesProperties = new NamesPropertiesFactory()
        .createNamesProperties("application.properties");

    List<String> names = namesReader.read(namesProperties.getNamesFile());
    String joinedNames = namesJoiner.join(names);

    // wypisywanie
    System.out.println(joinedNames);
  }
}
