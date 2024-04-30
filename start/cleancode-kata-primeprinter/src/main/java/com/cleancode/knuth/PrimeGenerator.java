package com.cleancode.knuth;

public class PrimeGenerator {

  final int maxPrimeOrder = 30;
  boolean isPrime;
  int[] primes;
  int[] primeMultiples = new int[maxPrimeOrder + 1];
  int primeOrder;
  int primeIndex;
  int number;
  int currentOddNumber;
  int square;

  public int[] generate(int numberOfPrimes) {
    number = 0;
    currentOddNumber = 1;
    primeIndex = 1;
    primeOrder = 2;
    primes = new int[numberOfPrimes + 1];
    primes[1] = 2;
    square = 9;
    while (primeIndex < numberOfPrimes) {
      square = findNextPrime();
      primeIndex++;
      primes[primeIndex] = currentOddNumber;
    }
    return primes;
  }

  private int findNextPrime() {
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
    return square;
  }
}
