package kuz.lab1;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class StringCalculator {
    public static final String DELIMITER = ",|\n";
    public static final String DELIMITER_PREFIX = "//";
    public static final int NUMBERS_UPPER_LIMIT = 1000;
    public static final String DELIMITER_OPEN_WITH = "[";
    public static final String DELIMITER_CLOSE_WITH = "]";
    int add(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String delimiter = DELIMITER;
        String numbersText = input;
        if (input.startsWith(DELIMITER_PREFIX)) {
            String[] delimiters = StringUtils.substringsBetween(input, DELIMITER_OPEN_WITH, DELIMITER_CLOSE_WITH);
            delimiter = String.join("|", delimiters);
            numbersText = StringUtils.substringAfter(input, "\n");
        }

        String[] splitedTextNumbers = numbersText.split(backslashMetaCharacter(delimiter), -1);
        validateNotEmptyNumbers(splitedTextNumbers);

        int[] numbers = Arrays.stream(splitedTextNumbers)
                .mapToInt(Integer::valueOf)
                .toArray();

        validateNotNegativeNumbers(numbers);

        return Arrays.stream(numbers)
                .filter(el -> el <= NUMBERS_UPPER_LIMIT)
                .sum();
    }

    private void validateNotEmptyNumbers(String[] splitedNumbers) {
        for (String s : splitedNumbers) {
            if (s.isBlank()) {
                throw new IllegalArgumentException("Wrong input parameters");
            }
        }
    }

    private void validateNotNegativeNumbers(int[] numbers) {
        int[] negativeNumbers = Arrays.stream(numbers)
                .filter(el -> el < 0)
                .toArray();
        if (negativeNumbers.length != 0) {
            throw new IllegalArgumentException("Negative numbers not allowed: " + Arrays.toString(negativeNumbers));
        }
    }

    private String backslashMetaCharacter(String str) {
        return StringUtils.replaceEach(str, new String[]{"*", "+", "?", "^", "$"}, new String[]{"\\*", "\\+", "\\?", "\\^", "\\$"});
    }
}
