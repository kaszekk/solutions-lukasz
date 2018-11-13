package pl.coderstrust.multiplication;

import junitparams.Parameters;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

//import org.junit.Test;


public class MultiplicationTableTest {
    @Test
    @Parameters(method = "getExpectedParameters")
    public void shouldCalculateMultiplicationTable(int size, Object expected) {
        // When
        //  List<String> input = MultiplicationTable.getResult(size);
        // Then
        assertEquals(expected, MultiplicationTable.getResult(size));
        // Assert.assertThat(input, is(expected));
    }

    public Object[] getExpectedParameters() {
        return new Object[]{
                new Object[]{0, new ArrayList<>(Arrays.asList(""))},
                new Object[]{1, new ArrayList<>(Arrays.asList("1", "11"))},
                new Object[]{2, new ArrayList<>(Arrays.asList("12", "112", "224"))},
                new Object[]{4, new ArrayList<>(Arrays.asList("1234", "11234", "22468", "336912", "4481216"))}};
    }
}


   /* List<String> strings =
            new ArrayList<String>(Arrays.asList(new String[]{"one", "two", "three"}));*/

  /*  @Test
    @Parameters(method = "named1")
    public void paramsInNamedMethod(String p1, Integer p2) { }
    private Object named1() {
        return new Object[]{"AAA", 1};
    }*/

   /* @Test
    public void whenNegativeSizeShouldCatchIllegalArgumentException() {
        //Given
        int size = -1;
        try {
            List<String> input = MultiplicationTable.getResult(size);
            fail("Expected an InvalidArgumentException to be thrown");
        } catch (IllegalArgumentException ex) {
            Assert.assertThat(ex.getMessage(), is());
        }*/
