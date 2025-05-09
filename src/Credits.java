import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Credits extends JPanel implements ActionListener {
    Layout layout;
    JButton backButton;
    JLabel creditsLabel;
    Image background;

    public Credits(Layout layout) {
        this.layout = layout;

        ImageIcon bgIcon = new ImageIcon("resources/images/GameBackground.png");
        background = bgIcon.getImage();

        setLayout(null);

        // Credits text with HTML formatting
        String creditsText = """
        <html><div style='text-align: center; color: white; font-family: Arial; font-size: 14px;'>
        <h1>CREDITS</h1>
        <h2>Developers:</h2>
        Arnav Jaiswal<br>
        Aaryateja Addala<br><br>
        
        <h2>Game Design:</h2>
        Original concept by Arnav Jaiswal and Aaryateja Addala<br><br>
        
        <h2>Art & Graphics:</h2>
        Pixel art and sprites created by Arnav Jaiswal<br>
        Background design by Aaryateja Addala<br><br>
        
        <h2>Sound Effects:</h2>
        Sound effects sourced from free sound libraries<br>
        Audio implementation by both developers<br><br>
        
        <h2>Special Thanks:</h2>
        Our Computer Science teacher for guidance<br>
        Java Swing documentation<br>
        Stack Overflow community<br><br>
        
        <h3>© 2025 The Game of Fame Team</h3>
        </div></html>
        """;

        // Create label
        creditsLabel = new JLabel(creditsText);
        creditsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        creditsLabel.setVerticalAlignment(SwingConstants.TOP);

        // Wrap in panel with border
        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.setBackground(new Color(0, 0, 0, 150));
        textPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        textPanel.add(creditsLabel, BorderLayout.CENTER);

        // Preferred size for dynamic height
        creditsLabel.setSize(600, Short.MAX_VALUE);
        Dimension preferredSize = creditsLabel.getPreferredSize();
        int padding = 40;

        textPanel.setBounds(
                720 - 300, // center horizontally
                80,
                600,
                preferredSize.height + padding
        );

        add(textPanel);

        // Back button
        backButton = new JButton("Back to Main Menu");
        backButton.setFont(new Font("Arial", Font.BOLD, 24));
        backButton.setBackground(new Color(97, 0, 199));
        backButton.setForeground(Color.WHITE);
        backButton.setOpaque(true);
        backButton.setBorder(BorderFactory.createLineBorder(new Color(50, 0, 102), 10));
        backButton.setBounds(720 - 170, textPanel.getY() + textPanel.getHeight() + 20, 340, 75);
        backButton.addActionListener(this);
        add(backButton);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            buttonSound();
            CardLayout cl = (CardLayout) layout.cards.getLayout();
            cl.show(layout.cards, "Start");
        }
    }

    private void buttonSound() {
        playWav("resources/sounds/buttonClick.wav");
    }

    private void playWav(String filename) {
        new Thread(() -> {
            try {
                File file = new File(filename);
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (Exception e) {
            }
        }).start();
    }
}