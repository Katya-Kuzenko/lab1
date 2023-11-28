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
        String numbersText = input;
        if (input.startsWith(DELIMITER_PREFIX)) {
            delimiter = input.substring(DELIMITER_PREFIX.length(), DELIMITER_PREFIX.length() + 1);
            numbersText = input.substring(input.indexOf("\n") + 1);
        }

        String[] splitedTextNumbers = numbersText.split(delimiter, -1);
        validateNotEmptyNumbers(splitedTextNumbers);

        int[] numbers = Arrays.stream(splitedTextNumbers)
                .mapToInt(Integer::valueOf)
                .toArray();
        validateNotNegativeNumbers(numbers);

        return Arrays.stream(numbers).sum();
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
}
