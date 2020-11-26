package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.scene.Gameloop;
import uet.oop.bomberman.scene.MapSetup;

import java.util.List;
import java.util.Random;

public class Balloon extends Entity{
    private static int count = 10;
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
            y = y - 0.025;

            for (int i = 0; i < stillObject.size(); i++) {
                if (stillObject.get(i) instanceof Wall) {
                    if (((Wall) stillObject.get(i)).isImpactWallvsBomber((Balloon)this) == 1) {
                        y = y + 0.025;
                        return false;
                    }
                }
                if (stillObject.get(i) instanceof Brick) {
                    if (((Brick) stillObject.get(i)).isImpactBrickvsBomber((Balloon) this) == 1) {
                        y = y + 0.025;
                        return false;
                    }
                }
            }

            for (int i = 0; i < entities.size(); i++) {
                if (entities.get(i) instanceof Bomb) {
                    if (((Bomb) entities.get(i)).isImpactBombvsMonster((Balloon) this) == 1) {
                        y = y + 0.025;
                        return false;
                    }
                }
            }
            img = Sprite.movingSprite(Sprite.balloom_left1, Sprite.balloom_left2, Sprite.balloom_left3, Gameloop.animate, Gameloop.time).getFxImage();
            return true;
        } else if (orient == 2) {
            y = y + 0.025;

            for (int i = 0; i < stillObject.size(); i++) {
                if (stillObject.get(i) instanceof Wall) {
                    if (((Wall) stillObject.get(i)).isImpactWallvsBomber((Balloon)this) == 1) {
                        y = y - 0.025;
                        return false;
                    }
                }
                if (stillObject.get(i) instanceof Brick) {
                    if (((Brick) stillObject.get(i)).isImpactBrickvsBomber((Balloon)this) == 1) {
                        y = y - 0.025;
                        return false;
                    }
                }
            }
            img = Sprite.movingSprite(Sprite.balloom_right1, Sprite.balloom_right2, Sprite.balloom_right3, Gameloop.animate, Gameloop.time).getFxImage();
            return true;
        } else if (orient == 3) {
            x = x - 0.025;

            for (int i = 0; i < stillObject.size(); i++) {
                if (stillObject.get(i) instanceof Wall) {
                    if (((Wall) stillObject.get(i)).isImpactWallvsBomber((Balloon)this) == 1) {
                        x = x + 0.025;
                        return false;
                    }
                }
                if (stillObject.get(i) instanceof Brick) {
                    if (((Brick) stillObject.get(i)).isImpactBrickvsBomber((Balloon)this) == 1) {
                        x = x + 0.025;
                        return false;
                    }
                }
            }
            img = Sprite.movingSprite(Sprite.balloom_left1, Sprite.balloom_left2, Sprite.balloom_left3, Gameloop.animate, Gameloop.time).getFxImage();
            return true;
        } else if (orient == 4) {
            x = x + 0.025;

            for (int i = 0; i < stillObject.size(); i++) {
                if (stillObject.get(i) instanceof Wall) {
                    if (((Wall) stillObject.get(i)).isImpactWallvsBomber((Balloon)this) == 1) {
                        x = x - 0.025;
                        return false;
                    }
                }
                if (stillObject.get(i) instanceof Brick) {
                    if (((Brick) stillObject.get(i)).isImpactBrickvsBomber((Balloon)this) == 1) {
                        x = x - 0.025;
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
            if (this.move(a, MapSetup.getStillObjects(), MapSetup.getEntities())==true){
                move(a, MapSetup.getStillObjects(), MapSetup.getEntities());
            }
            else a = random.nextInt(4) + 1;
        }
    }
}
