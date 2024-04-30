package com.cleancode.knuth;

public class NumberPrinter {

  public static final int COLS_PER_PAGE = 4;
  public static final int ROWS_PER_PAGE = 50;

  public void printNumbers(int totalNumbers, int[] numberList) {
    int pagenumber = 1;
    int pageoffset = 1;
    while (pageoffset <= totalNumbers) {
      printHeader(totalNumbers, pagenumber);
      printPage(totalNumbers, numberList, pageoffset);
      System.out.println("\f");
      pagenumber++;
      pageoffset += ROWS_PER_PAGE * COLS_PER_PAGE;
    }
  }

  private static void printPage(int totalNumbers, int[] numberList, int pageoffset) {
    for (int rowoffset = pageoffset; rowoffset <= pageoffset + ROWS_PER_PAGE - 1; rowoffset++) {
      printRow(totalNumbers, numberList, rowoffset);
    }
  }

  private static void printRow(int totalNumbers, int[] numberList, int rowoffset) {
    for (int columnNo = 0; columnNo <= COLS_PER_PAGE - 1; columnNo++) {
      if (rowoffset + columnNo * ROWS_PER_PAGE <= totalNumbers) {
        System.out.printf("%10d", numberList[rowoffset + columnNo * ROWS_PER_PAGE]);
      }
    }
    System.out.println();
  }

  private static void printHeader(int totalNumbers, int pagenumber) {
    System.out.print("The First ");
    System.out.print(Integer.toString(totalNumbers));
    System.out.print(" Prime Numbers === Page ");
    System.out.print(Integer.toString(pagenumber));
    System.out.println("\n");
  }
}
