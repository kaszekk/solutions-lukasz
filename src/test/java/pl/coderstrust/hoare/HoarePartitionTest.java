package pl.coderstrust.hoare;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HoarePartitionTest {

    @DisplayName("Should partition array according to given Pivot")
    @ParameterizedTest
    @MethodSource("shouldCorrectlyPartitionTableParams")
    void shouldCorrectlyPartitionTable(int[] tableForPartition, int pivotIndex, int[] expected) {
        //When
        int[] actual = HoarePartition.partitionTable(tableForPartition, pivotIndex);

        //Then
        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> shouldCorrectlyPartitionTableParams() {
        final int[] oneDuplicatedElementArray = {1, 7, 15, 11, 3, 10, 6, 4, 2, 1, 8};
        final int[] uniqueElementsArray = {6, 9, 5, 0, 4, 2, 1, 3, 10, 8, 7};
        final int[] monoValueArray = {2, 2, 2, 2, 2, 2};
        final int[] oneElementArray = {2};
        return Stream.of(
                Arguments.of(oneDuplicatedElementArray, 0, new int[]{1, 1, 15, 11, 3, 10, 6, 4, 2, 7, 8}),
                Arguments.of(oneDuplicatedElementArray, 1, new int[]{6, 1, 1, 2, 3, 4, 7, 10, 11, 15, 8}),
                Arguments.of(uniqueElementsArray, 2, new int[]{2, 3, 1, 0, 4, 5, 6, 9, 10, 8, 7}),
                Arguments.of(uniqueElementsArray, 3, new int[]{0, 9, 5, 6, 4, 2, 1, 3, 10, 8, 7}),
                Arguments.of(monoValueArray, 3, new int[]{2, 2, 2, 2, 2, 2}),
                Arguments.of(monoValueArray, 4, new int[]{2, 2, 2, 2, 2, 2}),
                Arguments.of(oneElementArray, 0, new int[]{2})
        );
    }

    @DisplayName("Should throw exception when null passed as array reference")
    @Test
    void shouldThrowExceptionIfArrayIsNull() {
        assertThrows(IllegalArgumentException.class, () -> HoarePartition.partitionTable(null, 0));
    }

    @DisplayName("Should throw exception for an empty array")
    @Test
    void shouldThrowExceptionForEmptyArray() {
        assertThrows(IllegalArgumentException.class, () -> HoarePartition.partitionTable(new int[0], 0));
    }

    @DisplayName("Should throw exception for negative pivotIndex")
    @Test
    void shouldThrowExceptionForNegativePivotIndex() {
        assertThrows(IllegalArgumentException.class, () -> HoarePartition.partitionTable(new int[2], -1));
    }

    @DisplayName("Should throw exception for pivotIndex exceeding array length")
    @Test
    void shouldThrowExceptionForPivotIndexExceedingArrayLength() {
        assertThrows(IllegalArgumentException.class, () -> HoarePartition.partitionTable(new int[2], 2));
    }
}
