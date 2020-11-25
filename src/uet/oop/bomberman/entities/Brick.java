package uet.oop.bomberman.entities;

import javafx.scene.image.Image;

import java.awt.*;
import javafx.geometry.Rectangle2D;
public class Brick extends Entity {
    private double width, height;

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

