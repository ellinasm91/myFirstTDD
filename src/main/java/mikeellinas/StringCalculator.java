package mikeellinas;

public class StringCalculator {

    public static int Add(String numbers) {
        String delimiter = ",";  // Default delimiter
        String remainingNumbers = numbers;
        if (numbers.startsWith("//")) {
            // "//[delimiter]\n[numbers…]” for example “//;\n1;2”
            delimiter = numbers.substring(2, 3);
            remainingNumbers = numbers.substring(4);
        }
        return Add(remainingNumbers, delimiter+"|\n");
    }

    public static int Add(String remainingNumbers, String delimiter) {
        int returnValue = 0;
        String[] numbersArray = remainingNumbers.split(delimiter);
        for (String number : numbersArray) {
            if (number.isEmpty()) return 0;
            returnValue += Integer.parseInt(number);
        }
        return returnValue;
    }

    public static void main(String[] args) {
        System.out.println(StringCalculator.Add("0"));
    }
}
