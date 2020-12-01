package uet.oop.bomberman.entities;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import uet.oop.bomberman.Enemy.Balloon;
import uet.oop.bomberman.Enemy.Oneal;

public class Wall extends Entity {

    public Wall(double x, double y, Image img) {
        super(x, y, img);
    }
    public int isImpactWallvsBomber(Bomber bomber){
        Rectangle2D rec1 = new Rectangle2D(x * 32, y * 32, width , height);
        Rectangle2D rec2 = new Rectangle2D((double)Math.round(bomber.getX()*10)/10 * 32, (double)Math.round(bomber.getY()*10)/10 * 32, bomber.getWidth() * (double) 4/5, bomber.getHeight());
        if(rec1.intersects(rec2)) return 1;
        return 0;
    }
    public int isImpactWallvsBomber(Balloon balloon){
        Rectangle2D rec1 = new Rectangle2D(x * 32, y * 32, width, height);
        Rectangle2D rec2 = new Rectangle2D((double)Math.round(balloon.getX()*10)/10 * 32, (double)Math.round(balloon.getY()*10)/10 * 32, balloon.getWidth(), balloon.getHeight());
        if(rec1.intersects(rec2)) return 1;
        return 0;
    }
    public int isImpactWallvsBomber(Oneal oneal){
        Rectangle2D rec1 = new Rectangle2D(x * 32, y * 32, width, height);
        Rectangle2D rec2 = new Rectangle2D((double)Math.round(oneal.getX()*10)/10 * 32, (double)Math.round(oneal.getY()*10)/10 * 32, oneal.getWidth(), oneal.getHeight());
        if(rec1.intersects(rec2)) return 1;
        return 0;
    }
    @Override
    public void update() {

    }
}
