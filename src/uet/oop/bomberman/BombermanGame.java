package uet.oop.bomberman;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;
import uet.oop.bomberman.entities.Bomber;
import uet.oop.bomberman.scene.Gameloop;
import uet.oop.bomberman.scene.MapSetup;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.applet.Applet;
import java.net.URL;

public class BombermanGame extends Application {

    @Override
    public void start(Stage stage) {
        URL url = BombermanGame.class.getResource("/sound/Invincibility.mp3");
        Media media = new Media(String.valueOf(url));
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(0.1);
        mediaPlayer.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                mediaPlayer.seek(Duration.ZERO);
            }
        });
        mediaPlayer.play();
        MapSetup.init();

        Gameloop.setStage(stage);
        stage.setScene(MapSetup.getScene());
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(BombermanGame.class);
    }
}
