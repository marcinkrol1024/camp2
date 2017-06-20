package sages.bootcamp.names;

import com.google.common.base.Joiner;

import java.util.List;

public class NamesJoiner {
  public String join(List<String> names, String namesSeparator) {
    return Joiner.on(namesSeparator).join(names);
  }
}
