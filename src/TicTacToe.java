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

    JButton [][] board = new JButton[3][3];
    String playerX = "X";
    String playerO = "O";
    String currentPlayer = playerX;
    boolean gameOver = false;
    int turns = 0;


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

        // adding buttons
        for (int r=0; r<3; r++) {
            for (int c=0; c<3; c++) {
                JButton tile = new JButton();
                board[r][c] = tile;
                boardPanel.add(tile);

                tile.setBackground(Color.darkGray); // set tile bg color
                tile.setForeground(Color.white); // set tile foreground color
                tile.setFont(new Font("Arial", Font.BOLD, 120));
                tile.setFocusable(false);
                // tile.setText(currentPlayer);
                // adds an action listener that generates text when clicked
                tile.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        if (gameOver) {
                            return;
                        }
                        JButton tile = (JButton)e.getSource();
                        if (tile.getText() == "") {
                            tile.setText(currentPlayer);
                            turns++;
                            checkWinner();
                            // alternate the buttons
                            if (!gameOver) {
                                currentPlayer = currentPlayer == playerX ? playerO : playerX;
                                textLabel.setText(currentPlayer + "'s turn.");
                            }
                        }

                    }
                });
            }
        }


    }
    void checkWinner() {
        // horizontal
        for (int r=0; r<3; r++) {
            if (board[r][0].getText() == "") {
                continue;
            } // checks if the text of the first tile is equals to the secon tile
            if (board[r][0].getText() == board[r][1].getText() &&
                board[r][1].getText() == board[r][2].getText()) {
                for (int i=0; i<3; i++) {
                    setWinner(board[r][i]);
                }
                gameOver = true; 
                return;
            }
        }

        // vertical
        for (int c=0; c<3; c++) {
            if (board[0][c].getText() == "") {
                continue;
            }
            if (board[0][c].getText() == board[1][c].getText() &&
                board[1][c].getText() == board[2][c].getText()) {
                for (int i=0; i<3; i++) {
                    setWinner(board[i][c]);
                }
                gameOver = true;
                return;
            }
        }

        // diagonal
        if (board[0][0].getText() == board[1][1].getText() &&
            board[1][1].getText() == board[2][2].getText() &&
            board[0][0].getText() != "") {
            for (int i=0; i<3; i++) {
                setWinner(board[i][i]);
            }
            gameOver = true;
            return;
        }
        
        // anti diagonal
        if (board[0][2].getText() == board[1][1].getText() &&
            board[1][1].getText() == board[2][0].getText() &&
            board[0][2].getText() != "") {
                setWinner(board[0][2]);
                setWinner(board[1][1]);
                setWinner(board[2][0]);
                gameOver = true;
                return;

        }

        if (turns==9) {
            for (int r=0; r<3; r++) {
                for (int c=0; c<3; c++) {
                    setTie(board[r][c]);
                }
            }
            gameOver = true;
        }
    }

    // changes the color of the tiles, bg, fg when theres a winner
    void setWinner(JButton tile) {
        tile.setForeground(Color.green);
        tile.setBackground(Color.gray);
        textLabel.setText(currentPlayer + " is the winner!");
    }

    void setTie(JButton tile) {
        tile.setForeground(Color.orange);
        tile.setBackground(Color.darkGray);
        textLabel.setText("Tie!");
    }
}
