package uet.oop.bomberman.entities;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.scene.Gameloop;
import uet.oop.bomberman.scene.MapSetup;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Bomb extends Entity {
    private double width, height;
    private int deadlineBomb = 2000 / 16;
    private int deadlinebombExploding = Gameloop.DeadLineofBreakingThings;
    public static int sizeBomb = 1;
    public static int countBomb = 1;
    private boolean isExploded = false;
    public Bomb(double x, double y, Image img) {
        super(x, y, img);
        this.width = img.getWidth();
        this.height = img.getHeight();
    }

    public int isImpactBombvsBomber(Bomber bomber) {
        double b = (double) Math.round(Math.abs(this.getY() - bomber.getY()) * 10) / 10;
        double a = (double) Math.round(Math.abs(this.getX() - bomber.getX()) * 10) / 10;
        {
            Rectangle2D rec1 = new Rectangle2D(x * 32, y * 32, width * 0.9, height * 0.9);
            Rectangle2D rec2 = new Rectangle2D((double) Math.round(bomber.getX() * 10) / 10 * 32, (double) Math.round(bomber.getY() * 10) / 10 * 32, bomber.getWidth() * (double) 4 / 5, bomber.getHeight());
            if (rec1.intersects(rec2)) return 1;
        }
        return 0;
    }
    public int isImpactBombvsMonster(Balloon balloon) {
        {
            Rectangle2D rec1 = new Rectangle2D(x * 32, y * 32, width * 0.9, height * 0.9);
            Rectangle2D rec2 = new Rectangle2D((double) Math.round(balloon.getX() * 10) / 10 * 32, (double) Math.round(balloon.getY() * 10) / 10 * 32, balloon.getWidth() * (double) 4 / 5, balloon.getHeight());
            if (rec1.intersects(rec2)) return 1;
        }
        return 0;
    }

    @Override
    public void update() {
        deadlineBomb--;
        // hoat anh bom
        img = Sprite.movingSprite(Sprite.bomb, Sprite.bomb_1, Sprite.bomb_2, deadlineBomb, Gameloop.time).getFxImage();

        if (deadlineBomb == 0) {
            isExploded = true;
            // tao lua
            /* Y tuong:
            - Lua chay theo 4 huong
            + Gap tuong thi dung lai
            + Gap brick thi Brick.destroy() va dung lai
            + Gap bomb thi no bomb va dung lai
            */
            for(int i = 0; i < 4; i++) {
                makeFire(i);
                System.out.println("Make fire");
            }

//            for (int i = 0; i < MapSetup.getStillObjects().size(); i++) {
//                if (MapSetup.getStillObjects().get(i) instanceof Brick) {
//                    if (Math.abs(((int) MapSetup.getStillObjects().get(i).getX() - (int) this.getX())) <= 1 * sizeBomb
//                            && (int) MapSetup.getStillObjects().get(i).getY() == (int) this.getY())
//                        ((Brick) MapSetup.getStillObjects().get(i)).changeisBreaking();
//                }
//                if (MapSetup.getStillObjects().get(i) instanceof Brick) {
//                    if (Math.abs((int) MapSetup.getStillObjects().get(i).getY() - (int) this.getY()) <= 1 * sizeBomb
//                            && (int) MapSetup.getStillObjects().get(i).getX() == (int) this.getX())
//                        ((Brick) MapSetup.getStillObjects().get(i)).changeisBreaking();
//                }
//            }
            Bomb.countBomb--;
        }

        // hoat anh bom no
        if (isExploded) {
            img = Sprite.movingSprite(Sprite.bomb_exploded, Sprite.bomb_exploded1, Sprite.bomb_exploded2, deadlinebombExploding, Gameloop.time).getFxImage();
            deadlinebombExploding--;
            //System.out.println(deadlinebombExploding);
        }
        if (deadlinebombExploding == 0) {
            MapSetup.getStillObjects().remove(this);
        }
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    //--
    private void makeFire(int direct) {
        int vertical = 0, horizotal = 0;
        boolean stop = false;
        for(int j = 1; j <= sizeBomb; j++) {
            Image img = Sprite.grass.getFxImage();
            boolean setEnded = false;
            switch (direct) {
                case 0: // up
                    vertical = -1;
                    if(j == sizeBomb) {
                        img = Sprite.explosion_vertical_top_last.getFxImage();
                        setEnded = true;
                    }
                    else img = Sprite.explosion_vertical.getFxImage();
                    break;
                case 1: // down
                    vertical = 1;
                    if(j == sizeBomb) {
                        img = Sprite.explosion_vertical_down_last.getFxImage();
                        setEnded = true;
                    }
                    else img = Sprite.explosion_vertical.getFxImage();
                    break;
                case 2: // right
                    horizotal = 1;
                    if(j == sizeBomb) {
                        img = Sprite.explosion_horizontal_right_last.getFxImage();
                        setEnded = true;
                    }
                    else img = Sprite.explosion_horizontal.getFxImage();
                    break;
                case 3: // left
                    horizotal = -1;
                    if(j == sizeBomb) {
                        img = Sprite.explosion_horizontal_left_last.getFxImage();
                        setEnded = true;
                    }
                    else img = Sprite.explosion_horizontal.getFxImage();
                    break;
            }
            Flame flame = new Flame((int) x + horizotal*j, (int) y + vertical*j, img);
            flame.setDirection(direct);
            flame.setEnded(setEnded);
            //Rectangle2D flameRect = new Rectangle2D((int)flame.x, (int)flame.y , Sprite.SCALED_SIZE, Sprite.SCALED_SIZE);
            for(int k = 0; k < MapSetup.getStillObjects().size(); k++) {
                Entity still = MapSetup.getStillObjects().get(k);
                if((int)flame.x == (int)still.getX() && (int)flame.y == (int)still.getY()) {
                    if (still instanceof Wall) {
                        stop = true;
                        break;
                    }
                    if (still instanceof Brick) {
                        stop = true;
                        ((Brick) MapSetup.getStillObjects().get(k)).changeisBreaking();
                        break;
                    }
//                    if (still instanceof Bomb) {
//                        ((Bomb) still).deadlineBomb = 1;
//                        stop = true;
//                        break;
//                    }
                    }
//                //if(flameRect.intersects(new Rectangle2D(still.x, still.y, Sprite.SCALED_SIZE, Sprite.SCALED_SIZE))) {
//            }
                    for (int i = 0; i < MapSetup.getEntities().size(); i++) {
                        Entity entity = MapSetup.getEntities().get(i);
                        if ((Math.abs((int) flame.x - ((int) entity.getX())) < (int) sizeBomb
                                && Math.abs((int) flame.y) == Math.abs((int) entity.getY()))
                                || (Math.abs((int) flame.y - ((int) entity.getY())) <= sizeBomb
                                && Math.abs((int) flame.x) == Math.abs((int) entity.getX()))) {
                            if ((int) flame.x == (int) entity.getX() && (int) flame.y == (int) entity.getY()) {
                                if (entity instanceof Oneal) {
                                    MapSetup.getEntities().remove(i);
                                }
                            }
                            if (Math.abs((int) flame.y - ((int) entity.getY())) <= sizeBomb
                                    && Math.abs((int) flame.x) == Math.abs((int) entity.getX())) {

                                if (entity instanceof Balloon) {
                                    MapSetup.getEntities().remove(i);
                                }
                                if (entity instanceof Oneal) {
                                    MapSetup.getEntities().remove(i);
                                }

                            }
                        }
                    }

            }
            if(!stop) {
                MapSetup.getStillObjects().add(flame);
            }
            else break;
        }
    }
}
