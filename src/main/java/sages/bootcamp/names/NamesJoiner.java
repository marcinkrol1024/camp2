package sages.bootcamp.names;

import java.util.List;

public class NamesJoiner {
  public String join(List<String> names) {
    // budowanie stringa z imion
    StringBuilder namesBuilder = new StringBuilder();
    if (names.size() > 1) {
      namesBuilder.append(names.get(0));
      for (int i = 1; i < names.size(); i++) {
        namesBuilder.append(", ").append(names.get(i));
      }
    }

    return namesBuilder.toString();
  }
}
