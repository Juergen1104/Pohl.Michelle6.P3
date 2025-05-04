package game;

import java.awt.Color;
import java.awt.Graphics2D;
import utils.Constants;
import utils.Type;

//Aufgaben: #1a
public class Maze {
	public static Type[][] maze = Constants.INITIAL_MAZE; // zweidim. Feld von Kacheln (durch Typen geg.)

	// Berechnet den Punktestand basierend auf eingesammelten Punkten (leere Felder)
	public static int calculateScore() {
		int score = -6; // Anzahl der anfangs leeren Felder, um den Punktestand zu kompensieren

		for (Type[] row : maze) {
			for (Type cell : row) {
				if (cell == Type.EMPTY) {
					score++;
				}
			}
		}
		return score;
	}

	public static void drawMaze(Graphics2D g2) {
		// Aufgabe #1a
		// TODO: Code hier einfügen
	}
}