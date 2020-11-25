package uet.oop.bomberman.entities;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.scene.Gameloop;
import uet.oop.bomberman.scene.MapSetup;

import java.util.ArrayList;
import java.util.List;

public class Bomb extends Entity {
    private double width, height;
    private int deadlineBomb = 2000 / 16;
    private int deadlinebombExploding = 100 / 16;
    public static int sizeBomb = 1;
    private boolean isExploded = false;
    public Bomb(double x, double y, Image img) {
        super(x, y, img);
        this.width = img.getWidth();
        this.height = img.getHeight();
    }

    public int isImpactBombvsMonster(Bomber bomber) {
        double b = (double) Math.round(Math.abs(this.getY() - bomber.getY()) * 10) / 10;
        double a = (double) Math.round(Math.abs(this.getX() - bomber.getX()) * 10) / 10;
        {
            Rectangle2D rec1 = new Rectangle2D(x * 32, y * 32, width * 0.9, height * 0.9);
            Rectangle2D rec2 = new Rectangle2D((double) Math.round(bomber.getX() * 10) / 10 * 32, (double) Math.round(bomber.getY() * 10) / 10 * 32, bomber.getWidth() * (double) 4 / 5, bomber.getHeight());
            if (rec1.intersects(rec2)) return 1;
        }
        return 0;
    }
    public int isImpactBombvsMonster(Balloon balloon) {
        double b = (double) Math.round(Math.abs(this.getY() - balloon.getY()) * 10) / 10;
        double a = (double) Math.round(Math.abs(this.getX() - balloon.getX()) * 10) / 10;
        {
            Rectangle2D rec1 = new Rectangle2D(x * 32, y * 32, width * 0.9, height * 0.9);
            Rectangle2D rec2 = new Rectangle2D((double) Math.round(balloon.getX() * 10) / 10 * 32, (double) Math.round(balloon.getY() * 10) / 10 * 32, balloon.getWidth() * (double) 4 / 5, balloon.getHeight());
            if (rec1.intersects(rec2)) return 1;
        }
        return 0;
    }

    @Override
    public void update() {
        deadlineBomb--;
        // hoat anh bom
        img = Sprite.movingSprite(Sprite.bomb, Sprite.bomb_1, Sprite.bomb_2, deadlineBomb, Gameloop.time).getFxImage();

        if (deadlineBomb == 0) {
            isExploded = true;
            // tao lua

            for (int i = 0; i < MapSetup.getStillObjects().size(); i++) {
                if (MapSetup.getStillObjects().get(i) instanceof Brick) {
                    if (Math.abs(((int) MapSetup.getStillObjects().get(i).getX() - (int) this.getX())) <= 1 * sizeBomb
                            && (int) MapSetup.getStillObjects().get(i).getY() == (int) this.getY())
                        ((Brick) MapSetup.getStillObjects().get(i)).changeisBreaking();
                }
                if (MapSetup.getStillObjects().get(i) instanceof Brick) {
                    if (Math.abs((int) MapSetup.getStillObjects().get(i).getY() - (int) this.getY()) <= 1 * sizeBomb
                            && (int) MapSetup.getStillObjects().get(i).getX() == (int) this.getX())
                        ((Brick) MapSetup.getStillObjects().get(i)).changeisBreaking();
                }
            }
        }

        // hoat anh bom no
        if (isExploded) {
            img = Sprite.movingSprite(Sprite.bomb_exploded, Sprite.bomb_exploded1, Sprite.bomb_exploded2, deadlinebombExploding, Gameloop.time).getFxImage();
            deadlinebombExploding--;
            System.out.println(deadlinebombExploding);
        }
        if (deadlinebombExploding == 0) {
            MapSetup.getEntities().remove(this);
        }
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
