package TronGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnterData {
    private JFrame frame;
    public EnterData () {
        Image info_bgd;//cree noveux image
        info_bgd = new ImageIcon("input_bgd.jpg").getImage();
        //cree noveux frame avec un tittre
        frame = new JFrame("TRON GAME/Enter Data");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new JLabel(new ImageIcon(info_bgd)));
        JButton back_btn =new JButton(new ImageIcon("back_btn.jpg"));
        JButton submit_btn=new JButton(new ImageIcon("play_btn.jpg"));
//label player one
        JLabel label_player_one = new JLabel("ENTER NAME OF FIRST PLAYER: ");
        label_player_one.setBounds(50, 50, 200, 50);
        label_player_one.setSize(205,122);
        label_player_one.setLocation(50,100);
        label_player_one.setForeground(Color.DARK_GRAY);
        label_player_one.setBackground(Color.WHITE);
        frame.getContentPane().add(label_player_one);

//textBox player one
        JTextField Player_One_Name = new JTextField("Player One");
        Player_One_Name.setBounds(50, 50, 200, 50);
        Player_One_Name.setSize(190,30);
        Player_One_Name.setLocation(280,148);
        frame.getContentPane().add(Player_One_Name);
//label player two
        JLabel label_player_Two = new JLabel("ENTER NAME OF SECOND PLAYER: ");
        label_player_Two.setBounds(50, 50, 200, 50);
        label_player_Two.setSize(205,300);
        label_player_Two.setLocation(50,100);
        label_player_Two.setForeground(Color.DARK_GRAY);
        label_player_Two.setBackground(Color.WHITE);
        frame.getContentPane().add(label_player_Two);

//textBox player Two
        JTextField Player_Two_Name = new JTextField("Player Two");
        Player_Two_Name.setBounds(50, 50, 200, 50);
        Player_Two_Name.setSize(190,30);
        Player_Two_Name.setLocation(280,238);
        frame.getContentPane().add(Player_Two_Name);

        String ColorStrings[] = { "BlUE", "YELLOW", "RED", "GREEN" };
        final JComboBox<String> ColorList1 = new JComboBox <String> (ColorStrings);
        ColorList1.setSize(190,30);
        ColorList1.setLocation(600,148);
        frame.getContentPane().add(ColorList1);
        final JComboBox<String> ColorList2 = new JComboBox <String> (ColorStrings);
        //ColorList.setMaximumSize(ColorList.getPreferredSize()); // added code
        //ColorList.setAlignmentX(Component.CENTER_ALIGNMENT);// added code
        //ColorList.setSelectedIndex(4);
        //ColorList.addActionListener((ActionListener) this);
        ColorList2.setSize(190,30);
        ColorList2.setLocation(600,238);
        frame.getContentPane().add(ColorList2);

//back button show up to go back
        back_btn.setSize(180,70);
        back_btn.setLocation(800,0);
        frame.getContentPane().add(back_btn);

        //submit button show up to submit the input data
        submit_btn.setSize(180,70);
        submit_btn.setLocation(400,400);
        frame.getContentPane().add(submit_btn);

        back_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameGUI gm = new GameGUI();
                frame.dispose();
            }
        });

        submit_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GameFrame();
                System.out.println("submit");
            }
        });

        frame.setPreferredSize(new Dimension(1000,600));
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }
}
