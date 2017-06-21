import org.junit.Test;
import org.mockito.Mockito;
import sages.bootcamp.names.*;

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


  // reader używa nazwy pliku z properties
  // joiner używa separatora z properties
  // używa readera do wczytania imion
  // używa joinera do połączenia imion
  // zwraca wartość domyślną, jeśli reader zfailuje
  @Test
  public void shouldMockito() throws IOException, InvalidFileNameException {
    // given
    String fileName = "some-file";
    NamesProperties namesProperties = Mockito.mock(NamesProperties.class);
    Mockito.when(namesProperties.getNamesFile()).thenReturn(fileName);

    NamesJoiner namesJoiner = Mockito.mock(NamesJoiner.class);
    NamesReader namesReader = Mockito.mock(NamesReader.class);

    NamesFacade namesFacade = new NamesFacade(
        namesProperties,
        namesJoiner,
        namesReader
    );

    // when
    namesFacade.constructJoinedNames();

    // then
    Mockito.verify(namesReader).read(fileName);
  }
}
