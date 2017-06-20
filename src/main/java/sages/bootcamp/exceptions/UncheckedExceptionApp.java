package sages.bootcamp.exceptions;

/**
 * Unchecked exception nie musi być, ale może być złapane za pomocą try-catch
 */
public class UncheckedExceptionApp {
  public static void main(String[] args) {
    test1();
//  test2();
//  test3();
  }

  static void test1() {
    try {
      throwUncheckeException(true);
    } catch (RuntimeException e) {
      System.out.println("Poleciał jakiś błąd");
    }
  }

  static void test2() {
    int[] numbers = new int[]{1, 2, 3};
    System.out.println(numbers[4]);

  }

  static void test3() {
    divideBy(0);
    divideBy(5);
  }


  static void throwUncheckeException(boolean uncheckedException) {
    throw new RuntimeException("Nieoczekiwany błąd");
  }

  static void unimplementedOperation() {
    throw new UnsupportedOperationException("Not implemented."); // todo not implemented
  }

  static void divideBy(int a) {
    if (a == 0) { // fixme coś jest nie tak, popraw algorytm
      System.out.println("A jest równe 0.");
    } else {
      System.out.println(10 / a);
    }
  }

}
