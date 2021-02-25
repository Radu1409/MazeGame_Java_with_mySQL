package mazeproject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Login  {

    static JFrame frame = new JFrame();

    private BackgroundLogin panel;

    private JTextField textfield_user = new JTextField(12);
    private JPasswordField textfield_pass = new JPasswordField(12);

    private JLabel button = new JLabel("Login");
    private JLabel button_r = new JLabel("Reset");

    ImageIcon imgIc;
    Image img;

    ImageIcon imgIc_pass;
    Image img_pass;

    ImageIcon exit_icon;
    Image exit_img;

    JLabel label_sign;
    JLabel user_logo;
    JLabel pass_logo;
    JLabel exit_window;

    GridBagLayout layout;
    GridBagConstraints c;
    GridBagConstraints grd;
    GridBagConstraints gp;
    GridBagConstraints gg;

    private static Boolean allow = true;

    private HashMap<String, String> logininfo = new HashMap<String, String>();

    Login(HashMap<String, String> logininfoOriginal) {

        panel = new BackgroundLogin();

        img = new ImageIcon("C:\\Users\\Lenovo\\IdeaProjects\\Proiect_Personal_Java\\src\\packet_images\\user_logo.png").getImage().getScaledInstance(25, 30, BufferedImage.SCALE_DEFAULT);

        img_pass = new ImageIcon("C:\\Users\\Lenovo\\IdeaProjects\\Proiect_Personal_Java\\src\\packet_images\\pass_logo2.png").getImage().getScaledInstance(25, 30, BufferedImage.SCALE_DEFAULT);

        //exit_img = new ImageIcon("C:\\Users\\Lenovo\\IdeaProjects\\Proiect_Personal_Java\\src\\packet_images\\icon_exit6.png").getImage().getScaledInstance(30, 25, BufferedImage.SCALE_DEFAULT);

        imgIc = new ImageIcon(img);
        imgIc_pass = new ImageIcon(img_pass);
        //exit_icon = new ImageIcon(exit_img);

        label_sign = new JLabel("Sign UP");
        user_logo = new JLabel(imgIc);
        pass_logo = new JLabel(imgIc_pass);
        exit_window = new JLabel(exit_icon);

        logininfo = logininfoOriginal;
        button.setOpaque(true);
        button.setMinimumSize(new Dimension(25,25));
        button.setPreferredSize(new Dimension(150,30));
        button.setBackground(new Color(61, 166, 45));
        button.setHorizontalAlignment(SwingConstants.CENTER);

        button.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));

        button.addMouseListener(new buttonML());
        button_r.addMouseListener(new button_r_ML());

        button_r.setOpaque(true);
        button_r.setMinimumSize(new Dimension(25,25));
        button_r.setPreferredSize(new Dimension(150,30));
        button_r.setBackground(new Color(61, 166, 45));
        button_r.setHorizontalAlignment(SwingConstants.CENTER);

        button_r.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));

        exit_window.addMouseListener(new exit_windowML());

        textfield_user.setOpaque(false);
        textfield_user.setFont(new Font("Ink Free", Font.PLAIN, 20));
        textfield_user.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        textfield_user.setForeground(Color.RED);


        textfield_pass.setOpaque(false);
        textfield_pass.setFont(new Font("Ink Free", Font.PLAIN, 20));
        textfield_pass.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        textfield_pass.setForeground(Color.RED);

        label_sign.setForeground(Color.black);
        label_sign.setFont(new Font("Helvetica", Font.BOLD, 25));

        layout = new GridBagLayout();
        c = new GridBagConstraints();
        grd = new GridBagConstraints();
        gp = new GridBagConstraints();
        gg = new GridBagConstraints();

        panel.setLayout(layout);

        gg.anchor = GridBagConstraints.FIRST_LINE_END;

        gg.gridx = 0;
        gg.gridy = 0;
        gg.weightx = 1;
        gg.weighty = 1;

        gg.insets = new Insets(0, 0, 0, 0);
        panel.add(exit_window, gg);

        grd.anchor = GridBagConstraints.LINE_END;

        grd.gridx = 0;
        grd.gridy = 0;
        grd.weightx = 1;
        grd.weighty = 0;
        grd.gridwidth = 1;
        grd.gridheight = 1;

        grd.insets = new Insets(90, 20, 50, 185);

        panel.add(label_sign, grd);

        c.anchor = GridBagConstraints.LINE_END;

        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 0;
        c.gridheight = 1;
        c.insets = new Insets(0, 20, 0, 130);

        panel.add(textfield_user, c);


        c.insets = new Insets(25, 20, 25, 335);
        panel.add(user_logo, c);


        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 0;

        c.insets = new Insets(0, 20, 20, 130);
        panel.add(textfield_pass, c);

        c.insets = new Insets(5, 20, 30, 335);
        panel.add(pass_logo, c);

        gp.anchor = GridBagConstraints.LINE_END;
        gp.gridx = 0;
        gp.gridy = 4;

        gp.insets = new Insets(60, 20, 180, 155);
        panel.add(button, gp);

        gp.anchor = GridBagConstraints.LINE_END;
        gp.gridx = 0;
        gp.gridy = 4;

        gp.insets = new Insets(60, 20, 100, 155);
        panel.add(button_r, gp);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                //Login.this.dispose();
                //Login.frame.dispose();

                textfield_user.setText("");
                textfield_pass.setText("");
                Start.frame.setExtendedState(JFrame.NORMAL);
                Start.frame.setLocationRelativeTo(null);
                frame.dispose();
                allow = true;
            }
        });


        textfield_user.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (textfield_user.getText().length() >= 15) {
                    e.consume();
                    e.getModifiers();
                }
            }
        });

        textfield_pass.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                if (String.valueOf(textfield_pass.getPassword()).length() >= 15) {
                    e.consume();
                    e.getModifiers();

                }
            }
        });

        frame.getContentPane().add(panel);

        frame.setVisible(true);
        frame.setResizable(false);
        frame.pack();

        frame.setLocationRelativeTo(null);
    }

     class buttonML extends MouseAdapter {
         @Override
         public void mouseClicked(MouseEvent e) {
             super.mouseClicked(e);
             String userId = textfield_user.getText();
             String password = String.valueOf(textfield_pass.getPassword());

             if (userId.matches("[^~!@#$%^&*()_+-]+") && password.matches("[^~!@#$%^&*()_+-]+")) {

                 if (logininfo.containsKey(userId)) {
                     if (logininfo.get(userId).equals(password)) {
                         frame.dispose();
                         Start.frame.dispose();
                         Game game = new Game();

                     } else {
                         JOptionPane optionPane = new JOptionPane();
                         optionPane.setMessage("Username sau parola gresita! Va rugam sa incercati din nou!");
                         optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
                         optionPane.setOptionType(JOptionPane.DEFAULT_OPTION);
                         recursiveUnfocusButtons(optionPane);
                         JDialog dialog = optionPane.createDialog(null, "Autentificare!");

                         dialog.setVisible(true);
                     }

                 } else if (userId.equals("") || password.equals("")) {

                     JOptionPane optionPane = new JOptionPane();
                     optionPane.setMessage("Va rugam sa completati toate campuriile!");
                     optionPane.setMessageType(JOptionPane.WARNING_MESSAGE);
                     optionPane.setOptionType(JOptionPane.DEFAULT_OPTION);
                     recursiveUnfocusButtons(optionPane);
                     JDialog dialog = optionPane.createDialog(null, "Autentificare!");

                     dialog.setVisible(true);
                 } else {
                     JOptionPane optionPane = new JOptionPane();
                     optionPane.setMessage("Username sau parola gresita! Va rugam sa incercati din nou!");
                     optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
                     optionPane.setOptionType(JOptionPane.DEFAULT_OPTION);
                     recursiveUnfocusButtons(optionPane);
                     JDialog dialog = optionPane.createDialog(null, "Autentificare!");

                     dialog.setVisible(true);
                 }
             }

             else if (userId.equals("") || password.equals("")) {
                 JOptionPane optionPane = new JOptionPane();
                 optionPane.setMessage("Va rugam sa completati toate campuriile!");
                 optionPane.setMessageType(JOptionPane.WARNING_MESSAGE);
                 optionPane.setOptionType(JOptionPane.DEFAULT_OPTION);
                 recursiveUnfocusButtons(optionPane);
                 JDialog dialog = optionPane.createDialog(null, "Autentificare!");

                 dialog.setVisible(true);

             }
             else {
                 JOptionPane.showMessageDialog(null,"Va rugam introduceti numai litere sau cifre!", "Eroare", JOptionPane.INFORMATION_MESSAGE);
             }

         }
         @Override
         public void mouseEntered(MouseEvent e) {
             super.mouseEntered(e);
             button.setOpaque(true);
             button.setBackground(new Color(25, 99, 14));
         }

         @Override
         public void mouseExited(MouseEvent e) {
             super.mouseExited(e);
             button.setBackground(new Color(61, 166, 45));
         }

         @Override
         public void mousePressed(MouseEvent e) {
             super.mousePressed(e);
             button.setBorder(BorderFactory.createLoweredBevelBorder());
         }

         @Override
         public void mouseReleased(MouseEvent e) {
             super.mouseReleased(e);
             button.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
         }
     }

    class button_r_ML extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);

            textfield_user.setText("");
            textfield_pass.setText("");
        }
        @Override
        public void mouseEntered(MouseEvent e) {
            super.mouseEntered(e);
            button_r.setOpaque(true);
            button_r.setBackground(new Color(25, 99, 14));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            super.mouseExited(e);
            button_r.setBackground(new Color(61, 166, 45));
        }

        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            button_r.setBorder(BorderFactory.createLoweredBevelBorder());
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            super.mouseReleased(e);
            button_r.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        }
    }

     class exit_windowML extends MouseAdapter {
         @Override
         public void mouseClicked(MouseEvent e) {
             super.mouseClicked(e);
             exit_window.setOpaque(false);
             exit_window.setBackground(null);
             textfield_user.setText("");
             textfield_pass.setText("");
             Start.frame.setExtendedState(JFrame.NORMAL);
             Start.frame.setLocationRelativeTo(null);
             frame.dispose();
             allow = true;
         }

         @Override
         public void mousePressed(MouseEvent e) {
             super.mouseReleased(e);
             exit_window.setBackground(new Color(160, 0, 0, 255));
         }

         @Override
         public void mouseEntered(MouseEvent e) {
             super.mouseEntered(e);
             exit_window.setOpaque(true);
             exit_window.setBackground(new Color(255, 0, 0, 255));
         }

         @Override
         public void mouseExited(MouseEvent e) {
             super.mouseExited(e);
             exit_window.setOpaque(false);
             exit_window.setBackground(null);
         }

         @Override
         public void mouseWheelMoved(MouseWheelEvent e) {
             super.mouseWheelMoved(e);
             System.exit(0);
         }
     }

     static void showFrameOnce() {

        if (allow) {
            allow = false;
            IDandPass idandPasswords = new IDandPass();
            Login loginPage = new Login(idandPasswords.getlogininfo());

        }
        else {
            frame.setAlwaysOnTop(true);
            frame.setAlwaysOnTop(false);
        }
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


    public class BackgroundLogin extends JPanel {

        BufferedImage img;
        BufferedImage img_user;
        BufferedImage img_pass;
        //BufferedImage scaledImage = Scalr.resize(imageToScale, Scalr.Method.ULTRA_QUALITY, Scalr.Mode.FIT_EXACT, dWidth, dHeight, bufferedImageOpArray);
        BackgroundLogin() {
            setPreferredSize(new Dimension(1000,600));

            setVisible(true);
            loadImage("C:\\Users\\Lenovo\\IdeaProjects\\Proiect_Personal_Java\\src\\packet_images\\wallpaper_login8_REVERSED_Copy.png");
            //loadImage("C:\\Users\\Lenovo\\IdeaProjects\\Proiect_Personal_Java\\src\\packet_images\\wallpaper_start5.jpg");

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
