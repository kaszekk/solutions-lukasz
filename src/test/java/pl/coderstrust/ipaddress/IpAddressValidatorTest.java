package pl.coderstrust.ipaddress;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IpAddressValidatorTest {
    @Disabled
    @DisplayName("This test is disabled by default, because takes over 2 hours to complete")
    @Test
    void isIpV4AddressTest() {
        IpAddressValidator ipAddressValidator = new IpAddressValidator();

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

    @ParameterizedTest(name = "{index} => ipTemplate={0}")
    @MethodSource("isIpV4AddressSmartTestParams")
    void isIpV4AddressSmartTest(String ipTemplate) {
        String ipAddressTemplate;
        for (int i = 0; i <= 255; i++) {
            ipAddressTemplate = String.format(ipTemplate, i);
            assertTrue(IpAddressValidator.isIpV4AddressValid(ipAddressTemplate));
        }
    }

    private static Stream<Object> isIpV4AddressSmartTestParams() {
        return Stream.of(
                Arguments.of("1.1.1.%d"),
                Arguments.of("1.1.%d.1"),
                Arguments.of("1.%d.1.1"),
                Arguments.of("%d.1.1.1"));
    }

    @ParameterizedTest(name = "{index} => ipAddress={0}")
    @MethodSource("negativeCasesParams")
    void negativeCasesTest(String ipAddress) {
        assertFalse(IpAddressValidator.isIpV4AddressValid(ipAddress));
    }

    private static Stream<Object> negativeCasesParams() {
        return Stream.of(
                Arguments.of("0000.0.0.0"),
                Arguments.of("-0.0.0.0"),
                Arguments.of("1.2.3.0255"),
                Arguments.of("255.255.255. 1"),
                Arguments.of(".0.0.0"),
                Arguments.of("l.2.3.4"),
                Arguments.of("256.1.1.1"),
                Arguments.of("1.0.-1.1"),
                Arguments.of("%d.1.1.1"));
    }
}
