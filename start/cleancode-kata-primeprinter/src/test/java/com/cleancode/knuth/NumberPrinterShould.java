package com.cleancode.knuth;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NumberPrinterShould {
  private ByteArrayOutputStream outputStream;
  private PrintStream originalOut;

  @Before
  public void setUp() {
    outputStream = new ByteArrayOutputStream();
    originalOut = System.out;
    System.setOut(new PrintStream(outputStream));
  }

  @Test
  public void test_print_numbers_large_list(){
    NumberPrinter printer = new NumberPrinter();
    int totalNumbers = 10;
    int[] numberList = {0, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

    printer.printNumbers(totalNumbers, numberList,3,4);

    String expectedOutput = "The First 10 Prime Numbers === Page 1\n\r\n"
        + "         2         7        17        29\r\n"
        + "         3        11        19\r\n"
        + "         5        13        23\r\n\f\r\n";

    assertEquals(expectedOutput, outputStream.toString());
  }

  @Test
  public void testPrintNumbers_EmptyList() {
    NumberPrinter printer = new NumberPrinter();
    int totalNumbers = 0;
    int[] numberList = {};

    printer.printNumbers(totalNumbers, numberList,4,4);

    String expectedOutput = "";

    assertEquals(expectedOutput, outputStream.toString().trim());
  }

  @After
  public void tearDown() {
    System.setOut(originalOut);
  }
}
