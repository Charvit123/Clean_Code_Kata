package com.cleancode.knuth;

public class PrimePrinter {
  public static void main(String[] args) {
    PrimeGenerator primeGenerator = new PrimeGenerator();
    int[] primes = primeGenerator.generate();
    int numberOfPrimes = 1000;
    primeGenerator.printNumbers(numberOfPrimes, primes);
  }
}
