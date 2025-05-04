package game;

import javax.swing.JFrame;
import utils.Constants;

//NICHT BEARBEITEN
public class GameWindow extends JFrame {
	private static final long serialVersionUID = 1L;

	private GamePanel gamePanel;

	// Erstellt das Fenster und startet das Spiel
	public static void launch() {
		GameWindow window = new GameWindow();

		window.gamePanel = new GamePanel();
		window.add(window.gamePanel);

		window.setTitle("Pac Man");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(Constants.TILE_SIZE * Constants.WIDTH + 14, Constants.TILE_SIZE * Constants.HEIGHT + 35);
		window.setVisible(true);
	}
}