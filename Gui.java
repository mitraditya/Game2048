import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Gui extends JPanel implements KeyListener
{
    JFrame frame;
    Game game;
    public Gui()
    {
        frame=new JFrame("2048");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setBounds(500,200,350,400);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.add(this);
        
        this.setVisible(true);
        this.setBounds(0,0,350,400);
        frame.addKeyListener(this);
        
        game=new Game();
        game.randomchoose();
        game.randomchoose();
        
        repaint();
    }
    public void paintComponent(Graphics g)
    {
        g.setColor(new Color(255,200,0));
        g.fillRect(0,0,350,400);
        g.setColor(Color.WHITE);
        g.fillRect(75,150,160,160);
        
        g.setColor(new Color(0,0,0));
        g.drawString("2048",100,50);
        g.drawString("Score :",200,50);
        g.drawString(String.valueOf(game.score),200,75);
        
        if(game.checkfor2048())
        g.drawString("Congratulations",165,100);
        if(game.gameover())
        g.drawString("Game Over",165,100);
        
        g.drawLine(75,150,235,150);
        g.drawLine(75,190,235,190);
        g.drawLine(75,230,235,230);
        g.drawLine(75,270,235,270);
        g.drawLine(75,310,235,310);

        g.drawLine(75,150,75,310);
        g.drawLine(115,150,115,310);
        g.drawLine(155,150,155,310);
        g.drawLine(195,150,195,310);
        g.drawLine(235,150,235,310);
        
        
        if(game.tile[0][0]!=0)
        g.drawString(String.valueOf(game.tile[0][0]),90,175);
        if(game.tile[0][1]!=0)
        g.drawString(String.valueOf(game.tile[0][1]),130,175);
        if(game.tile[0][2]!=0)
        g.drawString(String.valueOf(game.tile[0][2]),170,175);
        if(game.tile[0][3]!=0)
        g.drawString(String.valueOf(game.tile[0][3]),210,175);
        
        if(game.tile[1][0]!=0)
        g.drawString(String.valueOf(game.tile[1][0]),90,215);
        if(game.tile[1][1]!=0)
        g.drawString(String.valueOf(game.tile[1][1]),130,215);
        if(game.tile[1][2]!=0)
        g.drawString(String.valueOf(game.tile[1][2]),170,215);
        if(game.tile[1][3]!=0)
        g.drawString(String.valueOf(game.tile[1][3]),210,215);
        
        if(game.tile[2][0]!=0)
        g.drawString(String.valueOf(game.tile[2][0]),90,255);
        if(game.tile[2][1]!=0)
        g.drawString(String.valueOf(game.tile[2][1]),130,255);
        if(game.tile[2][2]!=0)
        g.drawString(String.valueOf(game.tile[2][2]),170,255);
        if(game.tile[2][3]!=0)
        g.drawString(String.valueOf(game.tile[2][3]),210,255);
        
        if(game.tile[3][0]!=0)
        g.drawString(String.valueOf(game.tile[3][0]),90,295);
        if(game.tile[3][1]!=0)
        g.drawString(String.valueOf(game.tile[3][1]),130,295);
        if(game.tile[3][2]!=0)
        g.drawString(String.valueOf(game.tile[3][2]),170,295);
        if(game.tile[3][3]!=0)
        g.drawString(String.valueOf(game.tile[3][3]),210,295);
    }
    public void keyPressed(KeyEvent k)
    {
    }
    public void keyTyped(KeyEvent k)
    {
    }
    public void keyReleased(KeyEvent k)
    {
        if(k.getKeyCode()==KeyEvent.VK_RIGHT)
        {
            game.pushright();
            game.randomchoose();
            repaint();
        }
        if(k.getKeyCode()==KeyEvent.VK_LEFT)
        {
            game.pushleft();
            game.randomchoose();
            repaint();
            
        }
        if(k.getKeyCode()==KeyEvent.VK_UP)
        {
            game.pushup();
            game.randomchoose();
            repaint();
        }
        if(k.getKeyCode()==KeyEvent.VK_DOWN)
        {
            game.pushdown();
            game.randomchoose();
            repaint();
        }
    }
    public static void main(String args[])
    {
        Gui gui=new Gui();
    }
}
