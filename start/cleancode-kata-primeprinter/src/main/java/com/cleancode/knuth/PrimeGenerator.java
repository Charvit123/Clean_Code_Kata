package com.cleancode.knuth;

public class PrimeGenerator {
  public void generate() {

    final int numberOfPrimes = 1000;
    int[] primes = new int[numberOfPrimes + 1];
    primes[1] = 2;

    int number = 0;
    final int maxPrimeOrder = 30;
    int[] primeMultiples = new int[maxPrimeOrder + 1];
    int currentOddNumber = 1;
    int primeIndex = 1;
    int primeOrder = 2;
    int square = 9;
    while (primeIndex < numberOfPrimes) {
      boolean isPrime;
      do {
        currentOddNumber += 2;
        if (currentOddNumber == square) {
          primeOrder++;
          square = primes[primeOrder] * primes[primeOrder];
          primeMultiples[primeOrder - 1] = currentOddNumber;
        }
        number = 2;
        isPrime = true;
        while (number < primeOrder && isPrime) {
          while (primeMultiples[number] < currentOddNumber)
            primeMultiples[number] += primes[number] + primes[number];
          if (primeMultiples[number] == currentOddNumber) isPrime = false;
          number++;
        }
      } while (!isPrime);
      primeIndex++;
      primes[primeIndex] = currentOddNumber;
    }
    int pagenumber = 1;
    int pageoffset = 1;
    final int colsPerPage = 4;
    final int rowsPerPage = 50;
    while (pageoffset <= numberOfPrimes) {
      System.out.print("The First ");
      System.out.print(Integer.toString(numberOfPrimes));
      System.out.print(" Prime Numbers === Page ");
      System.out.print(Integer.toString(pagenumber));
      System.out.println("\n");
      for (int rowoffset = pageoffset; rowoffset <= pageoffset + rowsPerPage - 1; rowoffset++) {
        for (int columnNo = 0; columnNo <= colsPerPage - 1; columnNo++)
          if (rowoffset + columnNo * rowsPerPage <= numberOfPrimes)
            System.out.printf("%10d", primes[rowoffset + columnNo * rowsPerPage]);
        System.out.println();
      }
      System.out.println("\f");
      pagenumber++;
      pageoffset += rowsPerPage * colsPerPage;
    }
  }
}
