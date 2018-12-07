package pl.coderstrust.christmas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("ChristmasTree Test")
class ChristmasTreeTest {

    @DisplayName("Should return correct Christmas Tree structure for given size")
    @ParameterizedTest(name = "{index} => size={0}, expected={1}")
    @MethodSource("correctChristmasTreeArguments")
    void shouldReturnCorrectChristmasTree(int size, List<String> expected) {

        // When
        List<String> input = ChristmasTree.getChristmasTree(size);

        // Then
        assertEquals(expected, input);
    }

    private static Stream<Object> correctChristmasTreeArguments() {
        return Stream.of(
                Arguments.of(0,
                        new ArrayList<>(Collections.singletonList("**"))),
                Arguments.of(1,
                        new ArrayList<>(Arrays.asList(
                                (" *"),
                                ("**")))),
                Arguments.of(4,
                        new ArrayList<>(Arrays.asList(
                                ("    *"),
                                ("   ***"),
                                ("  *****"),
                                (" *******"),
                                ("   **")))));
    }

    @DisplayName("Should throw exception for negative size")
    @Test
    void shouldThrowExceptionForInvalidArgument() {
        assertThrows(IllegalArgumentException.class, () -> ChristmasTree.getChristmasTree(-1));
    }
}
