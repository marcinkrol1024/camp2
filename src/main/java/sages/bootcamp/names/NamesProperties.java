package sages.bootcamp.names;

import com.google.common.io.Resources;

import java.io.IOException;
import java.util.Properties;

public class NamesProperties {

  private final Properties properties;

  public NamesProperties(String propertiesFile) throws IOException {
    properties = new Properties();
    properties.load(
        Resources
            .getResource(propertiesFile)
            .openStream()
    );
  }


  public String getNamesFile() {
    return properties.getProperty("names.files.path");
  }
}
