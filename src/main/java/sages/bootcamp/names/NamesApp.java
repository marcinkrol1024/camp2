package sages.bootcamp.names;

import java.io.IOException;
import java.util.List;

public class NamesApp {
  public static void main(String[] args) throws IOException {
    NamesReader namesReader = new NamesReader("names");
    NamesJoiner namesJoiner = new NamesJoiner();

    List<String> names = namesReader.getNames();
    String joinedNames = namesJoiner.join(names);

    // wypisywanie
    System.out.println(joinedNames);
  }
}
