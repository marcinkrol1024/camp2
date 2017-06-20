package sages.bootcamp.names;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NamesReader {

  private final List<String> names;

  public NamesReader(String namesFile) throws IOException {
    this.names = new ArrayList<>();
    // try-with-resources
    try (BufferedReader namesReader = new BufferedReader(new FileReader(namesFile))) {
      // wczytywanie imion
      String name;
      while ((name = namesReader.readLine()) != null) {
        names.add(name);
      }
    }
  }

  public List<String> getNames() {
    return names;
  }
}
