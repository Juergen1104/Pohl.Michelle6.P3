package game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import objects.Ghost;
import objects.PacListener;
import objects.PacMan;
import utils.Direction;
import utils.Constants;
import utils.GhostColor;
import utils.Type;

//Aufgaben #2a #4a #4b
public class GamePanel extends JPanel {
	private static final long serialVersionUID = 1L;

	// Wichtigstes Spielelemente
	public PacMan pacMan;
	public Ghost pinkGhost, orangeGhost, blueGhost, redGhost;
	public PacListener listener;
	public GameLoop gameLoop;

	public GamePanel() {
		initializeComponents();
		startGameLoop();
		// TODO: nach #2a // entfernen
		setBackground(Color.BLACK);
		setOpaque(true);

		addKeyListener(listener);
	}

	private void initializeComponents() {
		this.setFocusable(true);

		// Pac-Man und Geister initialisieren
		this.pacMan = new PacMan(13, 17);
		this.pacMan.setDirection(Direction.RIGHT);

		this.redGhost = new Ghost(12, 13, GhostColor.RED);
		this.blueGhost = new Ghost(13, 13, GhostColor.BLUE);
		this.orangeGhost = new Ghost(14, 13, GhostColor.ORANGE);
		this.pinkGhost = new Ghost(15, 13, GhostColor.PINK);

		// GameLoop und Listener initialisieren
		this.gameLoop = new GameLoop(this);
		this.listener = new PacListener(this.gameLoop, this.pacMan);
	}

	private void startGameLoop() {
		gameLoop.start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawGame((Graphics2D) g);
	}

	private void drawGame(Graphics2D g2) {
		Maze.drawMaze(g2);

		pacMan.drawPac(g2);
		pacMan.drawHeart(g2, getHeight(), getWidth());

		pinkGhost.drawGhosts(g2);
		blueGhost.drawGhosts(g2);
		redGhost.drawGhosts(g2);
		orangeGhost.drawGhosts(g2);

		// Aufgabe #4a #4b
		// TODO: Methoden aufrufen
		drawScore(g2);
		displayEndScreenIfGameOver(g2);

	}

	// Aufgabe #4a #4b
	// TODO: Methode um End-Screen und Score anzuzeigen


	public void drawScore(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 18));

		int score = Maze.calculateScore();
		getHeight();
		g.drawString("Score: " + score, 10, Constants.TILE_SIZE * Constants.HEIGHT -4 );
	}

	public void displayEndScreenIfGameOver(Graphics2D g) {
		if (!gameLoop.running) {
			// Hintergrund schwarz
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, getWidth(), getHeight());

			// Game Over Text
			g.setColor(Color.RED);
			g.setFont(new Font("Arial", Font.BOLD, 48));
			String gameOver = "GAME OVER";
			int x = (getWidth() - g.getFontMetrics().stringWidth(gameOver)) / 2;
			int y = getHeight() / 2 - 20;
			g.drawString(gameOver, x, y);

			// Finaler Score
			g.setColor(Color.WHITE);
			g.setFont(new Font("Arial", Font.PLAIN, 24));
			String finalScore = "Final Score: " + Maze.calculateScore();
			int scoreX = (getWidth() - g.getFontMetrics().stringWidth(finalScore)) / 2;
			g.drawString(finalScore, scoreX, y + 40);
		}
	}

}