package mazeproject;

import java.awt.*;


public class GameDraw extends Rectangle {

    static final int GAME_WIDTH = 980;
    static final int GAME_HEIGHT = 665;
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);

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

    GameDraw() {
        this.setSize(SCREEN_SIZE);
    }

    void draw(Graphics g) {

        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[row].length; col++) {
                Color color;
                switch (maze[row][col]) {
                    case 1 : color = Color.RED; break;
                    case 9 : color = Color.BLUE; break;
                    default : color = Color.WHITE;
                }
                g.setColor(color);
                g.fillRect(35 * col, 35 * row, 35, 35);

                g.setColor(Color.BLACK);
                g.drawRect(35 * col, 35 * row, 35, 35);
            }
        }
    }
}

