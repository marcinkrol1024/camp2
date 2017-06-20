package sages.bootcamp.names;

import com.google.common.io.Resources;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class NamesApp {
  public static void main(String[] args) throws IOException {
    Properties properties = new Properties();
    properties.load(
        Resources
            .getResource("application.properties")
            .openStream()
    );
    String namesFiles = properties.getProperty("names.files.path");

    NamesReader namesReader = new NamesReader();
    NamesJoiner namesJoiner = new NamesJoiner();

    List<String> names = namesReader.read(namesFiles);
    String joinedNames = namesJoiner.join(names);

    // wypisywanie
    System.out.println(joinedNames);
  }
}
