package com.cleancode.knuth;

public class PrimePrinter {
  public static void main(String[] args) {
    int numberOfPrimes = 1000;
    PrimeGenerator primeGenerator = new PrimeGenerator();
    int[] primes = primeGenerator.generate(numberOfPrimes);
    NumberPrinter numberPrinter = new NumberPrinter();
    numberPrinter.printNumbers(numberOfPrimes, primes,50,4);
  }
}
