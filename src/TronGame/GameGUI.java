package TronGame;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;

public class GameGUI extends JFrame {
    JLabel L;
    public GameGUI(){
        setTitle("TRON GAME");
        setSize(700,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new BorderLayout());

        setContentPane(new JLabel(new ImageIcon(".\\img\\background.jpg")));
        setLayout(new FlowLayout());
        L=new JLabel();
        add(L);
        setSize(700,700);
    }
}
