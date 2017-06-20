package sages.bootcamp.names;

import com.google.common.io.Resources;

import java.io.IOException;
import java.util.Properties;

public class NamesPropertiesFactory {
  NamesProperties createNamesProperties(String propertiesFile) throws IOException {
    Properties properties;
    properties = new Properties();
    properties.load(
        Resources
            .getResource(propertiesFile)
            .openStream()
    );
    String namesFile = properties.getProperty("names.files.path");
    String namesSeparator = properties.getProperty("names.separator");
    return new NamesPropertiesBuilder()
        .setNamesFile(namesFile)
        .setNamesSeparator(namesSeparator)
        .createNamesProperties();
  }
}
