package com.cleancode.knuth;

public class PrimeGenerator {
  public void generate() {

    final int M = 1000;
    int[] P = new int[M + 1];
    P[1] = 2;

    int N = 0;
    final int ORDMAX = 30;
    int[] MULT = new int[ORDMAX + 1];
    int J = 1;
    int K = 1;
    int ORD = 2;
    int SQUARE = 9;
    while (K < M) {
      boolean JPRIME;
      do {
        J += 2;
        if (J == SQUARE) {
          ORD++;
          SQUARE = P[ORD] * P[ORD];
          MULT[ORD - 1] = J;
        }
        N = 2;
        JPRIME = true;
        while (N < ORD && JPRIME) {
          while (MULT[N] < J) MULT[N] += P[N] + P[N];
          if (MULT[N] == J) JPRIME = false;
          N++;
        }
      } while (!JPRIME);
      K++;
      P[K] = J;
    }
    int PAGENUMBER = 1;
    int PAGEOFFSET = 1;
    final int CC = 4;
    final int RR = 50;
    while (PAGEOFFSET <= M) {
      System.out.print("The First ");
      System.out.print(Integer.toString(M));
      System.out.print(" Prime Numbers === Page ");
      System.out.print(Integer.toString(PAGENUMBER));
      System.out.println("\n");
      for (int ROWOFFSET = PAGEOFFSET; ROWOFFSET <= PAGEOFFSET + RR - 1; ROWOFFSET++) {
        for (int C = 0; C <= CC - 1; C++)
          if (ROWOFFSET + C * RR <= M) System.out.printf("%10d", P[ROWOFFSET + C * RR]);
        System.out.println();
      }
      System.out.println("\f");
      PAGENUMBER++;
      PAGEOFFSET += RR * CC;
    }
  }
}