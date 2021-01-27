package TronGame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MenuBar {

    GameFrame gameArea;
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
        /*highScore.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg) {
                JFrame tableFrame = new JFrame();
                int size = 0;
                try {
                    size = gameArea.getHs().getHighScores().size();
                } catch (SQLException ex) {
                    Logger.getLogger(TronGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                tableFrame.setTitle("High Scores");
                String[] header = {"Name", "Score"};
                String[][] body = new String[size][2];

                try {
                    for (int i = 0; i < size; i++) {
                        body[i][0] = gameArea.getHs().getHighScores().get(i).getName();
                        body[i][1] = Integer.toString(gameArea.getHs().getHighScores().get(i).getScore());
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(TronGUI.class.getName()).log(Level.SEVERE, null, ex);
                }

                //Creation of table and Scroll object
                JTable table = new JTable(body, header);
                JScrollPane sp = new JScrollPane(table);
                tableFrame.add(sp);
                tableFrame.setSize(625, 300);
                tableFrame.setVisible(true);

            }
        });
*/
        highScore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("dataBase");

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
