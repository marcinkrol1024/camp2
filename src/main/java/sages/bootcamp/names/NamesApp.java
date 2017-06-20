package sages.bootcamp.names;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class NamesApp {
  public static void main(String[] args) throws IOException {
    // try-with-resources
    try (BufferedReader namesReader = new BufferedReader(new FileReader("names"))) {
      String line;
      while ((line = namesReader.readLine()) != null) {
        System.out.println(line);
      }
    }
  }
}
