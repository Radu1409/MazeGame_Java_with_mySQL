package mazeproject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Start{

    static JFrame frame = new JFrame();

    private JLabel play;
    private JLabel exit;

    BackgroundStart panel_bg;

    Start() {

        panel_bg = new BackgroundStart();

        play = new JLabel("Play");
        exit = new JLabel("Exit");


        play.setHorizontalAlignment(SwingConstants.CENTER);
        exit.setHorizontalAlignment(SwingConstants.CENTER);

        play.setOpaque(true);
        play.setPreferredSize(new Dimension(150,30));
        play.setBackground(new Color(61, 166, 45));
        play.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));

        exit.setOpaque(true);
        exit.setPreferredSize(new Dimension(150,30));
        exit.setBackground(new Color(61, 166, 45));
        exit.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));


        play.addMouseListener(new playML());
        exit.addMouseListener(new exitML());


        panel_bg.setLayout(new GridBagLayout());

        GridBagConstraints gg = new GridBagConstraints();

        gg.anchor = GridBagConstraints.PAGE_END;

        gg.gridx = 0;
        gg.gridy = 0;
        gg.weightx = 1;
        gg.weighty = 1;

        gg.insets = new Insets(0, 0, 80, 0);
        panel_bg.add(play, gg);

        gg.insets = new Insets(0, 0, 40, 0);
        panel_bg.add(exit,gg);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel_bg);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.pack();

        frame.setLocationRelativeTo(null);

    }

    class playML extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            Login.showFrameOnce();
            SwingUtilities.updateComponentTreeUI(Login.frame); // or
//            Login.frame.invalidate();
//            Login.frame.validate();
//            Login.frame.repaint();
            frame.setState(Frame.ICONIFIED);

        }
        @Override
        public void mouseEntered(MouseEvent e) {
            super.mouseEntered(e);
            play.setOpaque(true);
            play.setBackground(new Color(25, 99, 14));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            super.mouseExited(e);
            play.setBackground(new Color(61, 166, 45));
        }

        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            play.setBorder(BorderFactory.createLoweredBevelBorder());
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            super.mouseReleased(e);
            play.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        }
    }

    class exitML extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            System.exit(0);
        }
        @Override
        public void mouseEntered(MouseEvent e) {
            super.mouseEntered(e);
            exit.setOpaque(true);
            exit.setBackground(new Color(25, 99, 14));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            super.mouseExited(e);
            exit.setBackground(new Color(61, 166, 45));
        }

        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            exit.setBorder(BorderFactory.createLoweredBevelBorder());
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            super.mouseReleased(e);
            exit.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        }
    }

    public static class BackgroundStart extends JPanel {

        BufferedImage img;
        BufferedImage img_user;

        BackgroundStart() {
            setPreferredSize(new Dimension(1000,600));

            setVisible(true);
            loadImage("C:\\Users\\Lenovo\\IdeaProjects\\Proiect_Personal_Java\\src\\packet_images\\wallpaper_start3.jpg");

        }

        private void loadImage(String str) {
            try{
                img = ImageIO.read(new File(str));
                img_user = ImageIO.read(new File("C:\\Users\\Lenovo\\IdeaProjects\\Proiect_Personal_Java\\src\\packet_images\\user_logo.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);

        }
    }
}
