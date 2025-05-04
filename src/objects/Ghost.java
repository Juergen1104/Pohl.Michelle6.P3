package objects;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import utils.GhostColor;

//Aufgaben #1c 
public class Ghost extends GameEntity {

	private GhostColor color;
	private BufferedImage image;

	public Ghost(int x, int y, GhostColor color) {
		super(x, y);
		this.color = color;
		loadImage(); // Bild mit Geist in zugehöriger Farbe laden
	}

	// Lädt das entsprechende Bild für einen Geist, basierend auf dessen Farbe
	private void loadImage() {
		// Aufagbe 1 c)
		// TODO: Code hier einfügen
	}

	public void drawGhosts(Graphics2D g2) {
		// Aufagbe 1 c)
		// TODO: Code hier einfügen
	}

	// Getter und Setter
	public BufferedImage getImage() {
		return image;
	}

	public GhostColor getColor() {
		return color;
	}

	public void setColor(GhostColor color) {
		this.color = color;
	}
}