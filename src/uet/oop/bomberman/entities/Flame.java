package uet.oop.bomberman.entities;

import javafx.*;
import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.scene.Gameloop;
import uet.oop.bomberman.scene.MapSetup;

public class Flame extends Entity{
    private int timeleft = Gameloop.DeadLineofBreakingThings;
    private int Direction;
    private boolean isEnded;
    public Flame(double x, double y, Image img) {
        super(x, y, img);
    }

    @Override
    public void update() {
        if (!isEnded) {
            if (Direction == 0 || Direction == 1) {
                img = Sprite.movingSprite(Sprite.explosion_vertical, Sprite.explosion_vertical1, Sprite.explosion_vertical2, timeleft, Gameloop.time).getFxImage();
            } else {
                img = Sprite.movingSprite(Sprite.explosion_horizontal, Sprite.explosion_horizontal1, Sprite.explosion_horizontal2, timeleft, Gameloop.time).getFxImage();
            }
            timeleft--;
        } else {
            switch(Direction) {
                case 0:
                    img = Sprite.movingSprite(Sprite.explosion_vertical_top_last, Sprite.explosion_vertical_top_last1, Sprite.explosion_vertical_top_last2, timeleft, Gameloop.time).getFxImage();
                    break;
                case 1:
                    img = Sprite.movingSprite(Sprite.explosion_vertical_down_last, Sprite.explosion_vertical_down_last1, Sprite.explosion_vertical_down_last2, timeleft, Gameloop.time).getFxImage();
                    break;
                case 2:
                    img = Sprite.movingSprite(Sprite.explosion_horizontal_right_last, Sprite.explosion_horizontal_right_last1, Sprite.explosion_horizontal_right_last2, timeleft, Gameloop.time).getFxImage();
                    break;
                case 3:
                    img = Sprite.movingSprite(Sprite.explosion_horizontal_left_last, Sprite.explosion_horizontal_left_last1, Sprite.explosion_horizontal_left_last2, timeleft, Gameloop.time).getFxImage();
                    break;
            }
            timeleft--;
            //System.out.println("Flame ton tai: " + timeleft);
        }
        if (timeleft == 0) {
            MapSetup.getStillObjects().remove(this);
        }
    }

    public void setDirection(int a) {
        Direction = a;
    }
    public void setEnded(boolean a) {
        isEnded = a;
    }
}
