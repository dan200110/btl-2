package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.scene.Gameloop;
import uet.oop.bomberman.scene.MapSetup;

import java.util.List;
import java.util.Random;

public class Balloon extends Entity {
    private static int count = 10;
    public double speedBallon = 0.02;
    public Balloon(int x, int y, Image img) {
        super(x, y, img);
    }

    /*
        tao 1 hg ngau nhien

     */
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
        {
            if (this.move(a, MapSetup.getStillObjects(), MapSetup.getEntities()) == true) {
                move(a, MapSetup.getStillObjects(), MapSetup.getEntities());
            } else a = random.nextInt(4) + 1;
        }
    }
}
