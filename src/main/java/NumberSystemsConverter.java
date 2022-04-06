import java.util.function.UnaryOperator;

public class NumberSystemsConverter {
    public static String convertDecimalToHex(int decimalNumber) {
        return Integer.toHexString(decimalNumber).toUpperCase();
    }

    public static String convertDecimalToBinary(int decimalNumber) {
        return Integer.toBinaryString(decimalNumber);
    }

    public static int convertBinaryToDecimal(int binaryNumber) {
        return Integer.parseInt(String.valueOf(binaryNumber), 2);
    }

    public static String convert(String number, int base, int newBase) {
        return Long.toString(Long.parseLong(number, base), newBase).toUpperCase();
    }

    public static int simpleConvertBinaryToDecimal(String binaryNumber) {
        int result = 0;
        for (int i = 0; i < binaryNumber.length(); ++i) {
            result <<= 1;
            if (binaryNumber.charAt(i) == '1') {
                ++result;
            }
        }
        return result;
    }

    public static String simpleConvertDecimalToBinary(int decimalNumber) {
        return simpleConvertDecimalToNewBase(decimalNumber, 2, (value) -> value);
    }

    public static String simpleConvertDecimalToHex(int decimalNumber) {
        return simpleConvertDecimalToNewBase(decimalNumber, 16, (value) -> {
            switch (value) {
                case "10":
                    value = "A";
                    break;
                case "11":
                    value = "B";
                    break;
                case "12":
                    value = "C";
                    break;
                case "13":
                    value = "D";
                    break;
                case "14":
                    value = "E";
                    break;
                case "15":
                    value = "F";
                    break;
            }
            return value;
        });
    }

    private static String simpleConvertDecimalToNewBase(int decimalNumber, int newBase, UnaryOperator<String> transitionNewDegrees) {
        StringBuilder resultNumber = new StringBuilder();
        while (decimalNumber != 0) {
            int currentRemains = decimalNumber % newBase;
            decimalNumber /= newBase;
            resultNumber.append(transitionNewDegrees.apply(String.valueOf(currentRemains)));
        }
        return resultNumber.reverse().toString();
    }
}
