import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class EnemyArray {

    private ArrayList<Enemy> enemyArray = new ArrayList<>();
    private Enemy enemy;
    private Player player;

    private int maxEnemies;
    private Random random = new Random();

    public EnemyArray(Player player, int maxEnemies) {
        this.player = player;
        this.maxEnemies = maxEnemies;
    }

    public void createEnemies() {
        for (int i=0; i < maxEnemies; i++) {
            if (enemyArray.size() < maxEnemies && player.getPlayerHealth() > 0)
                enemyArray.add(new Enemy(random.nextInt(Dimensions.WINDOW_WIDTH-75), 0));
        }
    }

    public void moveEnemy() {
        for (int i=0; i < enemyArray.size(); i++) {
            enemy = enemyArray.get(i);
            enemy.move();
        }
        checkPlayerCollision();
    }

    public void checkPlayerCollision() {
        for (int i = 0; i < enemyArray.size(); i++) {
            enemy = enemyArray.get(i);
            if (enemy.position_Y >= Dimensions.WINDOW_HEIGHT - enemy.getEnemyHeight() - 30) {
                player.setPlayerHealth(player.getPlayerHealth() - 1);
                enemyArray.remove(i);
                if (player.getPlayerHealth() > 0)
                    enemyArray.add(new Enemy(random.nextInt(Dimensions.WINDOW_WIDTH - 75), 0));
            }

            if (enemy.getBounds(enemy.getEnemyWidth(), enemy.getEnemyHeight()).intersects(player.getBounds(player.getPlayerWidth(), player.getPlayerHeight()))) {
                player.setPlayerHealth(player.getPlayerHealth() - 1);
                enemyArray.remove(i);
                if (player.getPlayerHealth() > 0)
                    enemyArray.add(new Enemy(random.nextInt(Dimensions.WINDOW_WIDTH - 75), 0));
            }
        }
    }

    public boolean checkBulletCollision(Bullet bullet) {
        for (int i=0; i < enemyArray.size(); i++) {
            enemy = enemyArray.get(i);
            if (enemy.getBounds(enemy.getEnemyWidth(), enemy.getEnemyHeight()).intersects(bullet.getBounds(bullet.getBulletWidth(), bullet.getBulletHeight()))) {
                enemyArray.remove(i);
                return true;
            }
        }
        return false;
    }

    public void paint(Graphics graphics) {
        for (int i = 0; i < enemyArray.size(); i++) {
            enemy = enemyArray.get(i);
            enemy.paint(graphics);
        }
    }

    public void setMaxEnemies(int maxEnemies) {
        this.maxEnemies = maxEnemies;
    }
}
