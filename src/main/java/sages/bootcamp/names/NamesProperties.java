package sages.bootcamp.names;

// mówimy, że to jest POJO, bo ma tylko pola i gettery/settery
// co więcej jest immutable
public class NamesProperties {

  private final String namesFile;
  private final String namesSeparator;

  public NamesProperties(String namesFile, String namesSeparator) {
    this.namesFile = namesFile;
    this.namesSeparator = namesSeparator;
  }

  public String getNamesSeparator() {
    return namesSeparator;
  }

  public String getNamesFile() {
    return namesFile;
  }
}
