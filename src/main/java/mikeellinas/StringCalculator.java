package mikeellinas;

public class StringCalculator {

    public static int Add(String numbers) {
        int returnValue = 0;
        String[] numbersArray = numbers.split(",|\n");
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
