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

  // używa joinera do połączenia imion
  @Test
  public void shouldMockito() throws IOException, InvalidFileNameException {
    // given
    String expectedJoinedNames = "some-joined-names";
    NamesJoiner namesJoiner = mock(NamesJoiner.class);
    when(namesJoiner.join(any(), any())).thenReturn(expectedJoinedNames);

    NamesFacade namesFacade = new NamesFacade(
        mock(NamesProperties.class),
        namesJoiner,
        mock(NamesReader.class)
    );

    // when
    String actualJoinedNames = namesFacade.constructJoinedNames();

    // then
    assertEquals(expectedJoinedNames, actualJoinedNames);
  }

  // używa readera do wczytania imion
  @Test
  public void shouldUseReaderToReadNames() throws IOException, InvalidFileNameException {
    // given
    List<String> names = mock(List.class);
    NamesReader namesReader = mock(NamesReader.class);
    when(namesReader.read(any())).thenReturn(names);

    NamesJoiner namesJoiner = mock(NamesJoiner.class);

    NamesFacade namesFacade = new NamesFacade(
        mock(NamesProperties.class),
        namesJoiner,
        namesReader
    );

    // when
    namesFacade.constructJoinedNames();

    // then
    verify(namesJoiner).join(eq(names), any());
  }

  // joiner używa separatora z properties
  @Test
  public void shouldUseSeparatorFromPropertiesForJoiner() throws IOException, InvalidFileNameException {
    // given
    String separator = "some-separator";
    NamesProperties namesProperties = mock(NamesProperties.class);
    when(namesProperties.getNamesSeparator()).thenReturn(separator);

    NamesJoiner namesJoiner = mock(NamesJoiner.class);

    NamesFacade namesFacade = new NamesFacade(
        namesProperties,
        namesJoiner,
        mock(NamesReader.class)
    );

    // when
    namesFacade.constructJoinedNames();

    // then
    verify(namesJoiner).join(any(), eq(separator));
  }

  // reader używa nazwy pliku z properties
  @Test
  public void shouldUseFileNameFromPropertiesForReader() throws IOException, InvalidFileNameException {
    // given
    String fileName = "some-file";
    NamesProperties namesProperties = mock(NamesProperties.class);
    when(namesProperties.getNamesFile()).thenReturn(fileName);

    NamesReader namesReader = mock(NamesReader.class);

    NamesFacade namesFacade = new NamesFacade(
        namesProperties,
        mock(NamesJoiner.class),
        namesReader
    );

    // when
    namesFacade.constructJoinedNames();

    // then
    verify(namesReader).read(fileName);
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