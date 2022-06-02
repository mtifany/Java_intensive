package edu.school21. numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

class NumberWorkerTest {

    NumberWorker test;

    @BeforeEach
    void beforeEach() { test = new NumberWorker();}

    @ParameterizedTest
    @ValueSource(ints = {79, 1993, 174761, 2, 3})
    void isPrimeForPrimes(int number){
        Assertions.assertTrue(test.isPrime(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 1994, 174762, 100000, 169})
    void isPrimeForNotPrimes(int number){
        Assertions.assertFalse(test.isPrime(number));
    }


    @ParameterizedTest
    @ValueSource(ints = {-4, 0, 1, -100000, -174761})
    void isPrimeForIncorrectNumbers(int number){
        Assertions.assertThrows(NumberWorker.IllegalNumberException.class, () -> test.isPrime(number));
    }
    @ParameterizedTest
    @CsvFileSource(resources = {"/data.csv"}, delimiter = ' ')
    void checkDigitSum (int x, int y){
        Assertions.assertEquals(test.digitsSum(x), y);
    }

}
