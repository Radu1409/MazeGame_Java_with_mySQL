package mazeproject;

import javax.swing.*;
import java.awt.*;


public class Game extends JFrame {

    private GamePanel new_panel;

    Game(){
        new_panel = new GamePanel();
        this.add(new_panel);

        this.setBackground(Color.BLACK);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        this.setVisible(true);
        this.pack();
        this.setLocationRelativeTo(null);

    }
}

