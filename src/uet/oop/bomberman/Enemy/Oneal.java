package uet.oop.bomberman.Enemy;

import javafx.scene.image.Image;
import uet.oop.bomberman.astar.AStarAlgorithm;
import uet.oop.bomberman.astar.AStarCell;
import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.scene.Gameloop;
import uet.oop.bomberman.scene.MapSetup;
import uet.oop.bomberman.sound.Sound;

import java.util.ArrayList;
import java.util.List;

public class Oneal extends Enemy {
    public Sound sound = new Sound();
    public double speedOneal = 0.02;
    private int deadtime = Gameloop.DeadLineofBreakingThings*2;
    private boolean isDead = false;
    int orient = 2;
    int check = 1;
    AStarAlgorithm aStarAlgorithm = new AStarAlgorithm();

    public Oneal(int x, int y, Image img) {
        super(x, y, img);

    }

    public void FindingAlgorithm() {
        check = 0;
        List<AStarCell> orientMove = aStarAlgorithm.getPath(MapSetup.grid, MapSetup.grid.getCell((int) Math.round(x), (int) Math.round(y)), MapSetup.grid.getCell(MapSetup.getBomber().getXSpecial(), MapSetup.getBomber().getYSpecial()));
        if (!orientMove.isEmpty()) {
            if (x - orientMove.get(0).getCol() > 1) orient = 3;
            else if (x - orientMove.get(0).getCol() < -1) orient = 4;
            else if (y - orientMove.get(0).getCol() > 1) orient = 1;
            else if (y - orientMove.get(0).getCol() < -1) orient = 2;
        }
    }

    public boolean move(int orient, List<Entity> stillObject, List<Entity> entities) {
        if (orient == 1) {
            if (y <= 0) {
                return false;
            }
            y = y - speedOneal;


            for (int i = 0; i < stillObject.size(); i++) {
                if (stillObject.get(i) instanceof Wall) {
                    if (((Wall) stillObject.get(i)).isImpactWallvsBomber((Oneal) this) == 1) {
                        y = y + speedOneal;
                        return false;
                    }
                }
                if (stillObject.get(i) instanceof Brick) {
                    if (((Brick) stillObject.get(i)).isImpactBrickvsBomber((Oneal) this) == 1) {
                        y = y + speedOneal;
                        return false;
                    }
                }
                if (stillObject.get(i) instanceof Bomb) {
                    double b = (double) Math.round(-(stillObject.get(i).getY() - this.getY()) * 10) / 10;
                    double a = (double) Math.round(-(stillObject.get(i).getX() - this.getX()) * 10) / 10;
                    if (b <= 0.7) {

                    }
                    else if (((Bomb) stillObject.get(i)).isImpactBombvsMonster((Oneal) this) == 1) {
                        y = y + speedOneal;
                        return false;
                    }
                }

            }
            img = Sprite.movingSprite(Sprite.oneal_left1, Sprite.oneal_left2, Sprite.oneal_left3, Gameloop.animate, Gameloop.time).getFxImage();
            return true;
        } else if (orient == 2) {
            y = y + speedOneal;

            for (int i = 0; i < stillObject.size(); i++) {
                if (stillObject.get(i) instanceof Wall) {
                    if (((Wall) stillObject.get(i)).isImpactWallvsBomber((Oneal) this) == 1) {
                        y = y - speedOneal;
                        return false;
                    }
                }
                if (stillObject.get(i) instanceof Brick) {
                    if (((Brick) stillObject.get(i)).isImpactBrickvsBomber((Oneal) this) == 1) {
                        y = y - speedOneal;
                        return false;
                    }
                }
                if (stillObject.get(i) instanceof Bomb) {
                    double b = (double) Math.round((stillObject.get(i).getY() - this.getY()) * 10) / 10;
                    double a = (double) Math.round(-(stillObject.get(i).getX() - this.getX()) * 10) / 10;
                    if (b <= 0.7) {

                    }
                    else if (((Bomb) stillObject.get(i)).isImpactBombvsMonster((Oneal) this) == 1) {
                        y = y - speedOneal;
                        return false;
                    }
                }
            }
            img = Sprite.movingSprite(Sprite.oneal_right1, Sprite.oneal_right2, Sprite.oneal_right3, Gameloop.animate, Gameloop.time).getFxImage();
            return true;
        } else if (orient == 3) {
            x = x - speedOneal;

            for (int i = 0; i < stillObject.size(); i++) {
                if (stillObject.get(i) instanceof Wall) {
                    if (((Wall) stillObject.get(i)).isImpactWallvsBomber((Oneal) this) == 1) {
                        x = x + speedOneal;
                        return false;
                    }
                }
                if (stillObject.get(i) instanceof Brick) {
                    if (((Brick) stillObject.get(i)).isImpactBrickvsBomber((Oneal) this) == 1) {
                        x = x + speedOneal;
                        return false;
                    }
                }
                if (stillObject.get(i) instanceof Bomb) {
                    double b = (double) Math.round(-(stillObject.get(i).getY() - this.getY()) * 10) / 10;
                    double a = (double) Math.round(-(stillObject.get(i).getX() - this.getX()) * 10) / 10;
                    if (a <= 0.7) {

                    }
                    else if (((Bomb) stillObject.get(i)).isImpactBombvsMonster((Oneal) this) == 1) {
                        x = x + speedOneal;
                        return false;
                    }
                }
            }
            img = Sprite.movingSprite(Sprite.oneal_left1, Sprite.oneal_left2, Sprite.oneal_left3, Gameloop.animate, Gameloop.time).getFxImage();
            return true;
        } else if (orient == 4) {
            x = x + speedOneal;

            for (int i = 0; i < stillObject.size(); i++) {
                if (stillObject.get(i) instanceof Wall) {
                    if (((Wall) stillObject.get(i)).isImpactWallvsBomber((Oneal) this) == 1) {
                        x = x - speedOneal;
                        return false;
                    }
                }
                if (stillObject.get(i) instanceof Brick) {
                    if (((Brick) stillObject.get(i)).isImpactBrickvsBomber((Oneal) this) == 1) {
                        x = x - speedOneal;
                        return false;
                    }
                }
                if (stillObject.get(i) instanceof Bomb) {
                    double b = (double) Math.round(-(stillObject.get(i).getY() - this.getY()) * 10) / 10;
                    double a = (double) Math.round((stillObject.get(i).getX() - this.getX()) * 10) / 10;
                    if (a < 0.7) {

                    }
                    else if (((Bomb) stillObject.get(i)).isImpactBombvsMonster((Oneal) this) == 1) {
                        x = x - speedOneal;
                        return false;
                    }
                }
            }
            img = Sprite.movingSprite(Sprite.oneal_right1, Sprite.oneal_right2, Sprite.oneal_right3, Gameloop.animate, Gameloop.time).getFxImage();
            return true;
        }
        return true;
    }

    @Override
    public void update() {
        if (check == 1) FindingAlgorithm();
        if (!isDead) {
            if (this.move(orient, MapSetup.getStillObjects(), MapSetup.getEntities()) == true) {
                move(orient, MapSetup.getStillObjects(), MapSetup.getEntities());
            }

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
                img = Sprite.oneal_dead.getFxImage();
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
    }
}
