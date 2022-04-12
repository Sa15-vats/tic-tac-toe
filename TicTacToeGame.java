package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;

class TicTacToeGame extends JFrame implements ActionListener {
    int k = 0;
    int count = 0;
    int l;
    JButton[] btn = new JButton[9];
    JButton restart;
    JTextField text;

    public TicTacToeGame(String s) {
        super(s);
    }

    public void showComponent() {
        btn[0] = new JButton("");
        btn[0].setBounds(13, 13, 90, 90);
        add(btn[0]);
        btn[1] = new JButton("");
        btn[1].setBounds(110, 13, 90, 90);
        add(btn[1]);
        btn[2] = new JButton("");
        btn[2].setBounds(207, 13, 90, 90);
        add(btn[2]);
        btn[3] = new JButton("");
        btn[3].setBounds(13, 110, 90, 90);
        add(btn[3]);
        btn[4] = new JButton("");
        btn[4].setBounds(110, 110, 90, 90);
        add(btn[4]);
        btn[5] = new JButton("");
        btn[5].setBounds(207, 110, 90, 90);
        add(btn[5]);
        btn[6] = new JButton("");
        btn[6].setBounds(13, 207, 90, 90);
        add(btn[6]);
        btn[7] = new JButton("");
        btn[7].setBounds(110, 207, 90, 90);
        add(btn[7]);
        btn[8] = new JButton("");
        btn[8].setBounds(207, 207, 90, 90);
        add(btn[8]);
        restart = new JButton("Start New Game");
        restart.setBounds(90, 320, 130, 30);
        add(restart);
        text = new JTextField();
        text.setBackground(Color.black);
        text.setBounds(20, 370, 250, 30);
        text.setEditable(false);
        add(text);
        for (int i = 0; i < 9; i++) {
            btn[i] = new JButton();
            btn[i].addActionListener(this::actionPerformed);
        }
        restart.addActionListener(new Reset());
    }

    void detail() {
        for (int i = 0; i < 9; i++) {
            btn[i].setEnabled(false);
        }
    }

    public int check() {
        count++;
        if (btn[0].getText() == "X" && btn[1].getText() == "X" && btn[2].getText() == "X")
            return 1;
        else if (btn[0].getText() == "X" && btn[4].getText() == "X" && btn[8].getText() == "X")
            return 1;
        else if (btn[0].getText() == "X" && btn[3].getText() == "X" && btn[6].getText() == "X")
            return 1;
        else if (btn[1].getText() == "X" && btn[4].getText() == "X" && btn[7].getText() == "X")
            return 1;
        else if (btn[2].getText() == "X" && btn[5].getText() == "X" && btn[8].getText() == "X")
            return 1;
        else if (btn[2].getText() == "X" && btn[4].getText() == "X" && btn[6].getText() == "X")
            return 1;
        else if (btn[3].getText() == "X" && btn[4].getText() == "X" && btn[5].getText() == "X")
            return 1;
        else if (btn[6].getText() == "X" && btn[7].getText() == "X" && btn[8].getText() == "X")
            return 1;


        if (btn[0].getText() == "O" && btn[1].getText() == "O" && btn[2].getText() == "O")
            return 2;
        else if (btn[0].getText() == "O" && btn[4].getText() == "O" && btn[8].getText() == "O")
            return 2;
        else if (btn[0].getText() == "O" && btn[3].getText() == "O" && btn[6].getText() == "O")
            return 2;
        else if (btn[1].getText() == "O" && btn[4].getText() == "O" && btn[7].getText() == "O")
            return 2;
        else if (btn[2].getText() == "O" && btn[5].getText() == "O" && btn[8].getText() == "O")
            return 2;
        else if (btn[2].getText() == "O" && btn[4].getText() == "O" && btn[6].getText() == "O")
            return 2;
        else if (btn[3].getText() == "O" && btn[4].getText() == "O" && btn[5].getText() == "O")
            return 2;
        else if (btn[6].getText() == "O" && btn[7].getText() == "O" && btn[8].getText() == "O")
            return 2;
        else {
            if (count == 9)
                text.setText("Game Draw");
            return 3;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (k == 0) {
            for (int i = 0; i < 9; i++) {
                btn[i].setText("X");
                btn[i].setEnabled(false);
                continue;
            }
                l = check();
                k = 1;
                if (l == 1) {
                    text.setText("Player 1 Won");
                    detail();
                } else if (l == 2) {
                    text.setText("Player 2 Won");
                    detail();
                } else ;
            }
         else {
            for (int i = 0; i < 9; i++) {
                btn[i].setText("O");
                btn[i].setEnabled(false);
                continue;
            }
                k = 0;
                if (l == 1) {
                    text.setText("Player 1 Won");
                    detail();
                } else if (l == 2) {
                    text.setText("Player 2 Won");
                    detail();
                } else ;

            }
        }


    class Reset implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            k = 0;
            l = 0;
            count = 0;
            for (int i = 0; i < 9; i++) {
                btn[i].setText(" ");
                btn[i].setEnabled(true);
            }
        }
    }


    public static void main(String[] args) {
        TicTacToeGame frame = new TicTacToeGame("Tic Tac Toe");
        frame.setVisible(true);
        frame.setSize(325, 450);
        frame.setLocation(100, 100);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.showComponent();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}