package pl.coderstrust.sieve;

public class SieveOfEratosthenes {
    final private static int NOT_PRIME = 0;

    static int[] sieve(int maximumNumber) {
        int[] array = generateSequenceOfNumbers(maximumNumber);
        filterPrimes(maximumNumber, array);
        return getPrimesArray(array);
    }

    private static void filterPrimes(int maximumNumber, int[] array) {
        for (int multiplicator = 2; multiplicator <= maximumNumber; multiplicator++) {
            for (int sieveNumber = 2; sieveNumber * multiplicator <= maximumNumber; sieveNumber++) {
                array[sieveNumber * multiplicator] = NOT_PRIME;
            }
        }
    }

    private static int[] getPrimesArray(int[] array) {
        int[] primaryNumbersArray = new int[getPrimaryNumbersCount(array)];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (array[i] != NOT_PRIME) {
                primaryNumbersArray[j++] = array[i];
            }
        }
        return primaryNumbersArray;
    }

    private static int getPrimaryNumbersCount(int[] array) {
        int primaryNumbersCounter = 0;
        for (int element : array) {
            if (element != NOT_PRIME) {
                primaryNumbersCounter++;
            }
        }
        return primaryNumbersCounter;
    }

    private static int[] generateSequenceOfNumbers(int maximumNumber) {
        int[] array = new int[maximumNumber + 1];
        for (int i = 2; i <= maximumNumber; i++) {
            array[i] = i;
        }
        return array;
    }
}
