package pl.coderstrust.numbersfromfile;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumbersProcessor {
    public static final String REGEX_PATTERN_FOR_INTS_SEPARATED_BY_WHITE_CHARS = "([0-9]*\\)*\\(*\\s*)+";

    public String processLine(String line) {
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
//////////  co jesli liczba > maxint ??