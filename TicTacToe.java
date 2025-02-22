import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TicTacToe {
    public static void main(String[] args) {
        int display_size = 900;

        // Must be less than 9
        int grid_size = 3;

        final boolean[] player1 = {true};

        // Create the frame
        JFrame frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(display_size, display_size);

        // Create a grid layout
        frame.setLayout(new GridLayout(grid_size, grid_size));

        // Add buttons to the frame
        for (int i = 0; i < (grid_size * grid_size); i++) {
            JButton button = new JButton();
            button.setFont(new Font("Arial", Font.PLAIN, display_size / grid_size));
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (!button.getText().equals("X") && !button.getText().equals("O")) {
                        if (player1[0]) {
                            button.setText("X");
                        } else {
                            button.setText("O");
                        }
                        player1[0] = !player1[0];
                    }
                }
            });
            frame.add(button);
        }
        // Make the frame visible
        frame.setVisible(true);
    }
}