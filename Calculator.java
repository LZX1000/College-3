import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

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

        while (true) {
            Double number1;
            Double number2;
            char operator;

            while (true) {
                System.out.println("Enter math need done: ");
                
                String input = sc.nextLine();
                String[] parts = input.split(" ");

                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("Goodbye!");

                    sc.close();
                    return;
                } else if (parts.length == 2 && isNumeric(parts[0]) && isNumeric(parts[1])) {
                    boolean operatorExists = false;

                    if (isNumeric(parts[parts.length-1])) {
                        number1 = Double.parseDouble(parts[0]);
                    } else {
                        String[] subArray = Arrays.copyOfRange(parts, 0, parts.length - 1);
                        String joinedString = String.join("", subArray);
                        number1 = Double.parseDouble(joinedString);
                        try {
                            operator = parts[parts.length-1].charAt(0);
                            operatorExists = true;
                        } catch (Exception e) {
                            continue;
                        }
                    }

                    if (isNumeric(parts[0])) {
                        number2 = Double.parseDouble(parts[1]);
                    } else {
                        String[] subArray = Arrays.copyOfRange(parts, 1, parts.length);
                        String joinedString = String.join("", subArray);
                        number2 = Double.parseDouble(joinedString);
                        try {
                            operator = parts[0].charAt(0);
                            operatorExists = true;
                        } catch (Exception e) {
                            continue;
                        }
                    }
                    
                    if (!operatorExists) {
                        System.out.println("Enter the operator: ");
                        operator = sc.next().charAt(0);
                    }

                    break;
                } else if (parts.length == 3 && isNumeric(parts[0]) && isNumeric(parts[2])) {
                    number1 = Double.parseDouble(parts[0]);
                    number2 = Double.parseDouble(parts[2]);

                    operator = parts[1].charAt(0);

                    break;
                } else {
                    System.out.println("Invalid input.");
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
    }
}