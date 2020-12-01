package uet.oop.bomberman.entities;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import uet.oop.bomberman.sound.Sound;

public class Item extends Entity{
    public Sound sound = new Sound();
    String type;
    public Item(int x, int y, Image img, String type) {
        super(x, y, img);
        this.type = type;
    }
    public String isImpactItemvsBomber(Bomber bomber){
        if (this.type.equals("f")) {
            if ((int) Math.round(bomber.getX()) == (int) Math.round(this.getX())
                    && (int) Math.round(bomber.getY()) == (int) Math.round(this.getY())) {
                sound.makeSound("Get_Item.mp3", 8).play();
                return "f"; }
        }
        if (this.type.equals("s")) {
            if ((int) Math.round(bomber.getX()) == (int) Math.round(this.getX())
                    && (int) Math.round(bomber.getY()) == (int) Math.round(this.getY())) {
                sound.makeSound("Get_Item.mp3", 8).play();
                return "s"; }
        }
        if (this.type.equals("b")) {
            if ((int) Math.round(bomber.getX()) == (int) Math.round(this.getX())
                    && (int) Math.round(bomber.getY()) == (int) Math.round(this.getY())) {
                sound.makeSound("Get_Item.mp3", 8).play();
                return "b"; }
        }
        return "*";
    }
    @Override
    public void update() {

    }
}
