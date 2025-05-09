package game;

import threads.CollisionThread;
import threads.GhostThread;
import threads.PacManThread;
import threads.ScoreThread;
import utils.Direction;

//Aufgaben #2b #3
public class GameLoop {
	public GamePanel gamePanel;
	public int score;
	public boolean running;
	public boolean paused;

	// vier Threads für den Spielablauf
	private final Thread pacManThread;
	private final Thread ghostThread;
	private final Thread collisionThread;
	private final Thread scoreThread;

	public GameLoop(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
		this.running = true;
		this.paused = true;

		// Initialisiere die Threads für Spielkomponenten
		// TODO: Threads initialisieren
		this.pacManThread = new Thread(new PacManThread(gamePanel));
		this.ghostThread = new Thread(new GhostThread(gamePanel));
		this.collisionThread = new Thread(new CollisionThread(gamePanel));
		this.scoreThread = new Thread(new ScoreThread(gamePanel));
	}

	public void start() {
		running = true;
		// TODO: Threads starten
		pacManThread.start();
		ghostThread.start();
		scoreThread.start();
		collisionThread.start();
	}

	public void stopLoop() {
		running = false;
	}

	public void pauseGame() {
		paused = true;
	}

	public void resumeGame() {
		paused = false;
	}

	public void reset() {
		resetPacManPosition();
		resetGhostPositions();
		gamePanel.repaint(); // Anzeige nach dem Zurücksetzen der Positionen aktualisieren
	}

	private void resetPacManPosition() {
		gamePanel.pacMan.setDirection(Direction.RIGHT);
		gamePanel.pacMan.setX(13);
		gamePanel.pacMan.setY(17);
	}

	private void resetGhostPositions() {
		gamePanel.redGhost.setX(12);
		gamePanel.redGhost.setY(13);
		gamePanel.blueGhost.setX(13);
		gamePanel.blueGhost.setY(13);
		gamePanel.orangeGhost.setX(14);
		gamePanel.orangeGhost.setY(13);
		gamePanel.pinkGhost.setX(15);
		gamePanel.pinkGhost.setY(13);
	}
}