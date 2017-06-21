import org.junit.Test;
import sages.bootcamp.names.InvalidFileNameException;
import sages.bootcamp.names.NamesFacade;
import sages.bootcamp.names.NamesJoiner;
import sages.bootcamp.names.NamesProperties;
import sages.bootcamp.names.NamesReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
  @Test
  public void shouldMockito() throws IOException, InvalidFileNameException {
    // given
    String fileName = "some-file";
    String separator = "some-separator";
    NamesProperties namesProperties = mock(NamesProperties.class);
    when(namesProperties.getNamesFile()).thenReturn(fileName);
    when(namesProperties.getNamesSeparator()).thenReturn(separator);

    List<String> names = mock(List.class);
    NamesReader namesReader = mock(NamesReader.class);
    when(namesReader.read(fileName)).thenReturn(names);

    String expectedJoinedNames = "some-joined-names";
    NamesJoiner namesJoiner = mock(NamesJoiner.class);
    when(namesJoiner.join(names, separator)).thenReturn(expectedJoinedNames);

    NamesFacade namesFacade = new NamesFacade(
        namesProperties,
        namesJoiner,
        namesReader
    );

    // when
    String actualJoinedNames = namesFacade.constructJoinedNames();

    // then
    verify(namesReader).read(fileName);
    verify(namesJoiner).join(names, separator);
    assertEquals(expectedJoinedNames, actualJoinedNames);
  }

  // jeśli reader zfailuje, to do joinera przekazana jest pusta lista
  @Test
  public void shouldReturnEmptyListWhenReaderFails() throws IOException, InvalidFileNameException {
    // given
    NamesProperties namesProperties = mock(NamesProperties.class);

    NamesReader namesReader = mock(NamesReader.class);
    when(namesReader.read(any())).thenThrow(new FileNotFoundException());

    NamesJoiner namesJoiner = mock(NamesJoiner.class);

    NamesFacade namesFacade = new NamesFacade(
        namesProperties,
        namesJoiner,
        namesReader
    );

    // when
    namesFacade.constructJoinedNames();

    // then
    verify(namesJoiner).join(eq(new ArrayList<>()), any());
  }
}
