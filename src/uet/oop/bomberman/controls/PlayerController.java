package uet.oop.bomberman.controls;

import javafx.scene.input.KeyCode;
import uet.oop.bomberman.entities.Bomb;
import uet.oop.bomberman.entities.Bomber;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.scene.MapSetup;
import uet.oop.bomberman.sound.Sound;

import java.util.*;



public class PlayerController {
    public static void handlePlayerMovements() {
        Sound sound = new Sound();
        List keyboardInputs = KeyController.getUserInput();
        Bomber player = MapSetup.getBomber();
        if (keyboardInputs.contains(KeyCode.UP)) {
            player.move(KeyCode.UP, MapSetup.getStillObjects(), MapSetup.getEntities());
        }
        if (keyboardInputs.contains(KeyCode.DOWN)) {
            player.move(KeyCode.DOWN,MapSetup.getStillObjects(), MapSetup.getEntities());
        }
        if (keyboardInputs.contains(KeyCode.LEFT)) {
            player.move(KeyCode.LEFT, MapSetup.getStillObjects(), MapSetup.getEntities());
        }
        if (keyboardInputs.contains(KeyCode.RIGHT)) {
            player.move(KeyCode.RIGHT, MapSetup.getStillObjects(), MapSetup.getEntities());
        }
        if (keyboardInputs.contains(KeyCode.SPACE)) {
            boolean exist = false;
            for(int i = 0; i < MapSetup.getStillObjects().size(); i++) {
                if(MapSetup.getStillObjects().get(i) instanceof Bomb
                        && (int) Math.round(MapSetup.getStillObjects().get(i).getX()) == (int) Math.round(player.getX())
                        && (int) Math.round(MapSetup.getStillObjects().get(i).getY()) == (int) Math.round(player.getY())) {
                    exist = true;
                }
                if(exist) break;
            }
            if(!exist && Bomb.countBomb < 2) {
                sound.makeSound("Make_Bomb.mp3", 100).play();
                MapSetup.getStillObjects().add(new Bomb(Math.round(player.getX()), Math.round(player.getY()), Sprite.bomb.getFxImage()));
                Bomb.countBomb++;

            }
        }
    }

}
