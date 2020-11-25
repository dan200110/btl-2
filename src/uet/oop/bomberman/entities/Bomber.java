package uet.oop.bomberman.entities;

import javafx.scene.image.Image;

import javafx.scene.input.*;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.scene.MapSetup;
import uet.oop.bomberman.entities.Bomb;
import java.util.ArrayList;
import java.util.List;

public class Bomber extends Entity {
    private double speed = 0.5;
    public static int ALLOW_RUN = 0;
    public static int DISALLOW_RUN = 1;

    public Bomber(double x, double y, Image img) {
        super(x, y, img);
    }

    @Override
    public boolean move(ArrayList<Wall> arrBomb, ArrayList<Brick> arrBox) {
        return super.move(arrBomb, arrBox);
    }

    public void move(KeyCode key, List<Entity> stillObject, List<Entity> entities) {
        if (key == KeyCode.UP) {
            if (y <= 0) {
                return;
            }
            y = y - 0.1;
            System.out.println("Bomber: x: " + (double) Math.round(x * 10) / 10 + " , y: " + (double) Math.round(y * 10) / 10);
            for (int i = 0; i < stillObject.size(); i++) {
                if (stillObject.get(i) instanceof Wall) {
                    if (((Wall) stillObject.get(i)).isImpactWallvsBomber((Bomber)this) == 1) {
                        y = y + 0.1;
                        return;
                    }
                }
                if (stillObject.get(i) instanceof Brick) {
                    if (((Brick) stillObject.get(i)).isImpactBrickvsBomber((Bomber)this) == 1) {
                        y = y + 0.1;
                        return;
                    }
                }
                if (stillObject.get(i) instanceof Item){
                    if (((Item) stillObject.get(i)).isImpactItemvsBomber((Bomber)this)==1){
                        MapSetup.getStillObjects().remove(i);
                    }
                }
            }

            for (int i = 0; i < entities.size(); i++) {
                if (entities.get(i) instanceof Bomb) {
                    if (((Bomb) entities.get(i)).isImpactBombvsBomber((Bomber) this) == 1) {
                        y = y + 0.1;
                        return;
                    }
                }
            }
        } else if (key == KeyCode.DOWN) {
            y = y + 0.1;
            System.out.println("Bomber: x: " + (double) Math.round(x * 10) / 10 + " , y: " + (double) Math.round(y * 10) / 10);
            for (int i = 0; i < stillObject.size(); i++) {
                if (stillObject.get(i) instanceof Wall) {
                    if (((Wall) stillObject.get(i)).isImpactWallvsBomber((Bomber)this) == 1) {
                        y = y - 0.1;
                        return;
                    }
                }
                if (stillObject.get(i) instanceof Brick) {
                    if (((Brick) stillObject.get(i)).isImpactBrickvsBomber((Bomber)this) == 1) {
                        y = y - 0.1;
                        return;
                    }
                }
                if (stillObject.get(i) instanceof Item){
                    if (((Item) stillObject.get(i)).isImpactItemvsBomber((Bomber)this)==1){
                        MapSetup.getStillObjects().remove(i);

                    }
                }
            }
            img = Sprite.player_down.getFxImage();
        } else if (key == KeyCode.LEFT) {
            x = x - 0.1;
            System.out.println("Bomber: x: " + (double) Math.round(x * 10) / 10 + " , y: " + (double) Math.round(y * 10) / 10);
            for (int i = 0; i < stillObject.size(); i++) {
                if (stillObject.get(i) instanceof Wall) {
                    if (((Wall) stillObject.get(i)).isImpactWallvsBomber((Bomber)this) == 1) {
                        x = x + 0.1;
                        return;
                    }
                }
                if (stillObject.get(i) instanceof Brick) {
                    if (((Brick) stillObject.get(i)).isImpactBrickvsBomber((Bomber)this) == 1) {
                        x = x + 0.1;
                        return;
                    }
                }
                if (stillObject.get(i) instanceof Item){
                    if (((Item) stillObject.get(i)).isImpactItemvsBomber((Bomber)this)==1){
                        MapSetup.getStillObjects().remove(i);
                    }
                }
            }
            img = Sprite.player_left.getFxImage();
        } else if (key == KeyCode.RIGHT) {
            x = x + 0.1;
            System.out.println("Bomber: x: " + (double) Math.round(x * 10) / 10 + " , y: " + (double) Math.round(y * 10) / 10);
            for (int i = 0; i < stillObject.size(); i++) {
                if (stillObject.get(i) instanceof Wall) {
                    if (((Wall) stillObject.get(i)).isImpactWallvsBomber((Bomber)this) == 1) {
                        x = x - 0.1;
                        return;
                    }
                }
                if (stillObject.get(i) instanceof Brick) {
                    if (((Brick) stillObject.get(i)).isImpactBrickvsBomber((Bomber)this) == 1) {
                        x = x - 0.1;
                        return;
                    }
                }
                if (stillObject.get(i) instanceof Item){
                    if (((Item) stillObject.get(i)).isImpactItemvsBomber((Bomber)this)==1){
                        MapSetup.getStillObjects().remove(i);
                    }
                }
            }
            img = Sprite.player_right.getFxImage();
        }
    }


    @Override
    public void update() {
    }

}
