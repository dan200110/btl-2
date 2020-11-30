package uet.oop.bomberman;

import javafx.application.Application;
import javafx.stage.Stage;
import uet.oop.bomberman.scene.MapSetup;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.applet.Applet;
import java.net.URL;

public class BombermanGame extends Application {

    @Override
    public void start(Stage stage) {
        URL url = BombermanGame.class.getResource("/sound/Ending.mp3");
        System.out.println(String.valueOf(url));
        Media media = new Media(String.valueOf(url));
        new MediaPlayer(media).play();
        System.out.println();
        MapSetup.init();

        stage.setScene(MapSetup.getScene());
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(BombermanGame.class);
    }
}
