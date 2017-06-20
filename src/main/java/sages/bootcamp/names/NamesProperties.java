package sages.bootcamp.names;

import java.io.IOException;

// mówimy, że to jest POJO, bo ma tylko pola i gettery/settery
// co więcej jest immutable
public class NamesProperties {

  private final String namesFile;

  public NamesProperties(String namesFile) throws IOException {
    this.namesFile = namesFile;
  }

  public String getNamesFile() {
    return namesFile;
  }
}
