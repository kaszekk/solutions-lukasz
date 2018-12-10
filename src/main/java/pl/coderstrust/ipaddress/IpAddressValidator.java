package pl.coderstrust.ipaddress;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IpAddressValidator {
    private static final String REGEX_IP_V4_PATTERN = "\\b((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)(\\.|$)){4}\\b";
    private static Pattern pattern = Pattern.compile(REGEX_IP_V4_PATTERN);

    static boolean isIpV4AddressValid(String input) {
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
