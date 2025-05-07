package objects;

import game.Maze;
import utils.Direction;
import utils.Type;

//Aufgabe #1d #1e
public abstract class GameEntity {
	/* Basisverzeichis fuer das Projekt und die Bilder bestimmen */
	protected static final String sep = System.getProperty("file.separator");
	protected static final String dir = System.getProperty("user.dir");
	protected static final String resDir = dir + sep + "resources" + sep; // Resources Verzeichnis
	
	protected int x; // Spaltennummer
	protected int y; // Zeilennummer

	public GameEntity(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void move(Direction direction) {
		switch (direction) {
			case UP:
				this.y--;
				break;
			case DOWN:
				this.y++;
				break;
			case LEFT:
				this.x--;
				break;
			case RIGHT:
				this.x++;
				break;
			default:
				// nichts tun
				break;
		}
	}


	// Aufgabe #1d #1e
	// TODO: Code hier einfügen

	public boolean isValidMove(Direction direction) {
		int newX = getX();
		int newY = getY();

		switch (direction) {
			case UP:
				newY--;
				break;
			case DOWN:
				newY++;
				break;
			case LEFT:
				newX--;
				break;
			case RIGHT:
				newX++;
				break;
		}

		// Spielfeldgrenzen prüfen
		if (newX < 0 || newY < 0 || newY >= Maze.maze.length || newX >= Maze.maze[0].length) {
			return false;
		}

		// Wandprüfung
		return Maze.maze[newY][newX] != Type.WALL;
	}

	public static boolean collisionDetection(GameEntity entity1, GameEntity entity2) {
		return entity1.getX() == entity2.getX() && entity1.getY() == entity2.getY();
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}