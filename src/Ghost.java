import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Ghost implements ActionListener {
    private int player;
    private double x, y, yoffset;

    private double width, height;

    private boolean left;

    private boolean die;

    private Timer deathTM = new Timer(25000, this);

    public Ghost(int x, int y, int player){
        width = 21;
        height = 33;

        this.x = x;
        this.y = y;
        yoffset = 0;
        this.player = player;
        die = false;
        left = true;

        deathTM.start();
    }

    public boolean update(double pl1x, double pl1y, double pl2x, double pl2y) {
        yoffset += 0.05;
        yoffset = (yoffset >= 2 * Math.PI) ? 0 : yoffset; // Fix for floating-point precision

        boolean pl1 = player == 1;
        double plx = pl1 ? pl1x : pl2x;
        double ply = pl1 ? pl1y : pl2y;

        double adjacent = plx - x - (width / 2);
        double opposite = ply - y - (height / 2);
        double hypo = Math.sqrt(adjacent * adjacent + opposite * opposite);

        int speed = 2; // Increased from 1 for faster movement

        if (hypo < 1e-8) {
            return die;
        }

        // Remove (int) casting to preserve fractional movement
        x += speed * adjacent / hypo;
        y += speed * opposite / hypo;

        left = adjacent / hypo < 0;

        return die;
    }

    public void die(){
        die = true;
    }

    public boolean isNotDead() { return !die; }

    public Rectangle getRect(){
        return new Rectangle((int) x, (int) y, (int) width, (int) height);
    }

    public void draw(Graphics g) {
        g.drawImage(new Picture().getImage("ghost"), (int) ((int) x + (left ? width : 0)), (int) (y + (30 * Math.sin(yoffset))), (int) (width * (left ? -1 : 1)), (int) height, null);
    }

    public int getPlayer() { return player; }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == deathTM){
            die();
        }
    }
}