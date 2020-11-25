package uet.oop.bomberman.entities;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;

public class Item extends Entity{
    String type;
    public Item(int x, int y, Image img, String type) {
        super(x, y, img);
        this.type = type;
    }
    public int isImpactItemvsBomber(Bomber bomber){
        if (this.type.equals("f")) {
            if ((int) Math.round(bomber.getX()) == (int) Math.round(this.getX())
                    && (int) Math.round(bomber.getY()) == (int) Math.round(this.getY())) return 1;
            return 0;
        }
        return 1;
    }
    @Override
    public void update() {

    }
}
