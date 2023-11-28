package kuz.lab1;

import java.util.Arrays;

public class StringCalculator {
    public static final String DELIMITER = ",|\n";

    int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String[] splitedNumbers = numbers.split(DELIMITER, -1);
        for (String s: splitedNumbers){
            if (s.isBlank()){
                throw new IllegalArgumentException("Wrong input parameters");
            }
        }

        return Arrays.stream(splitedNumbers)
                .mapToInt(Integer::valueOf)
                .sum();
    }

}