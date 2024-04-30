package com.cleancode.knuth;

public class PrimeGenerator {
  public int[] generate() {

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
    return primes;
  }
}
