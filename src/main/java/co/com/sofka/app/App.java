package co.com.sofka.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import co.com.sofka.app.calculator.BasicCalculator;

public class App {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        BasicCalculator calculator = new BasicCalculator();
        int selectedOperation = 0;
        Long number1 = null;
        Long number2 = null;
        Long result = null;

        System.out.println("Welcome to Calculator");
        System.out.println("--------------------------");

        while (selectedOperation != 5) {
            selectedOperation = welcomeMenu(selectedOperation);

            if (selectedOperation > 0 && selectedOperation < 5) {
                List<Long> numbers = joinNumbers();
                number1 = numbers.get(0);
                number2 = numbers.get(1);

                try {
                    switch (selectedOperation) {
                        case 1:
                            result = calculator.sum(number1, number2);
                            break;
                        case 2:
                            result = calculator.rest(number1, number2);
                            break;
                        case 3:
                            result = calculator.multiply(number1, number2);
                            break;
                        default:
                            result = calculator.division(number1, number2);
                            break;
                    }

                    selectedOperation = 0;
                    System.out.println(number1 + " + " + number2 + " = " + result);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Please join the numbers again");
                }
            } else if (selectedOperation < 0 || selectedOperation > 5) {
                selectedOperation = 0;
                System.out.println("Yo must select a valid operation");
            }
        }

        System.out.println("Goodbye!");
    }

    private static int welcomeMenu(int selectedOperation) throws IOException {
        while (selectedOperation == 0) {
            System.out.println("Please select the operation to do");
            System.out.println("1. Sum");
            System.out.println("2. Substract");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");

            System.out.println("Enter the selected operation: ");

            try {
                selectedOperation = Integer.parseInt(bufferedReader.readLine());
            } catch (NumberFormatException e) {
                selectedOperation = 0;
                System.out.println("You must join a number of option");
            }
        }

        return selectedOperation;
    }

    private static List<Long> joinNumbers() throws IOException {
        boolean ready = true;
        Long number1 = null;
        Long number2 = null;

        while (ready) {
            try {
                System.out.println("Enter number 1: ");
                number1 = Long.valueOf(bufferedReader.readLine());
        
                System.out.println("Enter number 2: ");
                number2 = Long.valueOf(bufferedReader.readLine());

                ready = false;
            } catch (NumberFormatException e) {
                ready = true;
                System.out.println("The value that you entered is not a number");
            }
        }

        return List.of(number1, number2);
    }
}
