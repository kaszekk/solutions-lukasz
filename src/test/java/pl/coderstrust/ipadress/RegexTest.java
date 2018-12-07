package pl.coderstrust.ipadress;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RegexTest {
    @org.junit.jupiter.api.Test
    void isIpV4AddressTest() {
        //Given
        String ipAddressTemplate;
        for (int i = 0; i <= 255; i++) {
            for (int j = 0; j <= 255; j++) {
                for (int k = 0; k <= 255; k++) {
                    for (int l = 0; l <= 255; l++) {
                        ipAddressTemplate = String.format("%d.%d.%d.%d", i, j, k, l);
                        assertTrue(IpAdressValidator.isIpV4AddressValid(ipAddressTemplate));
                    }
                }
            }
        }
    }
}
