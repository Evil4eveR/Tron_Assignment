package TronGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Info {
    private JFrame frame;
    public Info () {
        Image info_bgd;//cree noveux image
        info_bgd = new ImageIcon("about_us.jpg").getImage();
        //cree noveux frame avec un tittre
        frame = new JFrame("TRON GAME/info");
        //internet
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // noveux object obtunu de Style class
        //Style s = new Style();
        //gameArea = new GameEngine();
        //frame.getContentPane().add(gameArea);

        //frame.add(s);//ajoute l object s dans le frame
        // Set the frames content pane to use a JLabel
        // whose icon property has been set to use the image
        // we just loaded
        frame.setContentPane(new JLabel(new ImageIcon(info_bgd)));
// Supply a layout manager for the body of the content
        //frame.setLayout(new GridBagLayout());
        //GridBagConstraints gbc = new GridBagConstraints();
        //gbc.gridwidth = GridBagConstraints.REMAINDER;

        JButton  back_btn =new JButton(new ImageIcon("back_btn.jpg"));
        JButton  Exit_btn =new JButton(new ImageIcon("quit_btn.jpg"));
        //frame.add(back_btn,gbc);
        back_btn.setSize(180,70);
        back_btn.setLocation(890,0);
        frame.getContentPane().add(back_btn);

        back_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameGUI gm = new GameGUI();
                frame.dispose();
            }
        });

        frame.setPreferredSize(new Dimension(1080,645));
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }
}
