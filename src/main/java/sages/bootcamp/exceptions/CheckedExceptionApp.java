package sages.bootcamp.exceptions;

import java.io.FileReader;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

/**
 * Wyróżniamy 2 typy exceptions: Unchecked i Checked
 * Checked exceptions dziedziczą po klasie Exception
 * Unchecked exceptions dziedziczą po klasie RuntimeException
 */
public class CheckedExceptionApp {
  public static void main(String[] args) {

    loadFromFile("plik-nieistniejący");

//    try {
//      addTwoNumbers("100", "100");
//      addTwoNumbers("adasd", "100");
//    } catch (Exception e) {
//      System.out.println("Któryś z argumentów nie jest liczbą.");
//    }
//
//    loadFromFile("filePath").ifPresent(text -> {
//      // zrób coś tam
//    });

  }

  static int loadFromFile(String filePath) {
    try {
      int result = new FileReader(filePath).read();
      System.out.println("Operacja po wczytywaniu");
      return result;
    } catch (Exception e) {
      System.out.println("Coś poszło nie tak");
    } finally {
      System.out.println("Finally");
    }

    return 0;
  }

  static void addTwoNumbers(String left, String right) throws Exception {
    System.out.println("Log 1");
    if (!isANumber(left) || !isANumber(right)) {
      throw new Exception("Któryś argument nie jest liczbą.");
    }
    System.out.println("Log 2");
    System.out.println(parseInt(left) + parseInt(right));
  }

  private static boolean isANumber(String input) {
    return Pattern.matches("[0-9]*", input);
  }


  static void firstMethod() {
    try {
      secondMethod();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  static void secondMethod() throws Exception {
    thirdMethod();
  }

  static void thirdMethod() throws Exception {
    throw new RuntimeException("");
  }

}
