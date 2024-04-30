package com.cleancode.knuth;

public class PrimeGenerator {

  private final int MAX_PRIME_ORDER = 30;
  int[] primes;
  int[] primeMultiples;

  int number;
  int currentOddNumber;
  int primeOrder;
  int primeIndex;
  int squareOfNextPrime;

  public int[] generate(int numberOfPrimes) {
    primeMultiples = new int[MAX_PRIME_ORDER + 1];
    initializeStates();
    primes = new int[numberOfPrimes + 1];
    primes[1] = 2;
    while (primeIndex < numberOfPrimes) {
      findNextPrime();
      primeIndex++;
      primes[primeIndex] = currentOddNumber;
    }
    return primes;
  }

  private void initializeStates() {
    number = 0;
    currentOddNumber = 1;
    primeIndex = 1;
    primeOrder = 2;
    squareOfNextPrime = 9;
  }

  private void findNextPrime() {
    boolean isPrime;
    do {
      currentOddNumber += 2;
      checkForNewPrimeOrder();
      isPrime = isCurrentOddPrime();
    } while (!isPrime);
  }

  private boolean isCurrentOddPrime() {
    number = 2;
    while (number < primeOrder) {
      while (primeMultiples[number] < currentOddNumber) {
        primeMultiples[number] += 2 * primes[number];
      }
      if (primeMultiples[number] == currentOddNumber) {
        return false;
      }
      number++;
    }
    return true;
  }

  private void checkForNewPrimeOrder() {
    if (currentOddNumber == squareOfNextPrime) {
      primeOrder++;
      squareOfNextPrime = primes[primeOrder] * primes[primeOrder];
      primeMultiples[primeOrder - 1] = currentOddNumber;
    }
  }
}
