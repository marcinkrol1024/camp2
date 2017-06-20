package sages.bootcamp.names;

public class NamesPropertiesBuilder {
  private String namesFile;
  private String namesSeparator;

  public NamesPropertiesBuilder setNamesFile(String namesFile) {
    this.namesFile = namesFile;
    return this;
  }

  public NamesPropertiesBuilder setNamesSeparator(String namesSeparator) {
    this.namesSeparator = namesSeparator;
    return this;
  }

  public NamesProperties createNamesProperties() {
    return new NamesProperties(namesFile, namesSeparator);
  }
}