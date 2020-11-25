package uet.oop.bomberman.entities;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;

public class Item extends Entity{
    public Item(int x, int y, Image img) {
        super(x, y, img);
    }
    public int isImpactItemvsBomber(Bomber bomber){
        if ((int)Math.round(bomber.getX())==(int)Math.round(this.getX())
        && (int)Math.round(bomber.getY())==(int)Math.round(this.getY())) return 1;
        return 0;
    }
    @Override
    public void update() {

    }
}
