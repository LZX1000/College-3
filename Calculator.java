import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Calculator {
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
            }
        }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean running = true;
        while (running) {
            Double number1 = 0.0;
            Double number2 = 0.0;
            char operator = '+';

            boolean recievingInput = true;
            while (recievingInput) {
                System.out.println("Enter math need done: ");
                
                String input = sc.nextLine();
                String[] parts = input.split(" ");

                switch (parts.length) {
                    case 1: {
                        if (input.equalsIgnoreCase("exit")) {
                            System.out.println("Goodbye!");
        
                            running = false;
                        }
                    }
                    case 2: {
                        if (isNumeric(parts[0]) && isNumeric(parts[1])) {
                            number1 = Double.parseDouble(parts[0]);
                            number2 = Double.parseDouble(parts[1]);
        
                            System.out.println("Enter the operator: ");
                            operator = sc.next().charAt(0);
        
                            recievingInput = false;
                            break;
                        }
                    }
                    case 3: {
                        if (parts.length == 3 && isNumeric(parts[0]) && isNumeric(parts[2])) {
                            number1 = Double.parseDouble(parts[0]);
                            number2 = Double.parseDouble(parts[2]);
        
                            operator = parts[1].charAt(0);
        
                            recievingInput = false;
                            break;
                        }
                    }
                    default: {
                        System.out.println("Invalid input.");
                    }
                }
            }
            try {
                ProcessBuilder processBuilder = new ProcessBuilder("python", "-c",
                    String.format("print(eval('%f %c %f'))", number1, operator, number2));
                Process process = processBuilder.start();

                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String result = reader.readLine();
                reader.close();

                System.out.println("Result: " + result);
            }
            catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }
        sc.close();
    }
}