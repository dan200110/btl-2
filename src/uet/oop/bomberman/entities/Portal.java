package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.Enemy.Balloon;
public class Portal extends Entity{
    public Portal(int x, int y, Image img) {
        super(x, y, img);
    }
    public static boolean isOpen = false;
    @Override
    public void update() {

    }
    public int isImpactPortalvsBomber(Bomber bomber) {
        if ((int) Math.round(bomber.getX()) == (int) Math.round(this.getX())
                && (int) Math.round(bomber.getY()) == (int) Math.round(this.getY())) {
            return 1;
        }
        return 0;
    }

}
