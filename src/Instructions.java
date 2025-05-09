import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Instructions extends JPanel implements ActionListener {
    Layout layout;
    JButton backButton;
    JLabel instructionsLabel;
    Image background;

    public Instructions(Layout layout) {
        this.layout = layout;

        ImageIcon bgIcon = new ImageIcon("resources/images/GameBackground.png");
        background = bgIcon.getImage();

        setLayout(null);

        // Text HTML
        String instructions = """
        <html><div style='text-align: center; color: white; font-family: Arial; font-size: 14px;'>
        <h3>🎯 Objective:</h3>
        Collect coins as currency and to get Fame Points.<br>
        Use coins in the shop to buy blocks.<br>
        Build platforms to navigate the map and avoid falling into lava.<br>
        Get a 20 Fame Points to win the game!<br><br>

        <h3>🎮 Controls:</h3>
        <b>Player 1 (WASD + F):</b><br>
        A / D = Move<br>
        W = Jump<br>
        F = Place Block / Use Shop<br>
        S = Exit Shop<br><br>
        <b>Player 2 (IJKL + ;):</b><br>
        J / L = Move<br>
        I = Jump<br>
        ; = Place Block / Use Shop<br>
        K = Exit Shop<br><br>

        <h3>🛒 Shops:</h3>
        Stand in your shop and press the shop key to start a quiz<br>
        Correct answers give 3 blocks per coin (max 15 blocks)<br><br>

        <h3>⚡ Tips:</h3>
        - Falling resets coins & blocks and halves your score<br>
        - Convert your coins to blocks to build <br>
        </div></html>
        """;

        // Create label
        instructionsLabel = new JLabel(instructions);
        instructionsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        instructionsLabel.setVerticalAlignment(SwingConstants.TOP);

        // Wrap in panel with border
        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.setBackground(new Color(0, 0, 0, 150));
        textPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        textPanel.add(instructionsLabel, BorderLayout.CENTER);

        // Preferred size for dynamic height
        instructionsLabel.setSize(600, Short.MAX_VALUE);  // Set width; height will auto-calc
        Dimension preferredSize = instructionsLabel.getPreferredSize();
        int padding = 40;

        textPanel.setBounds(
                720 - 300, // center horizontally for 600px width
                80,
                600,
                preferredSize.height + padding
        );

        add(textPanel);

        // Back button (same styling as Start screen)
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

    private void buttonSound(){
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
