package pl.coderstrust.ipaddress;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class IpAddressValidatorTest {
    @Disabled
    @Test
    void isIpV4AddressTest() {
        String ipAddressTemplate;
        for (int i = 0; i <= 255; i++) {
            for (int j = 0; j <= 255; j++) {
                for (int k = 0; k <= 255; k++) {
                    for (int l = 0; l <= 255; l++) {
                        ipAddressTemplate = String.format("%d.%d.%d.%d", i, j, k, l);
                        assertTrue(IpAddressValidator.isIpV4AddressValid(ipAddressTemplate));
                    }
                }
            }
        }
    }

    @Test
    void isIpV4AddressSmartTest() {
        String ipAddressTemplate;
        int[] octet = {0, 0, 0, 0};
        for (int i = 0; i <= 3; i++) {
            for (octet[i] = 0; octet[i] < 2; octet[i]++) {
                ipAddressTemplate = String.format("%d.%d.%d.%d", octet[3], octet[2], octet[1], octet[0]);
                assertTrue(IpAddressValidator.isIpV4AddressValid(ipAddressTemplate));
            }

        }
    }
}
