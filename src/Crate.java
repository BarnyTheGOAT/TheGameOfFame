import java.awt.*;

class Crate {
    private double y, yvel;
    private int x;
    private static final int WIDTH = 24;  // Adjust if your crate image is a different width
    private static final int HEIGHT = 24;
    private boolean collected;

    public Crate(int pipeX) {
        x = pipeX;
        y = 68;
        yvel = 0;
        collected = false;
    }

    public boolean isNotCollected() { return !collected; }

    public void collect() { collected = true; }

    public Rectangle getRect(){
        return new Rectangle(x - (WIDTH / 2), (int) y - (HEIGHT / 2), WIDTH, HEIGHT);
    }

    public int getX() { return x; }

    public int getY() { return (int) y; }

    public boolean update(Block[][] blocks, int lava) {
        yvel += 0.8;

        for (int i = 0; i < yvel; i++) {
            boolean hitBottom =
                    isBlockAt(x - ((double) WIDTH / 2), y + ((double) HEIGHT / 2) + 1, blocks) ||
                            isBlockAt(x,          y + ((double) HEIGHT / 2) + 1, blocks) ||
                            isBlockAt(x + ((double) WIDTH / 2),  y + ((double) HEIGHT / 2) + 1, blocks);

            if (hitBottom) {
                yvel = 0;
                break;
            } else {
                y += 1;
            }
        }

        return y > lava;
    }

    public void draw(Graphics g) {
        g.drawImage(new Picture().getImage("crate"),
                x - WIDTH / 2, (int) y - HEIGHT / 2,
                x + WIDTH / 2, (int) y + HEIGHT / 2,
                0, 0, 204, 204, null);
    }

    private boolean isBlockAt(double x, double y, Block[][] blocks) {
        int col = (int) Math.floor(x / 24);
        int row = (int) Math.floor(y / 24);
        if (col < 0 || col >= blocks.length || row < 0 || row >= blocks[0].length) return false;
        return blocks[col][row].isBlock();
    }
}
