package com.cleancode.knuth;

public class NumberPrinter {
  public void printNumbers(int totalNumbers, int[] numberList, int rowsPerPage, int colsPerPage) {
    int pagenumber = 1;
    int pageoffset = 1;
    while (pageoffset <= totalNumbers) {
      printHeader(totalNumbers, pagenumber);
      printPage(totalNumbers, numberList, pageoffset , rowsPerPage, colsPerPage);
      System.out.println("\f");
      pagenumber++;
      pageoffset += rowsPerPage * colsPerPage;
    }
  }

  private static void printPage(int totalNumbers, int[] numberList, int pageoffset, int rowsPerPage, int colsPerPage) {
    for (int rowoffset = pageoffset; rowoffset <= pageoffset + rowsPerPage - 1; rowoffset++) {
      printRow(totalNumbers, numberList, rowoffset, rowsPerPage, colsPerPage);
    }
  }

  private static void printRow(int totalNumbers, int[] numberList, int rowoffset, int rowsPerPage, int colsPerPage) {
    for (int columnNo = 0; columnNo <= colsPerPage - 1; columnNo++) {
      if (rowoffset + columnNo * rowsPerPage <= totalNumbers) {
        System.out.printf("%10d", numberList[rowoffset + columnNo * rowsPerPage]);
      }
    }
    System.out.println();
  }

  private static void printHeader(int totalNumbers, int pagenumber) {
    System.out.print("The First ");
    System.out.print(totalNumbers);
    System.out.print(" Prime Numbers === Page ");
    System.out.print(pagenumber);
    System.out.println("\n");
  }
}
