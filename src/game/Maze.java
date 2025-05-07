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
        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, Constants.WIDTH, Constants.HEIGHT);

        // Durch das Maze iterieren und je nach Typ zeichnen
        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[row].length; col++) {
                int x = col * Constants.TILE_SIZE;
                int y = row * Constants.TILE_SIZE;

                Type tileType = maze[row][col];

                switch (tileType) {
                    case WALL:
                        g2.setColor(Color.BLUE);
                        int wallPadding = 2;
                        g2.fillRect(x + wallPadding, y + wallPadding,
                                Constants.TILE_SIZE - 2 * wallPadding,
                                Constants.TILE_SIZE - 2 * wallPadding);
                        break;

                    case DOT:
                        drawDot(g2, x, y);
                        break;

                    case EMPTY:

                        break;
                }
            }
        }
    }

    private static void drawDot(Graphics2D g2, int x, int y) {
        g2.setColor(Color.WHITE);
        int dotSize = Constants.TILE_SIZE / 5;
        int dotX = x + (Constants.TILE_SIZE - dotSize) / 2;
        int dotY = y + (Constants.TILE_SIZE - dotSize) / 2;
        g2.fillOval(dotX, dotY, dotSize, dotSize);
    }
}