package pl.coderstrust.search;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class SearchingTestBase {
    public abstract SearchingMethod getSearchingMethod();

    private static int size = 200_000_001;
    private static int[] sortedArray = new int[size];

    @BeforeAll
    static void createSortedArrayForTest() {
        for (int i = 0; i < sortedArray.length; i++) {
            sortedArray[i] = i;
        }
    }

    @ParameterizedTest(name = "{index} => expected={0},description of index = {1}")
    @MethodSource("shouldReturnIndexOfFoundElementParams")
    void shouldReturnIndexOfFoundElement(int expected, String indexName) {
        //Given
        int element = sortedArray[expected];

        //When
        long startTime = System.currentTimeMillis();
        int actual = getSearchingMethod().search(sortedArray, element);
        long stopTime = System.currentTimeMillis();
        long durationOfTest = stopTime - startTime;
        System.out.println(getSearchingMethod().getSortingMethodName() + " implementation took " + durationOfTest + " ms to find " + indexName + " at index number " + expected + " in the array");

        //Then
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> shouldReturnIndexOfFoundElementParams() {
        return Stream.of(
                Arguments.of(0, "the first element"),
                Arguments.of((sortedArray.length - 1) / 2, "the middle element"),
                Arguments.of(sortedArray.length - 1, "the last element"));
    }

    @Test
    void shouldSearchNotExistingElement() {
        //Given
        int element = -100;

        //When
        int actual = getSearchingMethod().search(sortedArray, element);

        //Then
        assertEquals(-1, actual);
    }

    @DisplayName("Should throw exception when attempt to search for an element in an empty array is made")
    @Test
    void shouldThrowExceptionIfArrayIsEmpty() {
        int[] emptyArray = new int[0];
        int element = 100;
        assertThrows(IllegalArgumentException.class, () -> getSearchingMethod().search(emptyArray, element));
    }

    @DisplayName("Should throw exception when null passed as array reference")
    @Test
    void shouldThrowExceptionIfArrayIsNull() {
        int element = 100;
        assertThrows(IllegalArgumentException.class, () -> getSearchingMethod().search(null, element));
    }
}
