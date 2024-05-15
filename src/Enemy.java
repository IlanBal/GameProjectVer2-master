import java.awt.*;
import javax.swing.*;

public class Enemy extends GameObject {

    private ImageIcon enemyImagePath = new ImageIcon(getClass().getResource("enemy.png"));
    private Image enemyImage = enemyImagePath.getImage();
    private int enemyWidth = enemyImagePath.getIconWidth();
    private int enemyHeight = enemyImagePath.getIconHeight();
    private int speed = 2;

    public Enemy(int position_X, int position_Y) {
        super(position_X, position_Y);
    }

    public void move() {
        position_Y+= speed;
    }

    public void paint(Graphics graphics) {
        graphics.drawImage(enemyImage, position_X, position_Y , enemyWidth, enemyHeight, null);
        //graphics.drawRect(position_X, position_Y, enemyWidth, enemyHeight);

    }

    public int getEnemyWidth() {
        return enemyWidth;
    }

    public int getEnemyHeight() {
        return enemyHeight;
    }
}
