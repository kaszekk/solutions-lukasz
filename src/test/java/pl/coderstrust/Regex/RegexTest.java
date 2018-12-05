package pl.coderstrust.Regex;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RegexTest {

    @org.junit.jupiter.api.Test
    void isIpV4AddressTest() {
        //Given

        Regex regex = new Regex();
        String input = "255.255.255.255";
        //When
        boolean actual = regex.isIpV4Address(input);
        //Then
        assertTrue(actual);
    }
}