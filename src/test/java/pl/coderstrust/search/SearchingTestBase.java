package pl.coderstrust.search;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @ParameterizedTest(name = "{index} => searchedElementIndex={0},   descriptionOfIndex={1}")
    @MethodSource("shouldSearchForElementInSortedArrayParams")
    void shouldSearchForElementInSortedArray(int index, String indexName) {
        //Given
        int searchedValue = sortedArray[index];
        int expected = searchedValue;
        long startTime = System.currentTimeMillis();

        //When
        int actual = getSearchingMethod().search(sortedArray, searchedValue);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println(getSearchingMethod().getClass().getSimpleName() + " implementation took " + elapsedTime + " ms to find " + indexName + " at index number " + index + " in the array");

        //Then
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> shouldSearchForElementInSortedArrayParams() {
        return Stream.of(
                Arguments.of(0, "the first element"),
                Arguments.of((sortedArray.length - 1) / 2, "the middle element"),
                Arguments.of(sortedArray.length - 1, "the last element"));
    }
}
