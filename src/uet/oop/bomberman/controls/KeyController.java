package uet.oop.bomberman.controls;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.*;

public class KeyController {
    public static ArrayList<KeyCode> userInput = new ArrayList<>();

    public static void attach(Scene s){
        keyReleaseHanlder krh = new keyReleaseHanlder();
        keyPressedHandler kph = new keyPressedHandler();
        s.setOnKeyReleased(krh);
        s.setOnKeyPressed(kph);
    }

    public static List getUserInput(){
        return userInput;
    }
}
class keyReleaseHanlder implements EventHandler<KeyEvent>{
    public keyReleaseHanlder() {
    }
    @Override
    public void handle(KeyEvent evt) {
        //System.out.println("The key released is : "+evt.getText()+" with keycode "+evt.getCode().getName());

        KeyCode code = evt.getCode();

        if ( KeyController.userInput.contains(code) )
            KeyController.userInput.remove( code );
    }
}
class keyPressedHandler implements EventHandler<KeyEvent> {
    @Override
    public void handle(KeyEvent evt) {
        //System.out.println("The key pressed is : "+evt.getText()+" with keycode "+evt.getCode().getName());
        KeyCode code = evt.getCode();

        // only add once... prevent duplicates
        if (!KeyController.userInput.contains(code))
            KeyController.userInput.add(code);
    }
}
