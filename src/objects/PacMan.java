package objects;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import utils.Direction;
import utils.Constants;

//Aufgaben #1b 
public class PacMan extends GameEntity {

	private Direction direction;
	private BufferedImage pacmanRightImage, pacmanLeftImage, pacmanUpImage, pacmanDownImage, heartImage;
	private int lives = 3;

	public PacMan(int x, int y) {
		super(x, y);
		this.direction = Direction.RIGHT;
		this.lives = 3;
	}

	public void drawPac(Graphics2D g2) {
		// Aufgabe #1b
		// TODO: Code hier einfügen
	}
	
	// Lädt die Bilder für Pac-Man und das Herz
	private void loadImages() {
		//Aufgabe #1b 
		//TODO: Code hier einfügen 
		
	}

	// Zeichnet die verbleibenden Leben als Herzen unten rechts
	public void drawHeart(Graphics2D g2, int height, int width) {
		int heartSize = 20;
		int padding = 5;
		int startX = width - (heartSize + padding) * lives - padding;
		int startY = height - heartSize - padding;
		try {
			this.heartImage = ImageIO.read(new File(resDir + "heart.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < lives; i++) {
			g2.drawImage(heartImage, startX + i * (heartSize + padding), startY, heartSize, heartSize, null);
		}
	}

	// Getter und Setter
	public int getLives() {
		return lives;
	}

	public void decreaseLives() {
		lives--;
	}

	public void resetLives() {
		lives = 3;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Direction getDirection() {
		return direction;
	}
}