package game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
		// addKeyListener(listener);
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
	}

	// Aufgabe #4a #4b
	// TODO: Methode um End-Screen und Score anzuzeigen
}