package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.scene.Gameloop;
import uet.oop.bomberman.scene.MapSetup;

import java.util.List;
import java.util.Random;

public class Balloon extends Entity{
    public Balloon(int x, int y, Image img) {
        super(x, y, img);
    }
    /*
        tao 1 hg ngau nhien

     */
    private Random random = new Random();
    public void move(int orient, List<Entity> stillObject, List<Entity> entities) {
        if (orient == 1) {
            if (y <= 0) {
                return;
            }
            y = y - 0.5;

            for (int i = 0; i < stillObject.size(); i++) {
                if (stillObject.get(i) instanceof Wall) {
                    if (((Wall) stillObject.get(i)).isImpactWallvsBomber((Balloon)this) == 1) {
                        y = y + 0.5;
                        return;
                    }
                }
                if (stillObject.get(i) instanceof Brick) {
                    if (((Brick) stillObject.get(i)).isImpactBrickvsBomber((Balloon) this) == 1) {
                        y = y + 0.5;
                        return;
                    }
                }
            }

            for (int i = 0; i < entities.size(); i++) {
                if (entities.get(i) instanceof Bomb) {
                    if (((Bomb) entities.get(i)).isImpactBombvsMonster((Balloon) this) == 1) {
                        y = y + 0.5;
                        return;
                    }
                }
            }
            img = Sprite.movingSprite(Sprite.balloom_left1, Sprite.balloom_left2, Sprite.balloom_left3, Gameloop.animate, Gameloop.time).getFxImage();
        } else if (orient == 2) {
            y = y + 0.5;

            for (int i = 0; i < stillObject.size(); i++) {
                if (stillObject.get(i) instanceof Wall) {
                    if (((Wall) stillObject.get(i)).isImpactWallvsBomber((Balloon)this) == 1) {
                        y = y - 0.5;
                        return;
                    }
                }
                if (stillObject.get(i) instanceof Brick) {
                    if (((Brick) stillObject.get(i)).isImpactBrickvsBomber((Balloon)this) == 1) {
                        y = y - 0.5;
                        return;
                    }
                }
            }
            img = Sprite.movingSprite(Sprite.balloom_right1, Sprite.balloom_right2, Sprite.balloom_right3, Gameloop.animate, Gameloop.time).getFxImage();
        } else if (orient == 3) {
            x = x - 0.5;

            for (int i = 0; i < stillObject.size(); i++) {
                if (stillObject.get(i) instanceof Wall) {
                    if (((Wall) stillObject.get(i)).isImpactWallvsBomber((Balloon)this) == 1) {
                        x = x + 0.5;
                        return;
                    }
                }
                if (stillObject.get(i) instanceof Brick) {
                    if (((Brick) stillObject.get(i)).isImpactBrickvsBomber((Balloon)this) == 1) {
                        x = x + 0.5;
                        return;
                    }
                }
            }
            img = Sprite.movingSprite(Sprite.balloom_left1, Sprite.balloom_left2, Sprite.balloom_left3, Gameloop.animate, Gameloop.time).getFxImage();
        } else if (orient == 4) {
            x = x + 0.5;

            for (int i = 0; i < stillObject.size(); i++) {
                if (stillObject.get(i) instanceof Wall) {
                    if (((Wall) stillObject.get(i)).isImpactWallvsBomber((Balloon)this) == 1) {
                        x = x - 0.5;
                        return;
                    }
                }
                if (stillObject.get(i) instanceof Brick) {
                    if (((Brick) stillObject.get(i)).isImpactBrickvsBomber((Balloon)this) == 1) {
                        x = x - 0.5;
                        return;
                    }
                }
            }
            img = Sprite.movingSprite(Sprite.balloom_right1, Sprite.balloom_right2, Sprite.balloom_right3, Gameloop.animate, Gameloop.time).getFxImage();
        }
    }
    @Override
    public void update() {
         {
            int x = random.nextInt(4) + 1;
            this.move(x, MapSetup.getStillObjects(), MapSetup.getEntities());

        }
    }
}
