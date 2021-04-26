package Tetris.Tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class IntroPage extends JFrame implements ActionListener {
    private ImageIcon icon;
    private ImageIcon introPic;
    private JLabel tetrisLogoLabel;
    private JButton startButton;

    IntroPage() {
        introPic = new ImageIcon(".//Images//tIcon.png");
        icon = new ImageIcon(".//Images//tetris.png");
        tetrisLogoLabel = new JLabel(introPic);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Tetris");
        this.setBackground(new Color(0x123456));
        this.setIconImage(icon.getImage());
        this.setSize(800,600);
        this.setResizable(false);
        this.add(tetrisLogoLabel, BorderLayout.CENTER);
        this.setLocationRelativeTo(null);

        startButton = new JButton("Start Game!");
        startButton.setActionCommand("start");
        startButton.addActionListener(this);

        this.add(startButton, BorderLayout.SOUTH);


        this.setVisible(true);
//        tetrisLogo = new ImageIcon(".//Images//tetris.png");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String startButton = this.startButton.getActionCommand();
        if(e.getActionCommand().equals(startButton)) {
            new GameWithG();
            this.dispose();
        }
    }
}
