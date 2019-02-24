package currencySimpleCalculator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class CurrencyCalculator {

    public static void main(String[] args) throws IOException {

        double amount = 100.00; // 100.00 PLN
        String currencyCode;
        Scanner scanner = new Scanner(System.in);
        int input;
        boolean repeat = true;

        AverageRate.showActualAverageValuesUsaEurGbpChf();
        System.out.println();


        do {
            try {

                System.out.println("***********************************************************");
                System.out.println("To check how much can you buy today fot 100 PLN - enter 1");
                System.out.println("To compare today with last month currency value - enter 2");
                System.out.println("Enter - 3 - to end session");
                input = scanner.nextInt();

                if (input == 1) {
                    count();
                    repeat = true;
                } else if (input == 2) {

                    compare();
                    repeat = true;
                } else if (input == 3) repeat = false;
                else throw new InputMismatchException();

            } catch (InputMismatchException inputMismatchException){
            System.out.printf("%nException: %s%n", inputMismatchException);
            scanner.nextLine();
            System.out.printf(
                    "You must enter integer: 1, 2 or 3. Please try again.%n%n");
            }

        } while (repeat);

        System.out.println("The end");
    }


    public static void compare() {
        System.out.println("***********************************************************");
        System.out.println("Input currency code which would you like to compare whit the last month:");
        Scanner scanner = new Scanner(System.in);
        String currencyCode = scanner.nextLine().toUpperCase();

        try {
            LastMonth.compareRate(currencyCode, 100);
        } catch (IOException e) {
            System.out.println("System can not connect with external sources.");
            System.out.println("Check if your input has correct currency code");
        }
    }

    public static void count() {
        System.out.println("***********************************************************");
        System.out.println("Enter currency symbol [USD, EUR, GBP, CHF]");

        Scanner scanner = new Scanner(System.in);
        String currencyCode = scanner.nextLine().toUpperCase();

        try {
            TodaySaleRate.showHowMuchIsWorth100zlToday(currencyCode, 100);
        } catch (IOException e) {
            System.out.println("System can not connect with external sources.");
            System.out.println("Check if your input has correct currency code");
        }
    }

}









