package mazeproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ball extends Rectangle implements ActionListener, KeyListener {

    private int row;
    private int col;

    private int xVelocity = 0;
    private int yVelocity = 0;

    final int BALL_WIDTH = 980;
    final int BALL_HEIGHT = 665;

    Timer timer;
    Ball(int x, int y, int width_ball, int height_ball) {
        //super(x,y,width_ball,height_ball);
        this.x = x;
        this.y =y;
        this.width = width_ball;
        this.height = height_ball;

        this.row = 9;
        this.col = 0;

        timer = new Timer(10, this);
        timer.start();

    }


    private int [][] maze =
            {       {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, //1
                    {1,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1}, //2
                    {1,1,1,0,1,0,1,1,1,1,1,1,1,0,1,1,1,0,1,1,1,1,1,1,1,1,1,1}, //3
                    {1,0,0,0,1,0,1,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,1,0,1}, //4
                    {1,0,1,1,1,0,1,0,1,0,1,0,1,1,1,0,1,1,1,1,1,1,1,1,0,1,0,1}, //5
                    {1,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,1}, //6
                    {1,1,1,1,1,1,1,1,1,0,1,1,1,0,1,0,1,0,1,1,1,1,1,1,1,1,1,1}, //7
                    {1,0,0,0,1,0,0,0,0,0,1,0,1,0,0,0,1,0,0,0,0,0,0,0,0,1,0,9}, //8
                    {1,0,1,1,1,0,1,0,1,0,1,0,1,0,1,1,1,1,1,1,1,1,1,1,0,1,0,1}, //9
                    {0,0,0,0,1,0,1,0,1,0,0,0,1,0,1,0,0,0,0,0,0,0,0,1,0,1,0,1}, //10
                    {1,1,1,0,1,0,1,1,1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,1,0,1,0,1}, //11
                    {1,0,0,0,1,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,1,0,1}, //12
                    {1,0,1,1,1,1,1,0,1,0,1,1,1,0,1,1,1,1,1,1,1,1,0,1,0,1,0,1}, //13
                    {1,0,1,0,0,0,1,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1}, //14
                    {1,0,1,0,1,0,1,0,1,0,1,0,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1}, //15
                    {1,0,1,0,1,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1}, //16
                    {1,0,1,0,1,1,1,1,1,0,1,0,1,1,1,1,1,1,0,1,1,1,1,1,1,1,0,1}, //17
                    {1,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1}, //18
                    {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, //19
            };

    void draw(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(5, 5, 255));
        g2d.fillOval(x, y, width, height);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (y >= BALL_HEIGHT - height) {
            y = BALL_HEIGHT - height - 5;
        }
        if ( y <= 0) {
            y = 5;
        }

        if (x >= BALL_WIDTH - width) {
            x  = BALL_WIDTH - width - 5;
        }

        if (x <= 0) {
            x = 5;
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (row == 9 && col == 0) {
            if (e.getKeyCode() == KeyEvent.VK_D && maze[row][col + 1] == 0) {
                setXDirection(35);
                x += xVelocity;
                col++;
            }
        }
        else {
            switch (maze[row][col]) {

                case 0:

                    if (e.getKeyCode() == KeyEvent.VK_D && maze[row][col + 1] == 0) {
                        setXDirection(35);
                        x += xVelocity;
                        col++;
                    }

                    if (e.getKeyCode() == KeyEvent.VK_W && maze[row - 1][col] == 0) {
                        //setYDirection(2);
                        yVelocity = -35;
                        y += yVelocity;
                        row--;
                    }

                    if (e.getKeyCode() == KeyEvent.VK_S && maze[row+1][col] == 0) {
                        setYDirection(35);
                        y += yVelocity;
                        row++;
                    }

                    if (e.getKeyCode() == KeyEvent.VK_A && maze[row][col-1] == 0) {
                        setXDirection(-35);
                        x += xVelocity;
                        col--;
                    }

                    if (e.getKeyCode() == KeyEvent.VK_D && maze[row][col + 1] == 9) {
                        setXDirection(35);
                        x += xVelocity;
                        col++;
                        System.out.println("Congratulation, you WON!");
                        JOptionPane optionPane = new JOptionPane((new JLabel("Felicitari, ati trecut labirintul!", JLabel.CENTER)));
                        optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
                        optionPane.setOptionType(JOptionPane.DEFAULT_OPTION);
                        recursiveUnfocusButtons(optionPane);
                        JDialog dialog = optionPane.createDialog(null, "Felicitari!");

                        dialog.setVisible(true);
                        System.exit(0);
                    }
                    break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        if (row == 9 && col == 0) {
            if (e.getKeyCode() == KeyEvent.VK_D ) {
                setXDirection(0);
                x += xVelocity;
            }
        }
        else{
            switch (maze[row][col]) {
                case 0:

                    if (e.getKeyCode() == KeyEvent.VK_W ) {
                        setYDirection(0);
                        y += yVelocity;
                    }


                    if (e.getKeyCode() == KeyEvent.VK_S) {
                        setYDirection(0);
                        y += yVelocity;
                    }

                    if (e.getKeyCode() == KeyEvent.VK_A) {
                        setXDirection(0);
                        x += xVelocity;
                    }

                    if (e.getKeyCode() == KeyEvent.VK_D ) {
                        setXDirection(0);
                        x += xVelocity;
                    }
                    break;
            }
        }
    }

    private void setXDirection(int speed) {
        xVelocity = speed;
    }

    private void setYDirection(int speed) {
        yVelocity = speed;
    }

    private static void recursiveUnfocusButtons(Component component) {
        if (component instanceof JButton) {
            component.setFocusable(false);

        } else if (component instanceof Container) {
            for (Component c : ((Container) component).getComponents()) {
                recursiveUnfocusButtons(c);
            }
        }
    }
}

