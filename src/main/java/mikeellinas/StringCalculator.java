package mikeellinas;

import java.util.ArrayList;

public class StringCalculator {

    public static int Add(String numbers) {
        String delimiter = "[,]";  // Default delimiter
        String remainingNumbers = numbers;
        if (numbers.startsWith("//")) {
            // "//[delimiter]\n[numbers…]” for example “//;\n1;2”
            // "//[delimiter]\n” for example: “//[—]\n1—2—3” should return 6"
            int indexOfDelimiterEndingCharacters = numbers.indexOf("\n");
            delimiter = numbers.substring(2, indexOfDelimiterEndingCharacters);
            remainingNumbers = numbers.substring(indexOfDelimiterEndingCharacters + 1);
        }
        return Add(remainingNumbers, delimiter + "|\n");
    }

    public static int Add(String remainingNumbers, String delimiter) {
        int returnValue = 0;
        boolean negativeNumberFound = false;
        ArrayList<Integer> negativeArray = new ArrayList<>();
        String[] numbersArray = remainingNumbers.split(delimiter);
        for (String number : numbersArray) {
            if (number.isEmpty()) return 0;
            Integer parsedNumber = Integer.parseInt(number);
            if (parsedNumber < 0) {
                negativeNumberFound = true;
                negativeArray.add(parsedNumber);
            } else if (parsedNumber < 1000)
                returnValue += parsedNumber;
        }
        if (negativeNumberFound) throw new RuntimeException("Negatives not allowed: " + negativeArray.toString());
        return returnValue;
    }

    public static void main(String[] args) {
        System.out.println(StringCalculator.Add("0"));
    }
}
