import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Start extends JPanel implements ActionListener {
    Layout layout;
    Game game;
    JButton playButton;
    JButton instructionButton;
    
    Image background;

    public Start(Layout layout, Game game){
        this.layout = layout;
        this.game = game;
        
        ImageIcon backgroundIcon = new ImageIcon("resources/GameBackground.png");
        background = backgroundIcon.getImage();

        setLayout(null);

        JLabel title = new JLabel("The Game Of Fame");
        JLabel subtitle = new JLabel("Arnav Jaiswal - Aarya A");
        
        
        title.setFont(new Font("Arial", Font.BOLD, 48));
        subtitle.setFont(new Font("Arial", Font.PLAIN, 14));
        
        title.setForeground(Color.BLACK);
        subtitle.setForeground(Color.DARK_GRAY);
        
        title.setSize(title.getPreferredSize());
        subtitle.setSize(subtitle.getPreferredSize());
        

        title.setBounds(720 - (title.getWidth() / 2), 200 - title.getHeight() - 10, title.getWidth(), title.getHeight());
        subtitle.setBounds(720 - (subtitle.getWidth() / 2), 200 + 10, subtitle.getWidth(), subtitle.getHeight());

        playButton = new JButton("Play!");
        instructionButton = new JButton("Instructions");

        // size
        playButton.setSize(150, 75);
        instructionButton.setSize(250, 75);

        // font
        playButton.setFont(new Font("Arial", Font.BOLD, 24));
        instructionButton.setFont(new Font("Arial", Font.BOLD, 24));

        // background
        playButton.setBackground(new Color(16, 173, 58));
        playButton.setOpaque(true);
        playButton.setForeground(Color.WHITE);

        instructionButton.setBackground(new Color(97, 0, 199));
        instructionButton.setOpaque(true);
        instructionButton.setForeground(Color.WHITE);

        // border
        playButton.setBorder(BorderFactory.createLineBorder(new Color(11, 99, 35), 10));
        instructionButton.setBorder(BorderFactory.createLineBorder(new Color(50, 0, 102), 10));
        
        playButton.setBounds(720 - (playButton.getWidth() / 2), 600 - playButton.getHeight() - 10, playButton.getWidth(), playButton.getHeight());
        instructionButton.setBounds(720 - (instructionButton.getWidth() / 2), 600 + 10, instructionButton.getWidth(), instructionButton.getHeight());

        // action listener
        playButton.addActionListener(this);
        instructionButton.addActionListener(this);

        this.add(title);
        this.add(subtitle);
        
        this.add(playButton);
        this.add(instructionButton);

    }

    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	
    	g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playButton){
            CardLayout cl = (CardLayout) layout.cards.getLayout();
            cl.show(layout.cards, "Game");
            game.requestFocusInWindow();
            game.startGame();
        } else if (e.getSource() == instructionButton  ){
            CardLayout cl = (CardLayout) layout.cards.getLayout();
            cl.show(layout.cards, "Instructions");
        }
    }
}
