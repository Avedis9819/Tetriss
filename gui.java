package Tetris;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class gui extends JComponent implements ActionListener  {

    public void test() {
        //Creating the frame of the GUI
        JFrame frame = new JFrame("Tetris");
        frame.setSize(1000,700);


        //Creating the main panel where the grid is going to be
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.DARK_GRAY);

        //Creating the north and east panels, where game info is going to be kept, and the user can see
        JPanel northPanel = new JPanel();
        JPanel eastPanel  = new JPanel(new FlowLayout());

        //Creating the play, pause, exit buttons that go in the north panel
        JButton playButton = new JButton("Start Game!");
        playButton.setActionCommand("play");
        JButton pauseButton = new JButton("Pause Game");
        pauseButton.setActionCommand("pause");
        JButton exitButton = new JButton("Exit The Program.");
        exitButton.setActionCommand("exit");

        //Adding elements in the east panel
        eastPanel.setPreferredSize(new Dimension(250,100));
        eastPanel.add(new JLabel("Score: 25"), BorderLayout.SOUTH);


        //Creating separate panels, that belong on the east side of the main Panel.
        JPanel eastLabel1 = new JPanel();
        //Setting the size of the first panel, the title of the panel, and finally adding it in the east side of the main panel
        eastLabel1.setPreferredSize(new Dimension(200,80));
        eastLabel1.setBorder(BorderFactory.createTitledBorder("Upcoming Tetrominos"));
        eastPanel.add(eastLabel1, BorderLayout.NORTH);

        //Same operation as the first panel of the east side, however, this is going to be at the bottom, and its going to hav ea different name
        JPanel eastLabel2 = new JPanel();
        eastLabel2.setPreferredSize(new Dimension(200, 80));
        eastLabel2.setBorder(BorderFactory.createTitledBorder("Held Tetrominos"));
        eastPanel.add(eastLabel2, BorderLayout.SOUTH);


        //Adding the buttons in the north Panel
        northPanel.add(playButton);
        northPanel.add(pauseButton);
        northPanel.add(exitButton);
        mainPanel.add(northPanel, BorderLayout.NORTH);

        //Adding the north and east panels in the main panel
        JLabel gameGrid = new JLabel("Game grid comes here", JLabel.CENTER);
        gameGrid.setForeground(Color.white);

        mainPanel.add(gameGrid, JLabel.CENTER);


        mainPanel.add(eastPanel, BorderLayout.EAST);
        JLabel credit = new JLabel("Created by: Avo & Gayane");
        credit.setForeground(Color.WHITE);

        mainPanel.add(credit, BorderLayout.SOUTH);
        //Setting the Actions for the buttons
        exitButton.setActionCommand("exit");
        playButton.addActionListener(this);
        pauseButton.addActionListener(this);


        //Finally creating the frame
//        frame.pack();
        frame.setVisible(true);
        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    //Checks the condition of the buttons, and responds accordingly
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        switch (action) {
            case "play" -> JOptionPane.showMessageDialog(this, "Game has started!");
            case "pause" -> JOptionPane.showMessageDialog(this, "Game Paused!");
            case "exit" -> {
                JOptionPane.showMessageDialog(this, "The game is exiting!");
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        gui g = new gui();
        g.test();
    }
}