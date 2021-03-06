package uet.oop.bomberman.scene;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import uet.oop.bomberman.controls.PlayerController;
import uet.oop.bomberman.entities.Bomber;
import uet.oop.bomberman.entities.Entity;

public class Gameloop {
    public static int time = 24;
    public static int DeadLineofBreakingThings = 400 / 16;
    public static int animate;
    public static Stage stage;
    private static void update() {
        PlayerController.handlePlayerMovements();
        for(int i = 0; i < MapSetup.getEntities().size(); i++) {
            MapSetup.getEntities().get(i).update();
        }
        for(int i = 0; i < MapSetup.getStillObjects().size(); i++) {
            MapSetup.getStillObjects().get(i).update();
        }
        //MapSetup.getEntities().forEach(Entity::update);
    }

    private static void render(GraphicsContext gc) {
        gc.clearRect(0, 0, MapSetup.WIDTH, MapSetup.HEIGHT);
        MapSetup.getStillObjects().forEach(g -> g.render(gc));
        MapSetup.getEntities().forEach(g -> g.render(gc));
    }

    public static void start(GraphicsContext gc) {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                handleTitle();
                render(gc);
                update();
                if (animate < time) animate++;
                else animate = 0;
            }
        };
        timer.start();
    }

    public static void setStage(Stage st) {
        stage = st;
    }

    public static void handleTitle() {
        stage.setTitle("Lives: " + Bomber.lives + "                 Levels: " + MapSetup.map);
    }
}
