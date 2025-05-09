package threads;

import game.GamePanel;
import objects.GameEntity;
import objects.Ghost;
import objects.PacMan;
import utils.Constants;

//import static objects.GhostAlgorithms.pacMan;

//Aufgaben #3 
public class CollisionThread implements Runnable {
    private final GamePanel gamePanel;

    public CollisionThread(GamePanel gamePanel) {

        this.gamePanel = gamePanel;
    }

    // Aufgabe #3 Collsion Thread
    // TODO: Code hier einfügen

    private boolean isCollisionDetected() {
        PacMan pacMan = gamePanel.pacMan;

        if (GameEntity.collisionDetection(pacMan, gamePanel.redGhost)) {
            return true;
        }
        if (GameEntity.collisionDetection(pacMan, gamePanel.blueGhost)) {
            return true;
        }
        if (GameEntity.collisionDetection(pacMan, gamePanel.orangeGhost)) {
            return true;
        }
        if (GameEntity.collisionDetection(pacMan, gamePanel.pinkGhost)) {
            return true;
        }
        return false;


    }

    private void checkCollisions() {
        PacMan pacMan = gamePanel.pacMan;
        synchronized (gamePanel) {
            if (isCollisionDetected()) {
                pacMan.decreaseLives();
                gamePanel.gameLoop.reset();
                gamePanel.gameLoop.pauseGame();
            }
        }
    }

    @Override
    public void run() {
        while (gamePanel.gameLoop.running) {
            checkCollisions();

            try {
                Thread.sleep(500 / Constants.GAME_SPEED);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

}