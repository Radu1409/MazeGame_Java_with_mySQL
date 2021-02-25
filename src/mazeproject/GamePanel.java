package mazeproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel implements ActionListener {

    private GameDraw panel;
    private static Ball ball;
    private Image image;
    private Graphics graphics;
    private Timer timer;

    GamePanel() {
        newPanel();;
        newBall();
        this.setFocusable(true);
        this.addKeyListener(new KeyL());
        this.setFocusTraversalKeysEnabled(false);
        this.setPreferredSize(GameDraw.SCREEN_SIZE);


        timer = new Timer(10,this);
        timer.start();
    }

    private void newPanel() {

        panel = new GameDraw();
    }

    private void newBall() {

        ball = new Ball(5,320,25,25);
    }

    private void draw(Graphics g) {
        panel.draw(g);
        ball.draw(g);
    }

    public void paint(Graphics g) {

        image = createImage(GameDraw.GAME_WIDTH, GameDraw.GAME_HEIGHT);
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        ball.actionPerformed(e);
    }

    public static class KeyL extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            ball.keyPressed(e);
        }
        public void keyReleased(KeyEvent e) {
            ball.keyReleased(e);
        }
    }
}