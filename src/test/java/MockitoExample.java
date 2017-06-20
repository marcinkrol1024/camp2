import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import sages.bootcamp.names.NamesFacade;
import sages.bootcamp.names.NamesJoiner;
import sages.bootcamp.names.NamesProperties;
import sages.bootcamp.names.NamesReader;

import java.io.IOException;

public class MockitoExample {


  NamesProperties fakeNamesProperties = new NamesProperties("", "") {
    @Override
    public String getNamesSeparator() {
      return "fake-separator";
    }

    @Override
    public String getNamesFile() {
      return "fake-names-file";
    }
  };


  @Test
  public void shouldMockito() throws IOException {
    // given
    NamesProperties namesProperties = Mockito.mock(NamesProperties.class);
    Mockito.when(namesProperties.getNamesFile()).thenReturn("names2");
    Mockito.when(namesProperties.getNamesSeparator()).thenReturn(":");

    NamesJoiner namesJoiner = new NamesJoiner();
    NamesReader namesReader = new NamesReader();
    NamesFacade namesFacade = new NamesFacade(
        namesProperties,
        namesJoiner,
        namesReader
    );

    // and
    String expectedJoinedNames = "Marcin, Paweł, Ania, Ola, Kamil";

    // when
    String actualJoinedNames = namesFacade.constructJoinedNames();

    // then
    Assert.assertEquals(expectedJoinedNames, actualJoinedNames);
  }
}
