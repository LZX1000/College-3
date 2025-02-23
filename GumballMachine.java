import java.util.Scanner;

public class GumballMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] colors = {"Berry-Blue", "Apple-Green","Banana-Yellow", "Cherry-Red", "Clementine-Orange", "Coal"};

        while (true) {
            System.out.println("Enter a smiley face to play or 'exit' to quit: ");
            String response = sc.nextLine();

            if (response.equals(":)") || response.equals("(:")) {
                int random_color = (int) (Math.random() * colors.length);

                if (colors[random_color].equals("Coal")) {
                    System.out.println("The elves ransaked your collection and stole all your gumballs!");
                } else {
                    System.out.println("Congratulations! You got a " + colors[random_color] + " gumball!");
                }
            } else if (response.toLowerCase().equals("exit")) {
                System.out.println("Goodbye!");
                break;
            }
        }
        sc.close();
    }
}