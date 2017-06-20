package sages.bootcamp.names;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NamesReader {

  public List<String> read(String namesFile) throws IOException {
    List<String> names = new ArrayList<>();
    // try-with-resources
    try (BufferedReader namesReader = new BufferedReader(new FileReader(namesFile))) {
      // wczytywanie imion
      String name;
      while ((name = namesReader.readLine()) != null) {
        names.add(name);
      }
    }
    return names;
  }

}
