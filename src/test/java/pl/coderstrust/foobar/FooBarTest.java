package pl.coderstrust.foobar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("FooBar test ")
class FooBarTest {
    @Test
    @DisplayName("Should return correct Foobar values in List<String>")
    void shouldReturnCorrectFooBarList() {

        // Given
        int size = 6;
        List<String> expected = (Arrays.asList("0FooBar", "1", "2", "3Foo", "4", "5Bar", "6Foo"));

        // When
        List<String> input = FooBar.getResult(size);

        // Then
        assertEquals(expected, input);
    }

    @DisplayName("Should throw exception for negative size")
    @Test
    void shouldThrowExceptionForNegativeSize() {
        assertThrows(IllegalArgumentException.class, () -> FooBar.getResult(-1));
    }
}
