package uet.oop.bomberman.scene;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import uet.oop.bomberman.controls.KeyController;
import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.graphics.Sprite;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MapSetup {
    static Scene s;
    static Group root;
    static Canvas canvas;
    static GraphicsContext gc;
    static Bomber bomberman;
    private static List<Entity> entities = new ArrayList<>();
    private static List<Entity> stillObjects = new ArrayList<>();
    private static ArrayList<Brick> brickArrayList = new ArrayList<>();
    private static ArrayList<Wall> wallArrayList = new ArrayList<>();
    private static List<Balloon> balloonList = new ArrayList<>();
    public static int WIDTH = 31 ;
    public static int HEIGHT = 13;

    public static void createMap() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("res/levels/Level1.txt"));
            String a = reader.readLine();
            String temp[] = a.split(" ");
            int level = Integer.valueOf(temp[0]);
            HEIGHT = Integer.valueOf(temp[1]);
            WIDTH = Integer.valueOf(temp[2])  ;
            for (int  y = 0; y < HEIGHT; y++) {
                String s = reader.readLine();
                for (int x = 0; x < WIDTH; x++) {
                    switch (s.charAt( (int) x)) {
                        case '#':
                            stillObjects.add(new Wall(x, y, Sprite.wall.getFxImage()));
                            wallArrayList.add(new Wall(x, y, Sprite.wall.getFxImage()));
                            break;
                        case '*':
                            stillObjects.add(new Grass(x, y, Sprite.grass.getFxImage()));
                            stillObjects.add(new Brick(x, y, Sprite.brick.getFxImage()));
                            brickArrayList.add(new Brick(x, y, Sprite.brick.getFxImage()));
                            break;
                        case '1':
                            stillObjects.add(new Grass(x, y, Sprite.grass.getFxImage()));
                            entities.add(new Balloon(x, y, Sprite.balloom_left1.getFxImage()));
                            balloonList.add(new Balloon(x, y, Sprite.balloom_left1.getFxImage()));
                            break;
                        case '2':
                            stillObjects.add(new Grass(x, y, Sprite.grass.getFxImage()));
                            entities.add(new Oneal(x, y, Sprite.oneal_left1.getFxImage()));
                            break;
                        case 'x':
                            stillObjects.add(new Grass(x, y, Sprite.grass.getFxImage()));
                            stillObjects.add(new Portal(x, y, Sprite.portal.getFxImage()));
                            stillObjects.add(new Brick(x, y, Sprite.brick.getFxImage()));
                            brickArrayList.add(new Brick(x, y, Sprite.brick.getFxImage()));
                            break;
                        case 'f':
                            stillObjects.add(new Grass(x, y, Sprite.grass.getFxImage()));
                            stillObjects.add(new Item(x, y, Sprite.powerup_flames.getFxImage(), "f"));
                            stillObjects.add(new Brick(x, y, Sprite.brick.getFxImage()));
                            brickArrayList.add(new Brick(x, y, Sprite.brick.getFxImage()));
                            break;
                        case 's':
                            stillObjects.add(new Grass(x, y, Sprite.grass.getFxImage()));
                            stillObjects.add(new Item(x, y, Sprite.powerup_speed.getFxImage(), "s"));
                            stillObjects.add(new Brick(x, y, Sprite.brick.getFxImage()));
                            brickArrayList.add(new Brick(x, y, Sprite.brick.getFxImage()));
                            break;
                        default:
                            stillObjects.add(new Grass(x, y, Sprite.grass.getFxImage()));
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println("Loi doc file");
        }
            bomberman = new Bomber(1, 1, Sprite.player_right.getFxImage());
            entities.add(bomberman);
        }
    public static void init() {
        canvas = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT);
        gc = canvas.getGraphicsContext2D();

        root = new Group();
        root.getChildren().add(canvas);

        s = new Scene(root);
        Gameloop.start(gc);

        createMap();
        KeyController.attach(s);
    }


    public static Scene getScene() {
        return s;
    }
    public static Bomber getBomber() {
        return bomberman;
    }
    public static List<Entity> getEntities() {
        return entities;
    }
    public static List<Entity> getStillObjects() {
        return stillObjects;
    }
    public static List<Balloon> getBalloonList(){
        return balloonList;
    }
    public static ArrayList<Wall> getWallArrayList() {return wallArrayList;}
}
