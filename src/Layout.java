// Start.java
// by Aarya and Arnav
// Splash screen for our mining game - press any key to continue

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Layout extends JPanel implements ActionListener{
    JFrame frame;
    JPanel cards;


    public void actionPerformed(ActionEvent e) {

    }

    public Layout() {
    }

    public void setupWindow(){
        frame = new JFrame("The Game Of Fame");
        

        // create cards
        Game game = new Game();
 
       
        JPanel start = new Start(this, game);
        JPanel instructions = new Instructions(this);
        JPanel credits = new Credits(this);

        // adding cards
        cards = new JPanel(new CardLayout());
        cards.add(game, "Game");
        cards.add(start, "Start");
        cards.add(instructions, "Instructions");
        cards.add(credits, "Credits");
        

        CardLayout cl = (CardLayout) cards.getLayout();

        cl.show(cards, "Start");

        // frame stuff
        frame.add(cards, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GraphicsEnvironment gfxEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gfxDev = gfxEnv.getDefaultScreenDevice();

        frame.setUndecorated(true);
        gfxDev.setFullScreenWindow(frame);
        frame.setVisible(true);
        frame.setSize(1440, 900);
    }

    public static void main(String[] args) {
        Layout layout = new Layout();
        layout.setupWindow();
    }
}