package TronGame;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

class GamePanel extends JPanel implements ActionListener{
    private JFrame frame;
    static final int SCREEN_WIDTH = 1000;
    static final int SCREEN_HEIGHT = 600;
    static final int TRON_ONE = 5;//unite
    static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/(TRON_ONE*TRON_ONE);//tron_one as size
    static final int DELAY =95;
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];

    final int x2[] = new int[GAME_UNITS];
    final int y2[] = new int[GAME_UNITS];
    int TronBody = 6;

    char direction_first_player = 'R';
    char direction_second_player = 'L';
    boolean running = false;
    Timer timer;
    Random random;
    String playerName1,playerName2,playerColor2,playerColor1;
    GamePanel(String name1,String name2,String Color1,String Color2){
        playerColor1=Color1;
        playerColor2=Color2;
        playerName1=name1;
        playerName2=name2;
        //start point
        x[0]=10;
        y[0]=250;
        x2[0]=980;
        y2[0]=240;
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
        //include menu in play panel

    }
    public void startGame() {

        running = true;
        timer = new Timer(DELAY,this);//fast of th trons
        timer.start();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g) {

        if(running) {
//FOR THE GRAP MATRIX

            /*for(int i=0;i<SCREEN_WIDTH/TRON_ONE;i++) {
				g.drawLine(i*TRON_ONE, 0, i*TRON_ONE, SCREEN_HEIGHT);
				g.drawLine(0, i*TRON_ONE, SCREEN_WIDTH, i*TRON_ONE);
			}*/
            TronBody++;

            for(int i = 0; i< TronBody;i++) {
              /*if(i == 0) {*/
                    //he must change color depends on the user player
                    if(playerColor1=="RED"){
                    g.setColor(Color.RED);
                    }
                    if(playerColor1=="GREEN"){
                    g.setColor(Color.GREEN);
                    }
                    if(playerColor1=="YELLOW"){
                    g.setColor(Color.yellow);
                    }
                    if(playerColor1=="BLUE"){
                    g.setColor(Color.blue);
                    }
                    //System.out.println();
                    g.fillRect(x[i], y[i], TRON_ONE, TRON_ONE);
                    //second player coordinate
                if(playerColor2=="RED"){
                    g.setColor(Color.RED);
                }
                if(playerColor2=="GREEN"){
                    g.setColor(Color.GREEN);
                }
                if(playerColor2=="YELLOW"){
                    g.setColor(Color.yellow);
                }
                if(playerColor2=="BLUE"){
                    g.setColor(Color.blue);
                }
                //System.out.println();
                    g.fillRect(x2[i], y2[i], TRON_ONE, TRON_ONE);
            /*}
               else {
                    //same here
                    g.setColor(new Color(45,90,190));
                    //g.setColor(new Color(250,0,0));
                    //g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
                    g.fillRect(x[i], y[i], TRON_ONE, TRON_ONE);
                }*/
            }
            g.setColor(Color.red);
            g.setFont( new Font("Ink Free",Font.BOLD, 30));
            FontMetrics metrics1 = getFontMetrics(g.getFont());
            //show the players name and score

            g.drawString(playerName1+"|score: "+TronBody+"|"+playerName2, (SCREEN_HEIGHT- metrics1.stringWidth("Score: "+TronBody))/2, g.getFont().getSize());
        }else{
            gameOver(g);
            /*Boolean highScoreClick = true;
            if(highScoreClick==true){
                g.setColor(Color.yellow);
                g.setFont( new Font("Ink Free",Font.BOLD, 30));
                FontMetrics metrics2 = getFontMetrics(g.getFont());
                g.drawString( "name of the player/t| Score", (SCREEN_HEIGHT - metrics2.stringWidth("name of the player/t| Score")) / 2, g.getFont().getSize());
                for(int i=0;i<8;i++) {
                    g.drawString(playerName1 + "/t| " + TronBody, (SCREEN_HEIGHT - metrics2.stringWidth(playerName1 + "/t| " + TronBody)) / 2, g.getFont().getSize());
                }
            }
            else{
                g.setColor(Color.MAGENTA);
                g.setFont( new Font("Ink Free",Font.BOLD, 10));
                FontMetrics metrics2 = getFontMetrics(g.getFont());
                g.drawString("there is no Scores Yet,", (SCREEN_HEIGHT- metrics2.stringWidth("there is no scores"))/2, g.getFont().getSize());

            }*/
        }
    }
    public void move(){
        for(int i = TronBody;i>0;i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
            x2[i] = x2[i-1];
            y2[i] = y2[i-1];

        }

        switch(direction_first_player) {
            case 'U':
                y[0] = y[0] - TRON_ONE;
                break;
            case 'D':
                y[0] = y[0] + TRON_ONE;
                break;
            case 'L':
                x[0] = x[0] - TRON_ONE;
                break;
            case 'R':
                x[0] = x[0] + TRON_ONE;
                break;
        }
        switch(direction_second_player) {
            case 'U':
                y2[0] = y2[0] - TRON_ONE;
                break;
            case 'D':
                y2[0] = y2[0] + TRON_ONE;
                break;
            case 'L':
                x2[0] = x2[0] - TRON_ONE;
                break;
            case 'R':
                x2[0] = x2[0] + TRON_ONE;
                break;
        }

    }
    String winner;
    public void checkCollisions() {
        //checks if head collides with body
        for(int i = TronBody;i>0;i--) {
            if(x[0]==x2[i] && y[0]==y2[i]){
                running=false;
                winner=playerName2;
                System.out.println(winner);
            }
            if(x2[0]==x[i] && y2[0]==y[i]){
                running=false;
                winner=playerName1;
                System.out.println(winner);
            }

            if((x[0] == x[i])&& (y[0] == y[i])) {
                running = false;
            }
            if((x2[0] == x2[i])&& (y2[0] == y2[i])) {
                running = false;
            }
        }

        //check if head touches left border
        if(x[0] < 0) {
            winner=playerName2;
            running = false;
        }
        if(x2[0] < 0) {
            winner=playerName1;
            running = false;
        }
        //check if head touches right border
        if(x[0] > SCREEN_WIDTH) {
            winner=playerName2;
            running = false;
        }
        if(x2[0] > SCREEN_WIDTH) {
            winner=playerName1;
            running = false;
        }
        //check if head touches top border
        if(y[0] < 0) {
            winner=playerName2;
            running = false;
        }
        if(y2[0] < 0) {
            winner=playerName1;
            running = false;
        }
        //check if head touches bottom border
        if(y[0] > SCREEN_HEIGHT) {
            winner=playerName2;
            running = false;
        }
        if(y2[0] > SCREEN_HEIGHT) {
            winner=playerName1;
            running = false;
        }

        if(!running) {
            timer.stop();
        }
    }
    public void gameOver(Graphics g) {
        //Score
        g.setColor(Color.red);
        g.setFont( new Font("Ink Free",Font.BOLD, 40));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        //show the players name and score
        //EnterData show_players = new EnterData();
        g.drawString("Score: "+TronBody, (SCREEN_WIDTH - metrics1.stringWidth("Score: "+TronBody))/2, g.getFont().getSize());
        //Game Over text
        g.setColor(Color.cyan);
        g.setFont( new Font("Ink Free",Font.BOLD, 65));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        //chose the winner
        g.drawString("THE WINNER IS :"+winner, (SCREEN_WIDTH - metrics2.stringWidth("THE WINNER IS :"+winner))/2, SCREEN_HEIGHT/2);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(running) {
            move();
            checkCollisions();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            switch(e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if(direction_first_player != 'R') {
                        direction_first_player = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(direction_first_player != 'L') {
                        direction_first_player = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if(direction_first_player != 'D') {
                        direction_first_player = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:

                    if(direction_first_player != 'U') {
                        direction_first_player = 'D';
                    }
                    break;
                    //for second players move
                case KeyEvent.VK_A:
                    if(direction_second_player != 'R') {
                        direction_second_player = 'L';
                    }
                    break;
                case KeyEvent.VK_D:
                    if(direction_second_player != 'L') {
                        direction_second_player = 'R';
                    }
                    break;
                case KeyEvent.VK_W:
                    if(direction_second_player != 'D') {
                        direction_second_player = 'U';
                    }
                    break;
                case KeyEvent.VK_S:
                    if(direction_second_player != 'U') {
                        direction_second_player = 'D';
                    }
                    break;
            }
        }
    }
}
