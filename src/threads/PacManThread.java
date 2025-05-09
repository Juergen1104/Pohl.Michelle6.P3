package threads;

import game.GamePanel;
import game.Maze;
import utils.Constants;
import utils.Type;

//Aufgaben #2b
public class PacManThread extends Thread {
	private final GamePanel gamePanel;

	public PacManThread(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	// Aufgabe #2b
	// TODO: PacMan Thread erstellen
	private boolean canMovePacMan() {
		return !gamePanel.listener.hasMoved() &&
				gamePanel.pacMan.isValidMove(gamePanel.pacMan.getDirection());
	}

	private void updateMazePosition() {
		int x = gamePanel.pacMan.getX();
		int y = gamePanel.pacMan.getY();
		Maze.maze[y][x] = Type.EMPTY;
	}

	private void clearNewPosition() {
		int x = gamePanel.pacMan.getX();
		int y = gamePanel.pacMan.getY();
		Maze.maze[y][x] = Type.EMPTY;
	}

	private void movePacMan() {
		synchronized (gamePanel.pacMan) {
			if (canMovePacMan()) {
				updateMazePosition();
				gamePanel.pacMan.move(gamePanel.pacMan.getDirection());
				clearNewPosition();
			}
		}
	}

	@Override
	public void run() {
		while (gamePanel.gameLoop.running) {
			if (!gamePanel.gameLoop.paused) {
				movePacMan();
				gamePanel.listener.setHasMoved(false); // Rücksetzen für nächste Runde
			}

			try {
				Thread.sleep(1000 / Constants.GAME_SPEED);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt(); // sauber beenden
				break;
			}
		}
	}
}