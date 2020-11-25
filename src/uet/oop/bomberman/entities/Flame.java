package uet.oop.bomberman.entities;

import javafx.*;
import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.scene.MapSetup;

public class Flame extends Entity{
    private int timeleft = 500/16;
    public Flame(double x, double y, Image img) {
        super(x, y, img);
    }

    @Override
    public void update() {
        timeleft--;
        if(timeleft == 0) {
            MapSetup.getStillObjects().remove(this);
        }
    }
}
