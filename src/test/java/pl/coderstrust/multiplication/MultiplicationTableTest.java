package pl.coderstrust.multiplication;

//import com.sun.javaws.exceptions.InvalidArgumentException;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.fail;
import static org.hamcrest.CoreMatchers.is;


public class MultiplicationTableTest {
    @Test
    public void shouldCalculateMultiplicationTable() {
        // Given
        int size = 0;
        List<String> expected = (Arrays.asList("     \n"));

        // When
        List<String> input = MultiplicationTable.getResult(size);

        // Then
        Assert.assertThat(input, is(expected));
    }

    @Test
    public void whenNegativeSizeShouldCatchIllegalArgumentException() {
        //Given
        int size = -1;
        try {
            List<String> input = MultiplicationTable.getResult(size);
            fail("Expected an InvalidArgumentException to be thrown");
        } catch (IllegalArgumentException ex) {
            Assert.assertThat(ex.getMessage(), is());
        }
