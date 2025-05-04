package threads;

import game.GamePanel;
import objects.GhostAlgorithms;
import objects.PacMan;
import utils.Constants;

//NICHT BEARBEITEN
public class GhostThread implements Runnable {
	private final GamePanel gamePanel;

	public GhostThread(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	@Override
	public void run() {
		while (gamePanel.gameLoop.running) {
			if (!gamePanel.gameLoop.paused) {
				moveGhosts();
				gamePanel.repaint(); // Aktualisiert das Panel, um die Bewegung der Geister anzuzeigen
			}

			try {
				Thread.sleep(1000 / Constants.GAME_SPEED);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
		}

	}

	// Bewegt alle Geister basierend auf PacMans Position
	private void moveGhosts() {
		synchronized (gamePanel) {
			PacMan pacMan = gamePanel.pacMan;
			GhostAlgorithms.makeMove(gamePanel.blueGhost, pacMan);
			GhostAlgorithms.makeMove(gamePanel.orangeGhost, pacMan);
			GhostAlgorithms.makeMove(gamePanel.redGhost, pacMan);
			GhostAlgorithms.makeMove(gamePanel.pinkGhost, pacMan);
		}
	}
}