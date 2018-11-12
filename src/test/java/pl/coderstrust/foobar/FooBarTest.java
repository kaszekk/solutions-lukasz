package pl.coderstrust.foobar;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FooBarTest {

    @Test
    public void shouldReturnCorrectFooBarList() {
        // Given
        int size = 6;
        List<String> expected = (Arrays.asList("0FooBar", "1", "2", "3Foo", "4", "5Bar", "6Foo"));

        // When
        List<String> input = FooBar.getResult(size);

        // Then
        assertEquals(expected, input);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldThrowExceptionForInvalidArgument() throws IllegalArgumentException {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Number of lines must be greater or equal to zero");
        FooBar.getResult(-1);
    }
}
