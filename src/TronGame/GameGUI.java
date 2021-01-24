package TronGame;

// j ai importe des biblio de java pour les utilise
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author bli
 */
public class GameGUI {

    private JFrame frame;//sans Jframe c est tres important pour disgn n import quoi
    //private GameEngine gameArea;
    // constractor
    public GameGUI () {
        Image background;//cree noveux image
        background = new ImageIcon("bgd.jpg").getImage();
        //cree noveux frame avec un tittre
        frame = new JFrame("TRON GAME");
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
        frame.setContentPane(new JLabel(new ImageIcon(background)));
// Supply a layout manager for the body of the content
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        // Add stuff...
        //frame.add(new JLabel("Hello world"), gbc);
        //frame.add(new JLabel("I'm on top"), gbc);
        //frame.add(new JButton("Clickity-clackity"), gbc);
        JButton  play_btn =new JButton(new ImageIcon("play_btn.jpg"));
        frame.add(play_btn,gbc);
        JButton  info_btn =new JButton(new ImageIcon("info_btn.jpg"));
        frame.add(info_btn,gbc);
        JButton  quit_btn =new JButton(new ImageIcon("quit_btn.jpg"));
        frame.add(quit_btn,gbc);

        play_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EnterData();
                frame.dispose();
            }
        });
        info_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Info inf = new Info();
                frame.dispose();


            }
        });
        quit_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });

        frame.setPreferredSize(new Dimension(1080,600));
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }


}