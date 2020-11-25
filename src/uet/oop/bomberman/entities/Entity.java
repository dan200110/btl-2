package uet.oop.bomberman.entities;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import uet.oop.bomberman.graphics.Sprite;
import javafx.scene.input.*;
import java.util.ArrayList;

public abstract class Entity {
    protected double x;
    protected double y;
    protected double width, height;
    protected int orient;
    protected Image img;
    public static final int LEFT = 1;
    public static final int RIGHT = 2;
    public static final int UP = 3;
    public static final int DOWN = 4;
    public Entity(double x, double y, Image img) {
        this.x = x;
        this.y = y;
        this.img = img;
        this.width = img.getWidth();
        this.height = img.getHeight();
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

    public int getOrient() {
        return orient;
    }
    public boolean move(ArrayList<Wall> arrBomb, ArrayList<Brick> arrBox){
        switch (orient) {
            case LEFT:
                if(x<=0){
                    return false;
                }
                x=x-0.1;
                for(int i=0;i<arrBomb.size();i++){
                    if(arrBomb.get(i).isImpactWallvsBomber((Bomber) this)==1){
                        x=x+0.1;
                        return false;
                    }
                }
                for(int i=0;i<arrBox.size();i++){
                    int kq = arrBox.get(i).isImpactBrickvsBomber((Bomber) this);
                    if(kq!=0){
                        if(kq>=-20 && kq<=20){
                            if(kq>0){
                                y=y+0.1;
                            }else{
                                y=y-0.1;
                            }
                        }
                        x=x+1;
                        return false;
                    }
                }
                break;
            case RIGHT:
                if(x>(675-width)){
                    return false;
                }
                x=x+0.1;
                for(int i=0;i<arrBomb.size();i++){
                    if(arrBomb.get(i).isImpactWallvsBomber((Bomber) this)==1){
                        x=x-0.1;
                        return false;
                    }
                }
                for(int i=0;i<arrBox.size();i++){
                    int kq = arrBox.get(i).isImpactBrickvsBomber((Bomber) this);
                    if(kq!=0){
                        if(kq>=-20 && kq<=20){
                            if(kq>0){
                                y=y+0.1;
                            }else{
                                y=y-0.1;
                            }
                        }
                        x=x-0.1;
                        return false;
                    }
                }
                break;
            case UP:
                if(y<=0){
                    return false;
                }
                y=y-0.1;
                for(int i=0;i<arrBomb.size();i++){
                    if(arrBomb.get(i).isImpactWallvsBomber((Bomber) this)==1){
                        y=y+0.1;
                        return false;
                    }
                }
                for(int i=0;i<arrBox.size();i++){
                    int kq = arrBox.get(i).isImpactBrickvsBomber((Bomber) this);
                    if(kq!=0){
                        if(kq>=-20 && kq<=20){
                            if(kq>0){
                                x=x+0.1;
                            }else{
                                x=x-0.1;
                            }
                        }
                        y=y+1;
                        return false;
                    }
                }
                break;
            case DOWN:
                if(y>=(25-height)){
                    return false;
                }
                y=y+0.1;
                for(int i=0;i<arrBomb.size();i++){
                    if(arrBomb.get(i).isImpactWallvsBomber((Bomber) this)==1){
                        y=y-0.1;
                        return false;
                    }
                }
                for(int i=0;i<arrBox.size();i++){
                    int kq = arrBox.get(i).isImpactBrickvsBomber((Bomber) this);
                    if(kq!=0){
                        if(kq>=-20 && kq<=20){
                            if(kq>0){
                                x=x+0.1;
                            }else{
                                x=x-0.1;
                            }
                        }
                        y=y-0.1;
                        return false;
                    }
                }
                break;

            default:
                break;
        }
        return true;
    }

    public void render(GraphicsContext gc) {
        gc.drawImage(img, x * Sprite.SCALED_SIZE, y * Sprite.SCALED_SIZE);
    }
    public abstract void update();
}
