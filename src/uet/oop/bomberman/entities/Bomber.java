package uet.oop.bomberman.entities;

import javafx.scene.image.Image;

import javafx.scene.input.*;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.scene.Gameloop;
import uet.oop.bomberman.scene.MapSetup;

import java.util.ArrayList;
import java.util.List;

public class Bomber extends Entity {
    private int speed = 2;
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
            y = y - 0.025 * speed;
            System.out.println("Bomber: x: " + (double) Math.round(x * 10) / 10 + " , y: " + (double) Math.round(y * 10) / 10);
            for (int i = 0; i < stillObject.size(); i++) {
                if (stillObject.get(i) instanceof Wall) {
                    if (((Wall) stillObject.get(i)).isImpactWallvsBomber((Bomber)this) == 1) {
                        y = y + 0.025 * speed;
                        return;
                    }
                }
                if (stillObject.get(i) instanceof Brick) {
                    if (((Brick) stillObject.get(i)).isImpactBrickvsBomber((Bomber)this) == 1) {
                        y = y + 0.025 * speed;
                        return;
                    }
                }
                if (stillObject.get(i) instanceof Item){
                    if (((Item) stillObject.get(i)).isImpactItemvsBomber((Bomber)this)=="f"){
                        MapSetup.getStillObjects().remove(i);
                        Bomb.sizeBomb++;
                    }
                    if (((Item) stillObject.get(i)).isImpactItemvsBomber((Bomber)this)=="s"){
                        MapSetup.getStillObjects().remove(i);
                        this.speed++;
                    }
                    if (((Item) stillObject.get(i)).isImpactItemvsBomber((Bomber)this)=="b"){
                        MapSetup.getStillObjects().remove(i);
                        Bomb.countBomb--;
                    }
                }
                if (stillObject.get(i) instanceof Bomb) {
                    double b = (double) Math.round(-(stillObject.get(i).getY() - this.getY()) * 10) / 10;
                    double a = (double) Math.round(-(stillObject.get(i).getX() - this.getX()) * 10) / 10;
                    if (b <= 0.7) {

                    }
                    else if (((Bomb) stillObject.get(i)).isImpactBombvsBomber((Bomber) this) == 1) {
                        y = y + 0.025 * speed;
                        return;
                    }
                }
            }

            img = Sprite.movingSprite(Sprite.player_up, Sprite.player_up_1, Sprite.player_up_2, Gameloop.animate, Gameloop.time).getFxImage();
        } else if (key == KeyCode.DOWN) {
            y = y + 0.025 * speed;
            System.out.println("Bomber: x: " + (double) Math.round(x * 10) / 10 + " , y: " + (double) Math.round(y * 10) / 10);
            for (int i = 0; i < stillObject.size(); i++) {
                if (stillObject.get(i) instanceof Wall) {
                    if (((Wall) stillObject.get(i)).isImpactWallvsBomber((Bomber)this) == 1) {
                        y = y - 0.025 * speed;
                        return;
                    }
                }
                if (stillObject.get(i) instanceof Brick) {
                    if (((Brick) stillObject.get(i)).isImpactBrickvsBomber((Bomber)this) == 1) {
                        y = y - 0.025 * speed;
                        return;
                    }
                }
                if (stillObject.get(i) instanceof Item){
                    if (((Item) stillObject.get(i)).isImpactItemvsBomber((Bomber)this)=="f"){
                        MapSetup.getStillObjects().remove(i);
                        Bomb.sizeBomb++;
                    }
                    if (((Item) stillObject.get(i)).isImpactItemvsBomber((Bomber)this)=="s"){
                        MapSetup.getStillObjects().remove(i);
                        this.speed++;
                    }
                    if (((Item) stillObject.get(i)).isImpactItemvsBomber((Bomber)this)=="b"){
                        MapSetup.getStillObjects().remove(i);
                        Bomb.countBomb--;
                    }
                }
                if (stillObject.get(i) instanceof Bomb) {
                    double b = (double) Math.round((stillObject.get(i).getY() - this.getY()) * 10) / 10;
                    double a = (double) Math.round(-(stillObject.get(i).getX() - this.getX()) * 10) / 10;
                    if (b <= 0.7) {

                    }
                    else if (((Bomb) stillObject.get(i)).isImpactBombvsBomber((Bomber) this) == 1) {
                        y = y - 0.025 * speed;
                        return;
                    }
                }
            }
            img = Sprite.movingSprite(Sprite.player_down, Sprite.player_down_1, Sprite.player_down_2, Gameloop.animate, Gameloop.time).getFxImage();
        } else if (key == KeyCode.LEFT) {
            x = x - 0.025 * speed;
            System.out.println("Bomber: x: " + (double) Math.round(x * 10) / 10 + " , y: " + (double) Math.round(y * 10) / 10);
            for (int i = 0; i < stillObject.size(); i++) {
                if (stillObject.get(i) instanceof Wall) {
                    if (((Wall) stillObject.get(i)).isImpactWallvsBomber((Bomber)this) == 1) {
                        x = x + 0.025 * speed;
                        return;
                    }
                }
                if (stillObject.get(i) instanceof Brick) {
                    if (((Brick) stillObject.get(i)).isImpactBrickvsBomber((Bomber)this) == 1) {
                        x = x + 0.025 * speed;
                        return;
                    }
                }
                if (stillObject.get(i) instanceof Item){
                    if (((Item) stillObject.get(i)).isImpactItemvsBomber((Bomber)this)=="f"){
                        MapSetup.getStillObjects().remove(i);
                        Bomb.sizeBomb++;
                    }
                    if (((Item) stillObject.get(i)).isImpactItemvsBomber((Bomber)this)=="s"){
                        MapSetup.getStillObjects().remove(i);
                        this.speed++;
                    }
                    if (((Item) stillObject.get(i)).isImpactItemvsBomber((Bomber)this)=="b"){
                        MapSetup.getStillObjects().remove(i);
                        Bomb.countBomb--;
                    }
                }
                if (stillObject.get(i) instanceof Bomb) {
                    double b = (double) Math.round(-(stillObject.get(i).getY() - this.getY()) * 10) / 10;
                    double a = (double) Math.round(-(stillObject.get(i).getX() - this.getX()) * 10) / 10;
                    if (a <= 0.7) {

                    }
                    else if (((Bomb) stillObject.get(i)).isImpactBombvsBomber((Bomber) this) == 1) {
                        x = x + 0.025 * speed;
                        return;
                    }
                }
            }
            img = Sprite.movingSprite(Sprite.player_left, Sprite.player_left_1, Sprite.player_left_2, Gameloop.animate, Gameloop.time).getFxImage();
        } else if (key == KeyCode.RIGHT) {
            x = x + 0.025 * speed;
            System.out.println("Bomber: x: " + (double) Math.round(x * 10) / 10 + " , y: " + (double) Math.round(y * 10) / 10);
            for (int i = 0; i < stillObject.size(); i++) {
                if (stillObject.get(i) instanceof Wall) {
                    if (((Wall) stillObject.get(i)).isImpactWallvsBomber((Bomber)this) == 1) {
                        x = x - 0.025 * speed;
                        return;
                    }
                }
                if (stillObject.get(i) instanceof Brick) {
                    if (((Brick) stillObject.get(i)).isImpactBrickvsBomber((Bomber)this) == 1) {
                        x = x - 0.025 * speed;
                        return;
                    }
                }
                if (stillObject.get(i) instanceof Item){
                    if (((Item) stillObject.get(i)).isImpactItemvsBomber((Bomber)this)=="f"){
                        MapSetup.getStillObjects().remove(i);
                        Bomb.sizeBomb++;
                    }
                    if (((Item) stillObject.get(i)).isImpactItemvsBomber((Bomber)this)=="s"){
                        MapSetup.getStillObjects().remove(i);
                        this.speed++;
                    }
                    if (((Item) stillObject.get(i)).isImpactItemvsBomber((Bomber)this)=="b"){
                        MapSetup.getStillObjects().remove(i);
                        Bomb.countBomb--;
                    }
                }
                if (stillObject.get(i) instanceof Bomb) {
                    double b = (double) Math.round(-(stillObject.get(i).getY() - this.getY()) * 10) / 10;
                    double a = (double) Math.round((stillObject.get(i).getX() - this.getX()) * 10) / 10;
                    if (a < 0.7) {

                    }
                    else if (((Bomb) stillObject.get(i)).isImpactBombvsBomber((Bomber) this) == 1) {
                        x = x - 0.025 * speed;
                        return;
                    }
                }
            }
            img = Sprite.movingSprite(Sprite.player_right, Sprite.player_right_1, Sprite.player_right_2, Gameloop.animate, Gameloop.time).getFxImage();
        }
    }


    @Override
    public void update() {
    }

}
