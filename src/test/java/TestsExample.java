import org.junit.*;

import java.util.ArrayList;
import java.util.List;

public class TestsExample {

  static List<String> dataBase = new ArrayList<>();

  @BeforeClass
  public void beforeClass() {
    System.out.println("Wykonane raz przed wszystkimi testami w klasie");
    // coś wykonane raz przed wszystkimi testami w klasie
  }

  @Before
  public void before() {
    dataBase.clear();
  }

  @After
  public void after() {
    System.out.println("Wykonanie po teście.");
    // coś po wykonaniu każdego testu
  }

  @Test
  public void shouldAddElementToList() {
    // given
    String elementToAdd = "some-element";

    // when
    dataBase.add(elementToAdd);

    // then
    Assert.assertEquals(1, dataBase.size());
    Assert.assertEquals(elementToAdd, dataBase.get(0));
  }

  @Test
  public void shouldAddAnotherElementToList() {
    // given
    String elementToAdd = "some-other-element";

    // when
    dataBase.add(elementToAdd);

    // then
    Assert.assertEquals(1, dataBase.size());
    Assert.assertEquals(elementToAdd, dataBase.get(0));
  }

  @Test
  public void shouldSucceed() {
    // given
    int a = 2, b = 3;

    // when
    int result = a + b;

    // then
    Assert.assertEquals(5, result);
  }

  @Test
  public void shouldFail() {
    int a = 2, b = 3;

    int result = a + b;

    Assert.assertEquals(7, result);
  }
}
