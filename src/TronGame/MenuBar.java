package TronGame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBar {


    public MenuBar(JFrame frame ) {
        //menu game
        JMenuBar menuBar = new JMenuBar();

        JMenu Menu = new JMenu("MENU");

        JMenuItem restart = new JMenuItem("restart");
        Menu.add(restart);
        JMenuItem highScore = new JMenuItem("high score");
        Menu.add(highScore);
        JMenuItem exit = new JMenuItem("exit");
        Menu.add(exit);
        menuBar.add(Menu);
        frame.add(menuBar);
        frame.setJMenuBar(menuBar);

        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              new EnterData();
              frame.dispose();
            }
        });
        highScore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });
    }
}