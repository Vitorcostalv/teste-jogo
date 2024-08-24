import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player implements KeyListener {
    private int x, y;
    private int width, height;
    private int dx, dy;
    private BinaryTree platforms;

    public Player(int startX, int startY, BinaryTree platforms) {
        this.x = startX;
        this.y = startY;
        this.width = 40;
        this.height = 40;
        this.platforms = platforms;
    }

    public void move() {
        int newX = x + dx;
        int newY = y + dy;
        Rectangle newBounds = new Rectangle(newX, newY, width, height);

        if (!collidesWithPlatform(newBounds)) {
            x = newX;
            y = newY;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    private boolean collidesWithPlatform(Rectangle playerBounds) {
        return checkCollision(platforms.getRoot(), playerBounds);
    }

    private boolean checkCollision(TreeNode node, Rectangle playerBounds) {
        if (node == null) {
            return false;
        }

        if (node.platform.getBounds().intersects(playerBounds)) {
            return true;
        }

        return checkCollision(node.left, playerBounds) || checkCollision(node.right, playerBounds);
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -2;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 2;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -2;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 2;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }

    public void keyTyped(KeyEvent e) {}
}
