package edu.school21.numbers;

public class NumberWorker {

    public boolean isPrime(int number) {
        int i = 1;
        if (number <= 1) {
            throw new IllegalNumberException("number <= 1");
        } else if (number == 2 || number == 3) {
            return (true);
        } else {
            while (i <= mySqrt(number)) {
                if (number % (++i) == 0) {
                    return (false);
                }
            }
            return (true);
        }
    }

    private static int mySqrt(int input) {
        long start = 1;
        long iter = 1;
        long result = 0;

        while (start - input <= 0) {
            iter += 2;
            start += iter;
            result++;
        }
        return (int) result;
    }

    public int digitsSum(int number) {
        int i = 0;

        while (number != 0) {
            i += number % 10;
            number /= 10;
        }

        return i;
    }

    class IllegalNumberException extends RuntimeException {
        public IllegalNumberException(String message) {
            super(message);
        }

    }
}