import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TicTacToe {
    public static void main(String[] args) {
        int grid_width = 3;
        int grid_height = 3;

        final boolean[] player1 = {true};

        // Create the frame
        JFrame frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 900);

        // Create a grid layout
        frame.setLayout(new GridLayout(grid_width, grid_height));

        for (int i = 0; i < (grid_width * grid_height); i++) {
            JButton button = new JButton();
            button.setFont(new Font("Arial", Font.PLAIN, 40));
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (player1[0]) {
                        button.setText("X");
                    } else {
                        button.setText("O");
                    }
                    player1[0] = !player1[0];
                }
            });
            frame.add(button);
        }
        // Make the frame visible
        frame.setVisible(true);
    }
}