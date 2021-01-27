package TronGame;
import javax.swing.JFrame;

public class GameFrame extends JFrame{

    GameFrame(String name1,String name2,String Color1,String Color2){
        new MenuBar(this);

        this.add(new GamePanel(name1,name2,Color1,Color2));
        this.setTitle("TRON");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //MenuBar menu1= new MenuBar(this);

        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }
}