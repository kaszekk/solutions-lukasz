package pl.coderstrust.ipadress;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class IpAddressValidator {
    private static final String REGEX_IP_V4_PATTERN = "\\b((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)(\\.|$)){4}\\b";
    private static Pattern pattern = Pattern.compile(REGEX_IP_V4_PATTERN);

    static boolean isIpV4AddressValid(String input) {
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
/*
public class NumbersProcessor {
    public static final String REGEX_PATTERN_FOR_INTS_SEPARATED_BY_WHITE_CHARS = "([0-9]*\\)*\\(*\\s*)+";

    String processLine(String line) {
        Pattern pattern = Pattern.compile(REGEX_PATTERN_FOR_INTS_SEPARATED_BY_WHITE_CHARS);
        Matcher matcher = pattern.matcher(line);
        StringBuilder processedLineBuilder = new StringBuilder();
        if (matcher.matches()) {
            Scanner scanner = new Scanner(line);
            int sum = 0;
            while (scanner.hasNextInt()) {
                int intValue = scanner.nextInt();
                processedLineBuilder.append(intValue);
                sum += intValue;
                if (scanner.hasNextInt()) {
                    processedLineBuilder.append("+");
                } else {
                    processedLineBuilder.append("=");
                    processedLineBuilder.append(sum);
                }
            }
            scanner.close();
        } else {
            return "";
        }
        return processedLineBuilder.toString();
    }
}
//////////  co jesli liczba > maxint ??*/
