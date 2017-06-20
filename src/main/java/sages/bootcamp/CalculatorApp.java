package sages.bootcamp;

import sages.bootcamp.calculator.Calculator;

public class CalculatorApp {
  public static void main(String[] args) {
    int a = 2, b = 3;
    Calculator calculator = new Calculator();
    System.out.println(calculator.add(a, b));
  }
}
