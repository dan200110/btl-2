package uet.oop.bomberman.Enemy;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.scene.Gameloop;
import uet.oop.bomberman.scene.MapSetup;
import uet.oop.bomberman.sound.Sound;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class Balloon extends Enemy {
    //private static int count = 10;
    public Sound sound = new Sound();
    public double speedBallon = 0.02;
    private int deadtime = Gameloop.DeadLineofBreakingThings*2;
    private boolean isDead = false;
    public Balloon(int x, int y, Image img) {
        super(x, y, img);
    }

    /*
        tao 1 hg ngau nhien

     */
    public static int countBallon = 3;
    private Random random = new Random();

    public boolean move(int orient, List<Entity> stillObject, List<Entity> entities) {
        if (orient == 1) {
            if (y <= 0) {
                return false;
            }
            y = y - speedBallon;


            for (int i = 0; i < stillObject.size(); i++) {
                if (stillObject.get(i) instanceof Wall) {
                    if (((Wall) stillObject.get(i)).isImpactWallvsBomber((Balloon) this) == 1) {
                        y = y + speedBallon;
                        return false;
                    }
                }
                if (stillObject.get(i) instanceof Brick) {
                    if (((Brick) stillObject.get(i)).isImpactBrickvsBomber((Balloon) this) == 1) {
                        y = y + speedBallon;
                        return false;
                    }
                }
                if (stillObject.get(i) instanceof Bomb) {
                    double b = (double) Math.round(-(stillObject.get(i).getY() - this.getY()) * 10) / 10;
                    double a = (double) Math.round(-(stillObject.get(i).getX() - this.getX()) * 10) / 10;
                    if (b <= 0.7) {

                    }
                    else if (((Bomb) stillObject.get(i)).isImpactBombvsMonster((Balloon) this) == 1) {
                        y = y + speedBallon;
                        return false;
                    }
                }

            }
            img = Sprite.movingSprite(Sprite.balloom_left1, Sprite.balloom_left2, Sprite.balloom_left3, Gameloop.animate, Gameloop.time).getFxImage();
            return true;
        } else if (orient == 2) {
            y = y + speedBallon;

            for (int i = 0; i < stillObject.size(); i++) {
                if (stillObject.get(i) instanceof Wall) {
                    if (((Wall) stillObject.get(i)).isImpactWallvsBomber((Balloon) this) == 1) {
                        y = y - speedBallon;
                        return false;
                    }
                }
                if (stillObject.get(i) instanceof Brick) {
                    if (((Brick) stillObject.get(i)).isImpactBrickvsBomber((Balloon) this) == 1) {
                        y = y - speedBallon;
                        return false;
                    }
                }
                if (stillObject.get(i) instanceof Bomb) {
                    double b = (double) Math.round((stillObject.get(i).getY() - this.getY()) * 10) / 10;
                    double a = (double) Math.round(-(stillObject.get(i).getX() - this.getX()) * 10) / 10;
                    if (b <= 0.7) {

                    }
                    else if (((Bomb) stillObject.get(i)).isImpactBombvsMonster((Balloon) this) == 1) {
                        y = y - speedBallon;
                        return false;
                    }
                }
            }
            img = Sprite.movingSprite(Sprite.balloom_right1, Sprite.balloom_right2, Sprite.balloom_right3, Gameloop.animate, Gameloop.time).getFxImage();
            return true;
        } else if (orient == 3) {
            x = x - speedBallon;

            for (int i = 0; i < stillObject.size(); i++) {
                if (stillObject.get(i) instanceof Wall) {
                    if (((Wall) stillObject.get(i)).isImpactWallvsBomber((Balloon) this) == 1) {
                        x = x + speedBallon;
                        return false;
                    }
                }
                if (stillObject.get(i) instanceof Brick) {
                    if (((Brick) stillObject.get(i)).isImpactBrickvsBomber((Balloon) this) == 1) {
                        x = x + speedBallon;
                        return false;
                    }
                }
                if (stillObject.get(i) instanceof Bomb) {
                    double b = (double) Math.round(-(stillObject.get(i).getY() - this.getY()) * 10) / 10;
                    double a = (double) Math.round(-(stillObject.get(i).getX() - this.getX()) * 10) / 10;
                    if (a <= 0.7) {

                    }
                    else if (((Bomb) stillObject.get(i)).isImpactBombvsMonster((Balloon) this) == 1) {
                        x = x + speedBallon;
                        return false;
                    }
                }
            }
            img = Sprite.movingSprite(Sprite.balloom_left1, Sprite.balloom_left2, Sprite.balloom_left3, Gameloop.animate, Gameloop.time).getFxImage();
            return true;
        } else if (orient == 4) {
            x = x + speedBallon;

            for (int i = 0; i < stillObject.size(); i++) {
                if (stillObject.get(i) instanceof Wall) {
                    if (((Wall) stillObject.get(i)).isImpactWallvsBomber((Balloon) this) == 1) {
                        x = x - speedBallon;
                        return false;
                    }
                }
                if (stillObject.get(i) instanceof Brick) {
                    if (((Brick) stillObject.get(i)).isImpactBrickvsBomber((Balloon) this) == 1) {
                        x = x - speedBallon;
                        return false;
                    }
                }
                if (stillObject.get(i) instanceof Bomb) {
                    double b = (double) Math.round(-(stillObject.get(i).getY() - this.getY()) * 10) / 10;
                    double a = (double) Math.round((stillObject.get(i).getX() - this.getX()) * 10) / 10;
                    if (a < 0.7) {

                    }
                    else if (((Bomb) stillObject.get(i)).isImpactBombvsMonster((Balloon) this) == 1) {
                        x = x - speedBallon;
                        return false;
                    }
                }
            }
            img = Sprite.movingSprite(Sprite.balloom_right1, Sprite.balloom_right2, Sprite.balloom_right3, Gameloop.animate, Gameloop.time).getFxImage();
            return true;
        }
        return true;
    }

    int a = 3;

    @Override
    public void update() {
        if (!isDead) {
            if (this.move(a, MapSetup.getStillObjects(), MapSetup.getEntities()) == true) {
                move(a, MapSetup.getStillObjects(), MapSetup.getEntities());
            } else a = random.nextInt(4) + 1;
            for (int i = 0; i < MapSetup.getStillObjects().size(); i++) {
                if (MapSetup.getStillObjects().get(i) instanceof Flame) {
                    Flame flame = (Flame) MapSetup.getStillObjects().get(i);
                    if (Math.round(flame.getX()) == Math.round(this.x) && Math.round(flame.getY()) == Math.round(this.y)) {
                        destroy();
                    }
                }
                if (MapSetup.getStillObjects().get(i) instanceof Bomb) {
                    Bomb bomb = (Bomb) MapSetup.getStillObjects().get(i);
                    if (Math.round(bomb.getX()) == Math.round(this.x) && Math.round(bomb.getY()) == Math.round(this.y)) {
                        if (bomb.deadlineBomb < 0) destroy();
                    }
                }
            }
        } else {
            deadtime--;
            if (deadtime > Gameloop.DeadLineofBreakingThings) {
                img = Sprite.balloom_dead.getFxImage();
            } else {
                img = Sprite.movingSprite(Sprite.mob_dead1, Sprite.mob_dead2, Sprite.mob_dead3, deadtime, Gameloop.time).getFxImage();
            }
            if (deadtime <= 0) {
                MapSetup.getEntities().remove(this);
            }
        }
    }

    public void destroy() {
        sound.makeSound("Kill_Enemy.mp3", 8).play();
        isDead = true;
        countBallon--;

    }
}
