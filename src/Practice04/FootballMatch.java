package ru.mirea.Practice04;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class FootballMatch extends JFrame {
    private int t1 = 0;
    private int t2 = 0;
    private String lastScr = "N/A";
    private String checkWinner = "Draw";

    JButton but1 = new JButton("AC Milan");
    JButton but2 = new JButton("Real Madrid");
    JLabel lbl1 = new JLabel("Result: " + t1 + " X " + t2);
    JLabel lbl2 = new JLabel("Last scorer: " + lastScr);
    Label lbl3 = new Label("Winner: " + checkWinner);

    public FootballMatch() {
        super("AC Milan - Real Madrid");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 350);
        setLayout(null);
        but1.setBounds(10, 130, 90, 25);
        but2.setBounds(350,130, 120, 25);
        lbl1.setBounds(190, 120, 150,30);
        lbl2.setBounds(170, 250, 150,30);
        lbl3.setBounds(180,20,150,30);
        add(but1);
        add(but2);
        add(lbl1);
        add(lbl2);
        add(lbl3);

        setVisible(true);
        but1.addActionListener(new FootballMatch.buttonClickListener1(lbl1, lbl2));
        but2.addActionListener(new FootballMatch.buttonClickListener2(lbl1, lbl2));
    }

    public void checkWin()
    {
        if (t1 > t2)
        {
            checkWinner = "AC Milan";
            lbl3.setText("Winner: " + checkWinner);
        }

        else if (t1 < t2)
        {
            checkWinner = "Real Madrid";
            lbl3.setText("Winner: " + checkWinner);
        }

        else
        {
            checkWinner = "DRAW";
            lbl3.setText("Winner: " + checkWinner);
        }
    }


    private class buttonClickListener1 implements ActionListener{
        private JLabel target1;
        private JLabel target2;
        public buttonClickListener1(JLabel target1, JLabel target2)
        {
            this.target1 = target1;
            this.target2 = target2;
        }

        public void actionPerformed(ActionEvent e)
        {
            lastScr = "AC Milan";
            target2.setText("Last scorer: " + lastScr);
            t1++;
            this.target1.setText("Result: " + t1 + " X " + t2);
            checkWin();
        }

    }

    private class buttonClickListener2 implements ActionListener{
        private JLabel target1;
        private JLabel target2;
        public buttonClickListener2(JLabel target1, JLabel target2)
        {
            this.target1 = target1;
            this.target2 = target2;
        }

        public void actionPerformed(ActionEvent e)
        {
            lastScr = "Real Madrid";
            target2.setText("Last scorer: " + lastScr);
            t2++;
            this.target1.setText("Result: " + t1 + " X " + t2);
            checkWin();
        }

    }

    public static void main(String[] args)
    {
        new FootballMatch();
    }
}