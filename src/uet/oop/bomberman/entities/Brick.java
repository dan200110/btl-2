package uet.oop.bomberman.entities;

import javafx.scene.image.Image;

import java.awt.*;
import javafx.geometry.Rectangle2D;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.scene.Gameloop;
import uet.oop.bomberman.scene.MapSetup;

public class Brick extends Entity {
    private double width, height;
    public boolean isBreaking = false;
    private int deadlinebrickBreaking = 100 / 16;

    public Brick(double x, double y, Image img) {
        super(x, y, img);
        this.width =  img.getWidth();
        this.height =  img.getHeight();
    }

    public int isImpactBrickvsMonster(Bomber bomber){
        Rectangle2D rec1 = new Rectangle2D(x * 32, y * 32, width * 0.9, height*0.9);
        Rectangle2D rec2 = new Rectangle2D((double)Math.round(bomber.getX()*10)/10 * 32, (double)Math.round(bomber.getY()*10)/10 * 32, bomber.getWidth() * (double) 4/5, bomber.getHeight());
        if(rec1.intersects(rec2)) return 1;
        return 0;
    }
    public int isImpactBrickvsMonster(Balloon balloon){
        Rectangle2D rec1 = new Rectangle2D(x * 32, y * 32, width * 0.9, height*0.9);
        Rectangle2D rec2 = new Rectangle2D((double)Math.round(balloon.getX()*10)/10 * 32, (double)Math.round(balloon.getY()*10)/10 * 32, balloon.getWidth() * (double) 4/5, balloon.getHeight());
        if(rec1.intersects(rec2)) return 1;
        return 0;
    }
    @Override
    public void update() {
        if (isBreaking) {
            img = Sprite.movingSprite(Sprite.brick_exploded, Sprite.brick_exploded1, Sprite.brick_exploded2, deadlinebrickBreaking, Gameloop.time).getFxImage();
            deadlinebrickBreaking--;
            System.out.println(deadlinebrickBreaking);
        }
        if (deadlinebrickBreaking == 0) {
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

