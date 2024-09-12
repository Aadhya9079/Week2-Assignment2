/***
 * Problem Statement :
   Task 1 - Write a Java program that takes a string as input and calculates the number of unique combinations where a
            palindrome is formed.
   Task 2 - Write a Java program to print the nth number in the Fibonacci series without using loops.
   Task 3 - Write a Java program where the user inputs a string in snake_case. If the string is not in snake_case,
            first convert it to snake_case, and then to camelCase.
   Task 4 - Write a Java program that takes a string as input and finds the number of consonants in the string.
   Task 5 - Write a Java program that takes an integer in binary format and converts it to its decimal representation.
 * Owner Name : Aadhya Goyal
 * Date of Creation : 11-09-24 - 13-09-24
 */

import java.util.Scanner;

public class Week2_Assignment2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(Constant2.AvailableOperations);
            System.out.print(Constant2.ExecutionMessage);
            String operation = scanner.nextLine();

            switch (operation) {
                case "2":
                    System.out.print(Constant2.InputMessage);
                    int input = scanner.nextInt();
                    System.out.println("Fibonacci number at position " + input + " is: " + fibonacci(input));
                     break;

                case "3":
                    System.out.print("Enter a String :");
                    String inputString = scanner.next();
                    String snakeCaseString = SnakeCase(inputString);
                    System.out.println("Snake_case is: " + snakeCaseString);
                    String camelCaseString = CamelCase(snakeCaseString);
                    System.out.println("CamelCase is: " + camelCaseString);
                     break;

                case "4":
                    System.out.println("Enter a string:");
                    String Inputstring = scanner.nextLine();
                    int ConsonantCount = CountWords(Inputstring, 0);
                    System.out.println("Number of consonants: " + ConsonantCount);
                     break;

                case "5" :
                    System.out.print("Enter a digit (Example - 1101):");
                    String inputDigit = scanner.next();
                    int decimal = binaryToDecimal(inputDigit);
                    System.out.println(decimal);
                    break;

                default:
                    System.out.println(Constant2.InvalidMessage);
                    break;
            }

            System.out.print(Constant2.YesOrNoMessage);
            String cont = scanner.nextLine();
            if (!cont.equals("yes")) {
                break;
            }
        }
    }

        //Method Nth fibonacci
        public static int fibonacci ( int input){
            if (input <= 0) {
                return 0;
            }
            else if (input == 1) {
                return 1;
            }
            else {
                return fibonacci(input - 1) + fibonacci(input - 2);
            }
        }

        //Method SnakeCase
        private static String SnakeCase (String str){
            return toSnakeCase(str, 0, new StringBuilder()).toString();
        }

        private static StringBuilder toSnakeCase (String str,int index, StringBuilder result){
            if (index == str.length()) {
                return result;
            }
            char currentChar = str.charAt(index);

            if (Character.isUpperCase(currentChar)) {
                if (result.length() > 0) {
                    result.append('_');
                }
                result.append(Character.toLowerCase(currentChar));
            }
            else if (currentChar == ' ' || currentChar == '-') {
                result.append('_');
            }
            else {
                result.append(currentChar);
            }
            return toSnakeCase(str, index + 1, result);
        }

        // Method snake_case to camelCase
        private static String CamelCase (String snakeCaseStr){
            return toCamelCase(snakeCaseStr, 0, new StringBuilder()).toString();
        }

        private static StringBuilder toCamelCase (String str,int index, StringBuilder result){
            if (index == str.length()) {
                return result;
            }

            char currentChar = str.charAt(index);

            if (currentChar == '_') {
                if (index + 1 < str.length()) {
                    result.append(Character.toUpperCase(str.charAt(index + 1)));
                    return toCamelCase(str, index + 2, result);
                }
            }
            else {
                if (index == 0) {
                    result.append(Character.toLowerCase(currentChar));
                }
                else {
                    result.append(currentChar);
                }
            }
            return toCamelCase(str, index + 1, result);
        }

        //Method Count Consonants
        public static int CountWords (String str,int index){
            if (index == str.length()) {
                return 0;
            }
            char currentChar = str.charAt(index);
            boolean isConsonant = isConsonant(currentChar);
            return (isConsonant ? 1 : 0) + CountWords(str, index + 1);
        }
        private static boolean isConsonant ( char ch){
            ch = Character.toLowerCase(ch);
            return  (ch >= 'a' && ch <= 'z') && !(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
        }

        //Method Binary To Decimal
        public static int binaryToDecimal(String binaryStr) {
            return binaryToDecimal(binaryStr, 0);
        }

        private static int binaryToDecimal(String binaryStr, int exponent) {
        if (binaryStr.isEmpty()) {
            return 0;
        }
        else {
            char digit = binaryStr.charAt(binaryStr.length() - 1);
            int decimalDigit = (digit == '0') ? 0 : 1;
            int decimalValue = decimalDigit * power(2, exponent);
            return decimalValue + binaryToDecimal(binaryStr.substring(0, binaryStr.length() - 1), exponent + 1);
        }
    }
        private static int power(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        else {
            return base * power(base, exponent - 1);
        }
    }
}