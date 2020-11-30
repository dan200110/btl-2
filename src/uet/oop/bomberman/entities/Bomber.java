package uet.oop.bomberman.entities;

import javafx.application.Platform;
import javafx.scene.image.Image;

import javafx.scene.input.*;
import uet.oop.bomberman.Enemy.Balloon;
import uet.oop.bomberman.Enemy.Enemy;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.scene.Gameloop;
import uet.oop.bomberman.scene.MapSetup;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.util.ArrayList;
import java.util.List;

public class Bomber extends Entity {
    private int speed = 2;
    private int deadtime = Gameloop.DeadLineofBreakingThings + 3;
    public static int ALLOW_RUN = 0;
    public static int DISALLOW_RUN = 1;
    private boolean isDead = false;
    private int lives = 3;

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
            //System.out.println("Bomber: x: " + (double) Math.round(x * 10) / 10 + " , y: " + (double) Math.round(y * 10) / 10);
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
                    else if (((Item) stillObject.get(i)).isImpactItemvsBomber((Bomber)this)=="s"){
                        MapSetup.getStillObjects().remove(i);
                        this.speed++;
                    }
                    else if (((Item) stillObject.get(i)).isImpactItemvsBomber((Bomber)this)=="b"){
                        MapSetup.getStillObjects().remove(i);
                        Bomb.countBomb--;
                    }
                }
                else if (stillObject.get(i) instanceof Bomb) {
                    double b = (double) Math.round(-(stillObject.get(i).getY() - this.getY()) * 10) / 10;
                    double a = (double) Math.round(-(stillObject.get(i).getX() - this.getX()) * 10) / 10;
                    if (b <= 0.7) {

                    }
                    else if (((Bomb) stillObject.get(i)).isImpactBombvsBomber((Bomber) this) == 1) {
                        y = y + 0.025 * speed;
                        return;
                    }
                }
                else if (stillObject.get(i) instanceof Portal){
                    if (((Portal) stillObject.get(i)).isImpactPortalvsBomber((Bomber) this) == 1) {
                        int count = 0;
                        for (int k = 0; k < MapSetup.getEntities().size(); k++){
                            if (MapSetup.getEntities().get(k) instanceof Balloon){
                                count++;
                            }
                        }
                        System.out.println(count);
                        if (count == 0) {MapSetup.level="res/levels/Level2.txt";
                            MapSetup.changeMap();}
                    }
                }
            }

            img = Sprite.movingSprite(Sprite.player_up, Sprite.player_up_1, Sprite.player_up_2, Gameloop.animate, Gameloop.time).getFxImage();
        } else if (key == KeyCode.DOWN) {
            y = y + 0.025 * speed;
            //System.out.println("Bomber: x: " + (double) Math.round(x * 10) / 10 + " , y: " + (double) Math.round(y * 10) / 10);
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
                    if (((Item) stillObject.get(i)).isImpactItemvsBomber((Bomber)this).equals("f")){
                        MapSetup.getStillObjects().remove(stillObject.get(i));
                        Bomb.sizeBomb++;
                    }
                    else if (((Item) stillObject.get(i)).isImpactItemvsBomber((Bomber)this).equals("s")){
                        MapSetup.getStillObjects().remove(stillObject.get(i));
                        speed++;
                    }
                    else if (((Item) stillObject.get(i)).isImpactItemvsBomber((Bomber)this).equals("b")){
                        MapSetup.getStillObjects().remove(stillObject.get(i));
                        Bomb.countBomb--;
                    }
                }
                else if (stillObject.get(i) instanceof Bomb) {
                    double b = (double) Math.round((stillObject.get(i).getY() - this.getY()) * 10) / 10;
                    double a = (double) Math.round(-(stillObject.get(i).getX() - this.getX()) * 10) / 10;
                    if (b <= 0.7) {

                    }
                    else if (((Bomb) stillObject.get(i)).isImpactBombvsBomber((Bomber) this) == 1) {
                        y = y - 0.025 * speed;
                        return;
                    }
                }
                else if (stillObject.get(i) instanceof Portal){
                    if (((Portal) stillObject.get(i)).isImpactPortalvsBomber((Bomber) this) == 1) {
                        int count = 0;
                        for (int k = 0; k < MapSetup.getEntities().size(); k++){
                            if (MapSetup.getEntities().get(k) instanceof Balloon){
                                count++;
                            }
                        }
                        System.out.println(count);
                        if (count == 0) {MapSetup.level="res/levels/Level2.txt";
                            MapSetup.changeMap();}
                    }
                }
            }
            img = Sprite.movingSprite(Sprite.player_down, Sprite.player_down_1, Sprite.player_down_2, Gameloop.animate, Gameloop.time).getFxImage();
        } else if (key == KeyCode.LEFT) {
            x = x - 0.025 * speed;
            //System.out.println("Bomber: x: " + (double) Math.round(x * 10) / 10 + " , y: " + (double) Math.round(y * 10) / 10);
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
                    if (((Item) stillObject.get(i)).isImpactItemvsBomber((Bomber)this).equals("f")){
                        MapSetup.getStillObjects().remove(stillObject.get(i));
                        Bomb.sizeBomb++;
                    }
                    else if (((Item) stillObject.get(i)).isImpactItemvsBomber((Bomber)this).equals("s")){
                        MapSetup.getStillObjects().remove(stillObject.get(i));
                        speed++;
                    }
                    else if (((Item) stillObject.get(i)).isImpactItemvsBomber((Bomber)this).equals("b")){
                        MapSetup.getStillObjects().remove(stillObject.get(i));
                        Bomb.countBomb--;
                    }
                }
                else if (stillObject.get(i) instanceof Bomb) {
                    double b = (double) Math.round(-(stillObject.get(i).getY() - this.getY()) * 10) / 10;
                    double a = (double) Math.round(-(stillObject.get(i).getX() - this.getX()) * 10) / 10;
                    if (a <= 0.7) {

                    }
                    else if (((Bomb) stillObject.get(i)).isImpactBombvsBomber((Bomber) this) == 1) {
                        x = x + 0.025 * speed;
                        return;
                    }
                }
                else if (stillObject.get(i) instanceof Portal){
                    if (((Portal) stillObject.get(i)).isImpactPortalvsBomber((Bomber) this) == 1) {
                        int count = 0;
                        for (int k = 0; k < MapSetup.getEntities().size(); k++){
                            if (MapSetup.getEntities().get(k) instanceof Balloon){
                                count++;
                            }
                        }
                        System.out.println(count);
                        if (count == 0) {MapSetup.level="res/levels/Level2.txt";
                            MapSetup.changeMap();}
                    }
                }
            }
            img = Sprite.movingSprite(Sprite.player_left, Sprite.player_left_1, Sprite.player_left_2, Gameloop.animate, Gameloop.time).getFxImage();
        } else if (key == KeyCode.RIGHT) {
            x = x + 0.025 * speed;
            //System.out.println("Bomber: x: " + (double) Math.round(x * 10) / 10 + " , y: " + (double) Math.round(y * 10) / 10);
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
                    else if (((Item) stillObject.get(i)).isImpactItemvsBomber((Bomber)this)=="s"){
                        MapSetup.getStillObjects().remove(i);
                        this.speed++;
                    }
                    else if (((Item) stillObject.get(i)).isImpactItemvsBomber((Bomber)this)=="b"){
                        MapSetup.getStillObjects().remove(i);
                        Bomb.countBomb--;
                    }
                }
                else if (stillObject.get(i) instanceof Bomb) {
                    double b = (double) Math.round(-(stillObject.get(i).getY() - this.getY()) * 10) / 10;
                    double a = (double) Math.round((stillObject.get(i).getX() - this.getX()) * 10) / 10;
                    if (a < 0.7) {

                    }
                    else if (((Bomb) stillObject.get(i)).isImpactBombvsBomber((Bomber) this) == 1) {
                        x = x - 0.025 * speed;
                        return;
                    }
                }
                else if (stillObject.get(i) instanceof Portal){
                    if (((Portal) stillObject.get(i)).isImpactPortalvsBomber((Bomber) this) == 1) {
                        int count = 0;
                        for (int k = 0; k < MapSetup.getEntities().size(); k++){
                            if (MapSetup.getEntities().get(k) instanceof Balloon){
                                count++;
                            }
                        }
                        System.out.println(count);
                        if (count == 0) {MapSetup.level="res/levels/Level2.txt";
                            MapSetup.changeMap();}
                    }
                }
            }
            img = Sprite.movingSprite(Sprite.player_right, Sprite.player_right_1, Sprite.player_right_2, Gameloop.animate, Gameloop.time).getFxImage();
        }
    }

    public void checkDamage() {
        for(int i = 0; i < MapSetup.getEntities().size(); i++) {
            if(MapSetup.getEntities().get(i) instanceof Enemy) {
                Enemy enemy = (Enemy) MapSetup.getEntities().get(i);
                if(Math.round(enemy.getX()) == Math.round(x) && Math.round(enemy.getY()) == Math.round(y)) {
                    this.restart();
                    break;
                 }
            }
        }
        for(int i = 0; i < MapSetup.getStillObjects().size(); i++) {
            if(MapSetup.getStillObjects().get(i) instanceof Flame) {
                Flame flame = (Flame) MapSetup.getStillObjects().get(i);
                if(Math.round(flame.getX()) == Math.round(x) && Math.round(flame.getY()) == Math.round(y)) {
                    this.restart();
                    return;
                }
            }
            if(MapSetup.getStillObjects().get(i) instanceof Bomb) {
                Bomb bomb = (Bomb) MapSetup.getStillObjects().get(i);
                if(Math.round(bomb.getX()) == Math.round(x) && Math.round(bomb.getY()) == Math.round(y)) {
                    if (bomb.deadlineBomb <0 ) {
                        this.restart();
                        return;
                    }
                }
            }
        }
    }

    public void restart() {
        isDead = true;
    }

    @Override
    public void update() {
        checkDamage();
        if (isDead) {
            deadtime--;
            img = Sprite.movingSprite(Sprite.player_dead1, Sprite.player_dead2, Sprite.player_dead3, deadtime, Gameloop.time).getFxImage();
            if (deadtime <= 0) {
                lives--;
                if (lives > 0) {
                    this.x = 1;
                    this.y = 1;
                    isDead = false;
                    deadtime = Gameloop.DeadLineofBreakingThings + 3;
                    img = Sprite.player_right.getFxImage();
                } else if (deadtime < -5) {
                    Platform.exit();
                    System.exit(0);
                }

            }
        }
    }

}
