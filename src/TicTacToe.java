import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 
public class TicTacToe {
    int boardWidth = 600;
    int boardHeight = 600; // 50px for text panel on top

    JFrame frame = new JFrame("Tic-Tac-Toe");
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel boardPanel = new JPanel();


    TicTacToe() {
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null); // opens a window
        frame.setResizable(false); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // closed when x is clicked
        frame.setLayout(new BorderLayout());

        textLabel.setBackground(Color.darkGray); // backgrond color to gray
        textLabel.setForeground(Color.white); // font color to white
        textLabel.setFont(new Font("Arial", Font.BOLD, 50));
        textLabel.setHorizontalAlignment(JLabel.CENTER); // centers text
        textLabel.setText("Tic Tac Toe");
        textLabel.setOpaque(true);

        textPanel.setLayout(new BorderLayout()); 
        textPanel.add(textLabel); // adds label to the panel
        frame.add(textPanel, BorderLayout.NORTH); // moves the text to the top
        boardPanel.setLayout(new GridLayout(3,3)); // creates a grid with 3 rows and 3 columns
        boardPanel.setBackground(Color.darkGray);
        frame.add(boardPanel);


    }
}
