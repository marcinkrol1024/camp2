package sages.bootcamp.names;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NamesApp {
  public static void main(String[] args) throws IOException {
    // try-with-resources
    try (BufferedReader namesReader = new BufferedReader(new FileReader("names"))) {
      String name;
      StringBuilder namesBuilder = new StringBuilder();
      if ((name = namesReader.readLine()) != null) {
        namesBuilder.append(name);
      }
      while ((name = namesReader.readLine()) != null) {
        namesBuilder.append(", ").append(name);
      }
      System.out.println(namesBuilder.toString());
    }
  }
}
