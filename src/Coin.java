/* Aaryateja Addala
 * Coins
 */

class Coin {
    private int x, y;
    private boolean collected;

    public Coin(int x, int y) {
        // Initialize coin at position
        this.x = x;
        this.y = y;
        this.collected = false;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public boolean isNotCollected() { return !collected; }
    public void collect() { collected = true; }
}