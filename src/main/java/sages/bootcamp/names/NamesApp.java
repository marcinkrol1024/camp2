package sages.bootcamp.names;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NamesApp {
  public static void main(String[] args) throws IOException {
    // try-with-resources
    try (BufferedReader namesReader = new BufferedReader(new FileReader("names"))) {

      // wczytywanie imion
      List<String> names = new ArrayList<>();
      String name;
      while ((name = namesReader.readLine()) != null) {
        names.add(name);
      }

      // budowanie stringa z imion
      StringBuilder namesBuilder = new StringBuilder();
      if (names.size() > 1) {
        namesBuilder.append(names.get(0));
        for (int i = 1; i < names.size(); i++) {
          namesBuilder.append(", ").append(names.get(i));
        }
      }

      // wypisywanie
      System.out.println(namesBuilder.toString());
    }
  }
}
