package kuz.lab1;

import java.util.Arrays;

public class StringCalculator {


    int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        return Arrays.stream(numbers.split(","))
                .mapToInt(Integer::valueOf)
                .sum();


    }

}