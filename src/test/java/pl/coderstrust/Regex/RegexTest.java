package pl.coderstrust.Regex;

import static java.lang.Math.pow;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RegexTest {

    @org.junit.jupiter.api.Test
    void isIpV4AddressTest() {
        //Given
        final double maxForValue = pow(2, 32) - 1;
        Regex regex = new Regex();
        String input = "011.255.255.255";
        //When
        boolean actual = regex.isIpV4Address(input);
        assertTrue(actual);
     /*   for (long ip = 0; ip <= maxForValue; ip++) {
            //Then
        }*/
    }
}

