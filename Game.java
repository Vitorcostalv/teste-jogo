import javax.swing.JFrame;

public class Game extends JFrame {

    public Game() {
        setTitle("2D Platformer");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Inicializa o jogo e seus componentes
        initGame();
    }

    private void initGame() {
        GameLoop gameLoop = new GameLoop();
        add(gameLoop);
        gameLoop.start();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.setVisible(true);
    }
}
