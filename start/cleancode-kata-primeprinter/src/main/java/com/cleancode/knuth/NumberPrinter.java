package com.cleancode.knuth;

public class NumberPrinter {
  public void printNumbers(int totalNumbers, int[] numberList) {
    int pagenumber = 1;
    int pageoffset = 1;
    final int colsPerPage = 4;
    final int rowsPerPage = 50;
    while (pageoffset <= totalNumbers) {
      System.out.print("The First ");
      System.out.print(Integer.toString(totalNumbers));
      System.out.print(" Prime Numbers === Page ");
      System.out.print(Integer.toString(pagenumber));
      System.out.println("\n");
      for (int rowoffset = pageoffset; rowoffset <= pageoffset + rowsPerPage - 1; rowoffset++) {
        for (int columnNo = 0; columnNo <= colsPerPage - 1; columnNo++)
          if (rowoffset + columnNo * rowsPerPage <= totalNumbers)
            System.out.printf("%10d", numberList[rowoffset + columnNo * rowsPerPage]);
        System.out.println();
      }
      System.out.println("\f");
      pagenumber++;
      pageoffset += rowsPerPage * colsPerPage;
    }
  }
}
