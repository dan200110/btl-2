package uet.oop.bomberman.entities;

import javafx.scene.image.Image;

import javafx.geometry.Rectangle2D;
import uet.oop.bomberman.Enemy.Balloon;
import uet.oop.bomberman.Enemy.Oneal;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.scene.Gameloop;
import uet.oop.bomberman.scene.MapSetup;

public class Brick extends Entity {
    private double width, height;
    public boolean isBreaking = false;
    private boolean afterBreakingAnimation = false;
    private int deadlinebrickBreaking = Gameloop.DeadLineofBreakingThings;

    public Brick(double x, double y, Image img) {
        super(x, y, img);
        this.width =  img.getWidth();
        this.height =  img.getHeight();
    }

    public int isImpactBrickvsBomber(Bomber bomber){
        Rectangle2D rec1 = new Rectangle2D(x * 32, y * 32, width , height);
        Rectangle2D rec2 = new Rectangle2D((double)Math.round(bomber.getX()*10)/10 * 32, (double)Math.round(bomber.getY()*10)/10 * 32, bomber.getWidth() * (double) 4/5, bomber.getHeight());
        if(rec1.intersects(rec2)) return 1;
        return 0;
    }
    public int isImpactBrickvsBomber(Balloon balloon){
        Rectangle2D rec1 = new Rectangle2D(x * 32, y * 32, width, height);
        Rectangle2D rec2 = new Rectangle2D((double)Math.round(balloon.getX()*10)/10 * 32, (double)Math.round(balloon.getY()*10)/10 * 32, balloon.getWidth(), balloon.getHeight());
        if(rec1.intersects(rec2)) return 1;
        return 0;
    }
    public int isImpactBrickvsBomber(Oneal oneal){
        Rectangle2D rec1 = new Rectangle2D(x * 32, y * 32, width, height);
        Rectangle2D rec2 = new Rectangle2D((double)Math.round(oneal.getX()*10)/10 * 32, (double)Math.round(oneal.getY()*10)/10 * 32, oneal.getWidth(), oneal.getHeight());
        if(rec1.intersects(rec2)) return 1;
        return 0;
    }
    @Override
    public void update() {
        if (isBreaking) {
            if (Sprite.movingSprite(Sprite.brick_exploded, Sprite.brick_exploded1, Sprite.brick_exploded2, deadlinebrickBreaking, Gameloop.time) == Sprite.brick_exploded2) {
                isBreaking = false;
                afterBreakingAnimation = true;
            }
            img = Sprite.movingSprite(Sprite.brick_exploded, Sprite.brick_exploded1, Sprite.brick_exploded2, deadlinebrickBreaking, Gameloop.time).getFxImage();
            deadlinebrickBreaking--;
        }
        if (afterBreakingAnimation) {
            deadlinebrickBreaking--;
        }
        if (deadlinebrickBreaking <= 0) {
            MapSetup.getStillObjects().remove(this);
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

    public void changeisBreaking() {
        if (isBreaking == false) isBreaking = true;
        else {
            isBreaking = false;
        }
    }
}

