package sages.bootcamp.names;

import org.junit.Test;

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

public class NamesFacadeSpec {

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

  // reader używa nazwy pliku z properties
  @Test
  public void shouldUseFileNameFromPropertiesForReader() throws IOException, InvalidFileNameException {
    // given
    String fileName = "some-file";
    NamesProperties namesProperties = mock(NamesProperties.class);
    when(namesProperties.getNamesFile()).thenReturn(fileName);

    NamesFacade namesFacade = new NamesFacade(
        namesProperties,
        mock(NamesJoiner.class),
        mock(NamesReader.class)
    );

    // when
    namesFacade.constructJoinedNames();

    // then
    verify(mock(NamesReader.class)).read(fileName);
  }

  // jeśli reader zfailuje, to do joinera przekazana jest pusta lista
  @Test
  public void shouldReturnEmptyListWhenReaderFails() throws IOException, InvalidFileNameException {
    // given
    NamesReader namesReader = mock(NamesReader.class);
    when(namesReader.read(any())).thenThrow(new FileNotFoundException());

    NamesFacade namesFacade = new NamesFacade(
        mock(NamesProperties.class),
        mock(NamesJoiner.class),
        namesReader
    );

    // when
    namesFacade.constructJoinedNames();

    // then
    verify(mock(NamesJoiner.class)).join(eq(new ArrayList<>()), any());
  }

}