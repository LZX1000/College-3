import java.util.Scanner;

public class NumberGuess {
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
            }
        }
    public static void help() {
        System.out.println("Enter 'settings' to change the max number");
        System.out.println("Enter 'quit' to exit the game");
        System.out.println("Enter 'help' to see this message again");
        System.out.println();
    }
    public static void main(String[] args) {
        int max_number = 100;
        int min_number = 0;

        Scanner sc = new Scanner(System.in);

        clearScreen();
        System.out.println("Welcome to Number Guess!");
        System.out.println("Enter 'help' for a list of commands.");
        System.out.println();

        boolean running = true;
        while (running) {
            int hidden_number = (int) (Math.random() * ((max_number - min_number) + 1));
            int tries = 0;
            int default_guess = min_number - 1;

            String message = "";
            int between_max = max_number;
            int between_min = min_number;

            boolean playing = true;
            while (playing) {
                int guess = default_guess;

                try {
                    while (guess != hidden_number) {
                        System.out.println(between_min + " - " + between_max);
                        System.out.println(message + "\n");
                        
                        System.out.println("Enter your guess:");
                        guess = sc.nextInt();
                        tries++;
                        
                        if (guess < hidden_number) {
                            message = "Too low!";
                            
                            if (guess > between_min) {
                                between_min = guess;
                            }
                        } else if (guess > hidden_number) {
                            message = "Too high!";

                            if (guess < between_max) {
                                between_max = guess;
                            }
                        }
                        clearScreen();
                    }
                    System.out.println("Correct! It took you " + tries + " tries.");
                    System.out.println("Play again? (y/n)\n");

                    playing = false;
                } catch (Exception e) {
                    clearScreen();
                    message = "Invalid input";
                    guess = default_guess;
                    sc.next();
                }
            }
            
            boolean choosing = true;
            while (choosing) {
                System.out.print(">> ");
                String cmd = sc.next().toLowerCase();

                switch (cmd) {
                    case "n": {
                        running = false;
                        choosing = false;
                        break;
                    } case "y": {
                        clearScreen();

                        choosing = false;
                        break;
                    } case "quit": {
                        System.out.println("Goodbye!");

                        running = false;
                        choosing = false;
                        break;
                    } case "help": {
                        help();
                        break;
                    } case "settings": {
                        System.out.print("Enter the max number: ");
                        max_number = sc.nextInt();
                        System.out.print("Enter the min number: ");
                        min_number = sc.nextInt();
                        break;
                    }
                    default: {
                        System.out.println("Invalid input.");
                        break;
                    }
                }
            }
        }
        sc.close();
    }
}
