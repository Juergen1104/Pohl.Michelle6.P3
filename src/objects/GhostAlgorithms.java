package objects;

import utils.Direction;

//Aufgabe #1 #Bonusaufgabe
public class GhostAlgorithms {

	private static int pacX;
	private static int pacY;
	private static PacMan pacMan;

	// Methoden mit der im Ghost Thread Bewegung ausgeführt wird
	public static void makeMove(Ghost ghost, PacMan pac) {
		pacMan = pac;
		pacX = pacMan.getX();
		pacY = pacMan.getY();

		switch (ghost.getColor()) {
		case RED -> redGhostMove(ghost);
		case BLUE -> blueGhostMove(ghost);
		case PINK -> pinkGhostMove(ghost);
		case ORANGE -> orangeGhostMove(ghost);
		}
	}

	// Zufällige Bewegung für den Geist
	public static void makeRandomMove(Ghost ghost) {
		int randomDirection = (int) (Math.random() * 4);
		switch (randomDirection) {
		case 0 -> attemptMove(ghost, Direction.UP);
		case 1 -> attemptMove(ghost, Direction.DOWN);
		case 2 -> attemptMove(ghost, Direction.RIGHT);
		case 3 -> attemptMove(ghost, Direction.LEFT);
		}
	}

	// Versucht, einen Zug in eine bestimmte Richtung zu machen
	private static boolean attemptMove(Ghost ghost, Direction direction) {
		// TODO Aufgabe 1 d)

		if (ghost.isValidMove(direction)) {
			switch (direction) {
				case UP:
					ghost.setY(ghost.getY() - 1);
					break;
				case DOWN:
					ghost.setY(ghost.getY() + 1);
					break;
				case LEFT:
					ghost.setX(ghost.getX() - 1);
					break;
				case RIGHT:
					ghost.setX(ghost.getX() + 1);
					break;
			}
			return true;
		}
		return false;


		//ghost.move(direction);
		//return true;
	}

	// Bonusaufgabe: Verschiedene Suchalgorithmen für Geister
	// TODO

	private static void blueGhostMove(Ghost ghost) {
		// TODO: Code hier einfügen
		makeRandomMove(ghost); // default
	}

	private static void redGhostMove(Ghost ghost) {
		// TODO: Code hier einfügen
		makeRandomMove(ghost); // default
	}

	private static void orangeGhostMove(Ghost ghost) {
		// TODO: Code hier einfügen
		makeRandomMove(ghost); // default
	}

	private static void pinkGhostMove(Ghost ghost) {
		// TODO: Code hier einfügen
		makeRandomMove(ghost); // default
	}
}