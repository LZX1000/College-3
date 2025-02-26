import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TicTacToe {
    private static boolean checkRow(int row, String player, int grid_size, String[] board) {
        for (int i = 0; i < grid_size; i++) {
            if (!player.equals(board[row * grid_size + i])) {
                return false;
            }
        }

        return true;
    }

    private static boolean checkCollumn(int col, String player, int grid_size, String[] board) {
        for (int i = 0; i < grid_size; i++) {
            if (!player.equals(board[i * grid_size + col])) {
                return false;
            }
        }

        return true;
    }

    private static boolean checkDiaganol(String player, int grid_size, String[] board) {
        boolean left_diaganol = true;
        boolean right_diaganol = true;

        for (int i = 0; i < grid_size; i++) {
            if (!player.equals(board[i * grid_size + i])) {
                left_diaganol = false;
            }

            if (!player.equals(board[i * grid_size + (grid_size - i - 1)])) {
                right_diaganol = false;
            }
        }

        return left_diaganol || right_diaganol;
    }

    private static boolean checkWin(int last_move, String player, int grid_size, String[] board) {
        int row = last_move / grid_size;
        int col = last_move % grid_size;
        
        return checkRow(row, player, grid_size, board) || checkCollumn(col, player, grid_size, board) || checkDiaganol(player, grid_size, board);
    }

    private static boolean checkStalemate(String[] board) {
        for (String s : board) {
            if (s == null) {
                return false;
            }
        }

        return true;
    }

    private static void game(int display_size, JFrame frame) {
        // Must be less than 9
        int grid_size = 3;
        String[] board = new String[grid_size * grid_size];

        final boolean[] player1 = {true};

        // Create a panel and set a grid layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(grid_size, grid_size));
        frame.add(panel);

        // Add buttons to the frame
        for (int i = 0; i < (grid_size * grid_size); i++) {
            JButton button = new JButton();
            button.setFont(new Font("Arial", Font.PLAIN, display_size / grid_size));

            final int j = i;
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (board[j] == null) {
                        board[j] = player1[0] ? "X" : "O";
                        button.setText(board[j]);

                        if (checkWin(j, player1[0] ? "X" : "O", grid_size, board)) {
                            int response = JOptionPane.showConfirmDialog(frame, "Player " + (player1[0] ? "1" : "2") + " wins!" + "\nWould you like to play again?", "Play Again?", JOptionPane.YES_NO_OPTION);

                            if (response == JOptionPane.YES_OPTION) {
                                frame.dispose();
                                main(null);
                            } else {
                                frame.dispose();
                            }
                        } else if (checkStalemate(board)) {
                            int response = JOptionPane.showConfirmDialog(frame, "Stalemate!" + "\nWould you like to play again?", "Play Again?", JOptionPane.YES_NO_OPTION);

                            if (response == JOptionPane.YES_OPTION) {
                                frame.dispose();
                                main(null);
                            } else {
                                frame.dispose();
                            }
                        }

                        player1[0] = !player1[0];
                    }
                }
            });

            panel.add(button);
        }

        // Make the frame visible
        panel.setVisible(true);
    }

    public static void main(String[] args) {
        int display_size = 900;

        // Create the frame
        JFrame frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(display_size, display_size);

        // Set the frame to be visible
        frame.setVisible(true);

        game(display_size, frame);
    }
}