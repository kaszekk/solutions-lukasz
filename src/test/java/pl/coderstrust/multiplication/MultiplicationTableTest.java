package pl.coderstrust.multiplication;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;


public class MultiplicationTableTest {
    @Test
    public void shouldCalculateMultiplicationTable() {
        // Given
        int size = 12;
        ArrayList<String> expected = MultiplicationTableTestPattern.printMultiplicationTableTestPattern(size);

        // When
        MultiplicationTable multiplicationTable = new MultiplicationTable();
        ArrayList<String> input = MultiplicationTable.printMultiplicationTable(size);

        // Then
        Assert.assertEquals(expected, input);
    }
}
