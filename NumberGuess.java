import java.util.Scanner;

public class NumberGuess {
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

        Extras.clearScreen();
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

            boolean victory = false;

            while (between_max - between_min > 1) {
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
                        Extras.clearScreen();
                    }
                    message = "Correct! It took you " + tries + " tries.";
                    victory = true;

                    break;
                } catch (Exception e) {
                   Extras.clearScreen();
                    message = "Invalid input";
                    guess = default_guess;
                    sc.next();
                }
            }
            if (!victory) {
                message = "You lose! The number was " + hidden_number + ".";
            }

            boolean choosing = true;
            while (choosing) {
                Extras.clearScreen();
                System.out.println(message);
                System.out.println("Play again? (y/n)\n");
                System.out.print(">> ");
                String cmd = sc.next().toLowerCase();

                switch (cmd) {
                    case "n": {
                        running = false;
                        choosing = false;
                        break;
                    } case "y": {
                        Extras.clearScreen();

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
