package uet.oop.bomberman;

import javafx.application.Application;
import javafx.stage.Stage;
import uet.oop.bomberman.scene.MapSetup;

public class BombermanGame extends Application {
    @Override
    public void start(Stage stage) {
        MapSetup.init();
        stage.setScene(MapSetup.getScene());
        stage.show();
        /* abc */
        //dasdasd
    }

    public static void main(String[] args) {
        Application.launch(BombermanGame.class);
    }
}
