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
    void shouldReturnTrueForAllCombinationsOfIpAddress() {
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

    @ParameterizedTest(name = "{index} => ipAddressTemplate={0}")
    @MethodSource("smartTestForValidIpAddressParams")
    void isIpV4AddressSmartTest(String ipAddressTemplate) {
        for (int i = 0; i <= 255; i++) {
            assertTrue(IpAddressValidator.isIpV4AddressValid(String.format(ipAddressTemplate, i)));
        }
    }

    private static Stream<Object> smartTestForValidIpAddressParams() {
        return Stream.of(
                Arguments.of("1.1.1.%d"),
                Arguments.of("1.1.%d.1"),
                Arguments.of("1.%d.1.1"),
                Arguments.of("%d.1.1.1"));
    }

    @ParameterizedTest(name = "{index} => ipAddress={0}")
    @MethodSource("shouldReturnFalseForInvalidIpAddressesParams")
    void shouldReturnFalseForInvalidIpAddresses(String ipAddress) {
        assertFalse(IpAddressValidator.isIpV4AddressValid(ipAddress));
    }

    private static Stream<Object> shouldReturnFalseForInvalidIpAddressesParams() {
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

    @ParameterizedTest(name = "{index} => ipAddress={0}")
    @MethodSource("shouldReturnTrueForValidIpAddressesParams")
    void shouldReturnTrueForValidIpAddresses(String ipAddress) {
        assertTrue(IpAddressValidator.isIpV4AddressValid(ipAddress));
    }

    private static Stream<Object> shouldReturnTrueForValidIpAddressesParams() {
        return Stream.of(
                Arguments.of("000.0.0.0"),
                Arguments.of("0.1.2.3"),
                Arguments.of("1.2.3.255"),
                Arguments.of("255.255.255.255"),
                Arguments.of("255.0.0.0"),
                Arguments.of("192.168.0.1"),
                Arguments.of("255.1.1.1"));
    }
}
