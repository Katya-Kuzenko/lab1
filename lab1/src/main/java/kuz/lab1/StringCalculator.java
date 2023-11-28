package kuz.lab1;

import java.util.Arrays;

public class StringCalculator {
    public static final String DELIMITER = ",|\n";
    public static final String DELIMITER_PREFIX = "//";

    int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String delimiter = DELIMITER;
        String numbers = input;
        if (input.startsWith(DELIMITER_PREFIX)) {
            delimiter = input.substring(DELIMITER_PREFIX.length(), DELIMITER_PREFIX.length() + 1);
            numbers = input.substring(input.indexOf("\n") + 1);
        }

        String[] splitedNumbers = numbers.split(delimiter, -1);
        validateNotEmptyNumbers(splitedNumbers);

        return Arrays.stream(splitedNumbers)
                .mapToInt(Integer::valueOf)
                .sum();
    }

    private void validateNotEmptyNumbers(String[] splitedNumbers) {
        for (String s : splitedNumbers) {
            if (s.isBlank()) {
                throw new IllegalArgumentException("Wrong input parameters");
            }
        }
    }
}
