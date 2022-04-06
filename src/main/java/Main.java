import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(NumberSystemsConverter.simpleConvertDecimalToHex(9862486));
        System.out.println(NumberSystemsConverter.convertDecimalToHex(9862486));
        System.out.println(NumberSystemsConverter.convert(String.valueOf(9862486), 10, 16) + "\n");

        System.out.println(NumberSystemsConverter.simpleConvertDecimalToBinary(1386));
        System.out.println(NumberSystemsConverter.convertDecimalToBinary(1386));
        System.out.println(NumberSystemsConverter.convert(String.valueOf(1386), 10, 2) + "\n");

        System.out.println(NumberSystemsConverter.simpleConvertBinaryToDecimal(String.valueOf(1011001011)));
        System.out.println(NumberSystemsConverter.convertBinaryToDecimal(1011001011));
        System.out.println(NumberSystemsConverter.convert(String.valueOf(1011001011), 2, 10));

        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите число :");
            long number = sc.nextLong();
            System.out.println("Введите основание его системы счисления :");
            int base = sc.nextInt();
            System.out.println("Выберете, что вы хотите сделать с числом :\n" +
                    "1 - Перевести в двоичную систему счисления\n" +
                    "2 - Перевести в шестнадцатеричную систему счисления\n" +
                    "3 - Перевести в десятичную систему счисления");
            int command = sc.nextInt();
            if (command > 3 || command < 1) {
                throw new IllegalArgumentException("Command error");
            }
            if (base == 10 && command == 1) {
                System.out.println(NumberSystemsConverter.simpleConvertDecimalToBinary((int) number));
            }
            if (base == 10 && command == 2) {
                System.out.println(NumberSystemsConverter.simpleConvertDecimalToHex((int) number));
            }
            if (base == 2 && command == 3) {
                System.out.println(NumberSystemsConverter.simpleConvertBinaryToDecimal(String.valueOf(number)));
            }

            int newBase = (command == 1) ? 2 : (command == 2) ? 16 : 10;
            System.out.println("Проверка : " + NumberSystemsConverter.convert(String.valueOf(number), base, newBase));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}