import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class GameLoop extends JPanel implements ActionListener {
    private Timer timer;
    private Player player;
    private BinaryTree platforms;

    public GameLoop() {
        platforms = new BinaryTree();
        createPlatforms();
        player = new Player(100, 100, platforms); // Passa a árvore de plataformas para o Player

        timer = new Timer(16, this); // Aproximadamente 60 FPS
        setFocusable(true);
        addKeyListener(player);
    }

    private void createPlatforms() {
        platforms.insert(new Platform(50, 200, 100, 10));
        platforms.insert(new Platform(200, 300, 150, 10));
        platforms.insert(new Platform(400, 400, 100, 10));
    }

    public void start() {
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.move();
        checkCollisions();
        repaint();
    }

    private void checkCollisions() {
        // Detecção de colisão simplificada
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.draw(g);
        platforms.traverseAndDraw(g);
    }
}
