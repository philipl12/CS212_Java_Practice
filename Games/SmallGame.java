import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class SmallGame {
    private static JButton buttons[] = new JButton[9];
    //found array of buttons to be less work than typing adding each button
    private static int amountClicked;
    //corresponds to the total amount of buttons in this game

    public static void gameContents() {
        JFrame frame = new JFrame("Tic-Tac-Toe");

        frame.setLayout(new GridLayout(3, 3, 10, 10));
        frame.setSize(600, 600);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new GameChanger();
            frame.add(buttons[i]);
        }

    }

    public static class GameChanger extends JButton implements ActionListener {
        private static String theChanger;
        private static int[][] realWinners = new int[][] {
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, //vertical wins
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, //horizontal wins
            {0, 4, 8}, {2, 4, 6}			 //diagonal wins
        };
        private static boolean winner = false;
        private int playAgain;

        public GameChanger() {
            super();
            String theChanger = " ";
            int amountClicked = 0;
            setText(theChanger);
            addActionListener(this);

        }

        public void actionPerformed(ActionEvent e) {
            int playAgain = 9001;//not the damn power level, Vegeta
            if ((amountClicked % 2 == 0) && getText().equals(" ")) {
                theChanger = "X";
                amountClicked++;
            }
            else if ((amountClicked % 2 == 1) && getText().equals(" ")) {
                theChanger = "O";
                amountClicked++;
            }
            setText(theChanger);

            for (int i = 0; i < 7; i++) {
                if (!buttons[realWinners[i][0]].getText().equals(" ") &&
                     buttons[realWinners[i][0]].getText().equals(
                     buttons[realWinners[i][1]].getText()) &&
                     buttons[realWinners[i][1]].getText().equals(
                     buttons[realWinners[i][2]].getText())) {
                     //above checks if the buttons match
                     winner = true;
                     }
            }

            if (winner == true) {
                playAgain = JOptionPane.showConfirmDialog (null, theChanger +
                            " won! One more game?", null,
                            JOptionPane.YES_NO_OPTION);
            }
            else if (winner == false && amountClicked == 9) {
                playAgain = JOptionPane.showConfirmDialog (null,
                            "You tied! One more game?", null ,
                            JOptionPane.YES_NO_OPTION);
            }

            if (playAgain == JOptionPane.YES_OPTION) {
                newGameStarter();
                winner = false;
            }
            else if (playAgain == JOptionPane.NO_OPTION) {
                System.exit(0);
            }

        }//end actionPerformed

    }//end GameChanger

    public static void newGameStarter() {
    	for (int i = 0; i < buttons.length; i++) {
    		buttons[i].setText(" ");
        }
    	amountClicked = 0;
    }



    public static void main(String[] args) {
        gameContents();
    }
}
