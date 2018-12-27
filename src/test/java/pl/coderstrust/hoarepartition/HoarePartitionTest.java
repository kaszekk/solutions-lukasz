package pl.coderstrust.hoarepartition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class HoarePartitionTest {
    @DisplayName("Should partition entry array according to given Pivot")
    @ParameterizedTest
    @MethodSource("oneDuplicatedElementParams")
    void shouldReturnPartitionedArrayAccordingToGivenPivotIndex(int pivotIndex, int[] expected) {
        //Given
        int[] arrayWithOneDuplicatedElement = {1, 7, 15, 11, 3, 10, 6, 4, 2, 1, 8};

        //When
        int[] actual = HoarePartition.applyHoare(arrayWithOneDuplicatedElement, pivotIndex);

        //Then
        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> oneDuplicatedElementParams() {
        return Stream.of(
                Arguments.of(0, new int[]{1, 1, 15, 11, 3, 10, 6, 4, 2, 7, 8}),
                Arguments.of(1, new int[]{6, 1, 1, 2, 3, 4, 7, 10, 11, 15, 8}),
                Arguments.of(2, new int[]{8, 7, 1, 11, 3, 10, 6, 4, 2, 1, 15}),
                Arguments.of(3, new int[]{1, 7, 8, 1, 3, 10, 6, 4, 2, 11, 15}),
                Arguments.of(4, new int[]{1, 1, 2, 3, 11, 10, 6, 4, 15, 7, 8}),
                Arguments.of(5, new int[]{2, 7, 8, 1, 3, 1, 6, 4, 10, 11, 15}),
                Arguments.of(6, new int[]{1, 1, 2, 4, 3, 6, 10, 11, 15, 7, 8}),
                Arguments.of(7, new int[]{3, 1, 2, 1, 4, 10, 6, 11, 15, 7, 8}),
                Arguments.of(8, new int[]{1, 1, 2, 11, 3, 10, 6, 4, 15, 7, 8}),
                Arguments.of(9, new int[]{1, 1, 15, 11, 3, 10, 6, 4, 2, 7, 8}),
                Arguments.of(10, new int[]{4, 7, 1, 1, 3, 2, 6, 8, 10, 11, 15})
        );
    }

    @DisplayName("Should partition entry array according to given Pivot")
    @ParameterizedTest
    @MethodSource("uniqueElementsParams")
    void shouldReturnPartitionedArrayAccordingToGivenPivotInde(int pivotIndex, int[] expected) {
        //Given
        int[] uniqueElementsArray = {6, 9, 5, 0, 4, 2, 1, 3, 10, 8, 7};

        //When
        int[] actual = HoarePartition.applyHoare(uniqueElementsArray, pivotIndex);
        System.out.println(Arrays.toString(actual));

        //Then
        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> uniqueElementsParams() {
        return Stream.of(
                Arguments.of(0, new int[]{1, 3, 5, 0, 4, 2, 6, 9, 10, 8, 7}),
                Arguments.of(1, new int[]{8, 6, 5, 0, 4, 2, 1, 3, 7, 9, 10}),
                Arguments.of(2, new int[]{2, 3, 1, 0, 4, 5, 6, 9, 10, 8, 7}),
                Arguments.of(3, new int[]{0, 9, 5, 6, 4, 2, 1, 3, 10, 8, 7}),
                Arguments.of(4, new int[]{2, 3, 1, 0, 4, 6, 5, 9, 10, 8, 7}),
                Arguments.of(5, new int[]{0, 1, 2, 5, 4, 6, 9, 3, 10, 8, 7}),
                Arguments.of(6, new int[]{0, 1, 5, 9, 4, 2, 6, 3, 10, 8, 7}),
                Arguments.of(7, new int[]{0, 1, 2, 3, 4, 5, 9, 6, 10, 8, 7}),
                Arguments.of(8, new int[]{7, 9, 5, 0, 4, 2, 1, 3, 6, 8, 10}),
                Arguments.of(9, new int[]{6, 7, 5, 0, 4, 2, 1, 3, 8, 10, 9}),
                Arguments.of(10, new int[]{3, 6, 5, 0, 4, 2, 1, 7, 10, 8, 9})
        );
    }

    @DisplayName("Should partition entry array according to given Pivot")
    @ParameterizedTest
    @MethodSource("monoArrayParams")
    void shouldReturnPartitionedArrayAccordingToGivenPivotI(int pivotIndex, int[] expected) {
        //Given
        int[] monoValueArray = {2, 2, 2, 2, 2, 2};

        //When
        int[] actual = HoarePartition.applyHoare(monoValueArray, pivotIndex);

        //Then
        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> monoArrayParams() {
        return Stream.of(
                Arguments.of(0, new int[]{2, 2, 2, 2, 2, 2}),
                Arguments.of(1, new int[]{2, 2, 2, 2, 2, 2}),
                Arguments.of(2, new int[]{2, 2, 2, 2, 2, 2}),
                Arguments.of(3, new int[]{2, 2, 2, 2, 2, 2}),
                Arguments.of(4, new int[]{2, 2, 2, 2, 2, 2}),
                Arguments.of(5, new int[]{2, 2, 2, 2, 2, 2})
        );
    }

    @DisplayName("Should partition one element array to given Pivot")
    @ParameterizedTest
    @MethodSource("oneElementParams")
    void shouldReturnPartitionedArrayForOneElementArray(int pivotIndex, int[] expected) {
        //Given
        int[] oneElementArray = {2};

        //When
        int[] actual = HoarePartition.applyHoare(oneElementArray, pivotIndex);

        //Then
        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> oneElementParams() {
        return Stream.of(
                Arguments.of(0, new int[]{2})
        );
    }

    @DisplayName("Should throw exception when null passed as array reference")
    @Test
    void shouldThrowExceptionIfArrayIsNull() {
        assertThrows(IllegalArgumentException.class, () -> HoarePartition.applyHoare(null, 0));
    }

    @DisplayName("Should throw exception for an empty array")
    @Test
    void shouldThrowExceptionForEmptyArray() {
        assertThrows(IllegalArgumentException.class, () -> HoarePartition.applyHoare(new int[0], 0));
    }

    @DisplayName("Should throw exception for negative pivotIndex")
    @Test
    void shouldThrowExceptionForNegativePivotIndex() {
        assertThrows(IllegalArgumentException.class, () -> HoarePartition.applyHoare(new int[2], -1));
    }

    @DisplayName("Should throw exception for pivotIndex exceeding array length")
    @Test
    void shouldThrowExceptionForPivotIndexExceedingArrayLength() {
        assertThrows(IllegalArgumentException.class, () -> HoarePartition.applyHoare(new int[2], 2));
    }
}
