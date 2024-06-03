package com.cleancode.knuth;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


public class PrimeGeneratorShould {
  @Test
  public void test_generate_small_primes() {
    PrimeGenerator primeGenerator = new PrimeGenerator();

    int[] primes = primeGenerator.generate(1);
    assertThat(primes[1]).isEqualTo(2);

    primes = primeGenerator.generate(5);
    assertThat(primes[1]).isEqualTo(2);
    assertThat(primes[2]).isEqualTo(3);
    assertThat(primes[3]).isEqualTo(5);
    assertThat(primes[4]).isEqualTo(7);
    assertThat(primes[5]).isEqualTo(11);
  }
  @Test
  public void test_generate_larger_primes() {
    PrimeGenerator primeGenerator = new PrimeGenerator();

    int[] primes = primeGenerator.generate(100);

    // Check some specific values in the list
    assertThat(primes[1]).isEqualTo(2);
    assertThat(primes[100]).isEqualTo(541);
  }

  @Test
  public void test_generate_with_negative_primes() {
    PrimeGenerator generator = new PrimeGenerator();
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      generator.generate(-1);
    });
    assertEquals("Number is not valid",exception.getMessage());
  }
}
