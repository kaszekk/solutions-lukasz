package pl.coderstrust.numbersfromfile;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class NumbersProcessor {
    private Pattern pattern = Pattern.compile("([0-9]*\\)*\\(*\\s*)+");

    String processLine(String line) {
        if (isLineValid(line)) {
            StringBuilder processedLineBuilder = new StringBuilder();
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
            return processedLineBuilder.toString();
        } else {
            return "";
        }
    }

    private boolean isLineValid(String line) {
        if (line == null || line.equals("")) {
            return false;
        } else {
            Matcher matcher = pattern.matcher(line);
            return matcher.matches();
        }
    }
}
