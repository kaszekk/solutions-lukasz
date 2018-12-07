package pl.coderstrust.Regex;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RegexTest {
    StringBuilder ip = new StringBuilder();

    @org.junit.jupiter.api.Test
    void isIpV4AddressTest() {
        //Given
        Regex regex = new Regex();

        for (int firstOctet = 0; firstOctet <= 255; firstOctet++) {
            ip.append(String.format("%03d", firstOctet)).append(".");
            for (int secondOctet = 0; secondOctet <= 255; secondOctet++) {
                ip.append(String.format("%03d", secondOctet)).append(".");
                for (int thirdOctet = 0; thirdOctet <= 255; thirdOctet++) {
                    ip.append(String.format("%03d", thirdOctet)).append(".");
                    for (int forthOctet = 0; forthOctet <= 255; forthOctet++) {
                        if (forthOctet < 10) {
                            ip.append(00).append(forthOctet);
                        } else if (forthOctet < 100) {
                            ip.append(0).append(forthOctet);
                        } else {
                            ip.append(forthOctet);
                        }
                        boolean actual = regex.isIpV4Address(ip.toString());
                        assertTrue(actual);
                        ip.delete(12, 15);
                    }
                    ip.delete(8, 15);
                }
                ip.delete(4, 15);
            }
            ip.delete(0, 15);
        }
    }
}
