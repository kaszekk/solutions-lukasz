package pl.coderstrust.foobar;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class FooBarTest {
    @Test
    public void shouldStoreFoobarOutputStringToArrayList() {
        FooBarTestPattern testPattern = new FooBarTestPattern();

        // Given
        ArrayList<String> expected = testPattern.generate();

        // When
        ArrayList<String> input = FooBar.foobar();

        // Then
        Assert.assertEquals(expected, input);
    }
}
