package pl.coderstrust.foobar;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class FooBarTest {

    @Test
    public void shouldReturnCorrectFooBarList() {
        // Given
        int size = 6;
        List<String> expected = (Arrays.asList("0FooBar\n", "1\n", "2\n", "3Foo\n", "4\n", "5Bar\n", "6Foo\n"));

        // When
        List<String> input = FooBar.getResult(size);

        // Then
        assertEquals(expected, input);
    }

    @Test
    public void whenSizeNegativeShouldThrowIllegalArgumentException() {
        // Given
        int size = -1;
        String expected = "Number of lines must be greater or equal to zero";

        // When
        try {
            FooBar.getResult(size);
        } catch (IllegalArgumentException ex) {
            // Then
            assertThat(ex.getMessage(), is(expected));
        }
    }
}
