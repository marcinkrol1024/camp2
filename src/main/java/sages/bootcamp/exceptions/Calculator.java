package sages.bootcamp.exceptions;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Calculator {

  public static void main(String[] args) {
    Calculator calculator = new Calculator();
//    calculator.subtract("", "");
    Scanner scanner = new Scanner(System.in);
    boolean failed = true;
    do {
      try {
        String liczba = scanner.next();
        calculator.add(liczba, "2");
        failed = false;
      } catch (NotANumberException e) {
        System.out.println("Wprowadź jeszcze raz, argument nie jest liczbą.");
      }
    } while (failed);

//    calculator.uncheckedAdd("a", "b");
  }


  int subtract(String left, String right) {
    throw new UnsupportedOperationException("Not implemented"); // todo not implemented
  }

  int add(String left, String right) throws NotANumberException {
    if (isANumber(left) && isANumber(right)) {
      return Integer.parseInt(left) + Integer.parseInt(right);
    } else {
      throw new NotANumberException();
    }
  }

  int uncheckedAdd(String left, String right) {
    if (isANumber(left) && isANumber(right)) {
      return Integer.parseInt(left) + Integer.parseInt(right);
    } else {
      throw new UncheckedNotANumberException();
    }
  }

  private static boolean isANumber(String input) {
    return Pattern.matches("[0-9]*", input);
  }

  static class NotANumberException extends Exception {

  }

  static class UncheckedNotANumberException extends RuntimeException {

  }


}
