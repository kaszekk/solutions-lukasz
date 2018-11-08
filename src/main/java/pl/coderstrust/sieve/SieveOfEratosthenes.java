package pl.coderstrust.sieve;

public class SieveOfEratosthenes {
    public static int[] sieve(int maximumNumber) {
        int[] array = new int[maximumNumber + 1];
        for (int i = 2; i <= maximumNumber; i++) {
            array[i] = i;
        }
        for (int multiplicator = 2; multiplicator <= maximumNumber; multiplicator++) {
            for (int sieveNumber = 2; sieveNumber * multiplicator <= maximumNumber; sieveNumber++) {
                array[sieveNumber * multiplicator] = 0;
            }
        }
        int primaryNumbersCounter = 0;
        for (int element : array) {
            if (element != 0) {
                primaryNumbersCounter++;
            }
        }
        int[] primaryNumbersArray = new int[primaryNumbersCounter];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (array[i] != 0) {
                primaryNumbersArray[j++] = array[i];
            }
        }
        return primaryNumbersArray;
    }
}
