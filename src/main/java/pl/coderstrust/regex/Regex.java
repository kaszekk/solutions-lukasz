package pl.coderstrust.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Regex {
    private final String REGEX_IP_V4_PATTERN = "\\b((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)(\\.|$)){4}\\b";
    private Pattern pattern = Pattern.compile(REGEX_IP_V4_PATTERN);

    boolean isIpV4Address(String input) {
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
