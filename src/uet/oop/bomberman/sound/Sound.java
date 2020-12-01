package uet.oop.bomberman.sound;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.net.URL;

public class Sound {
//    private MediaPlayer Ending = makeSound("Ending.mp3");
//    private MediaPlayer Walk = makeSound("Walk.mp3");
//    private MediaPlayer Make_Bomb = makeSound("Make_Bomb.mp3");
//    private MediaPlayer Get_Damege = makeSound("Get_Damage.mp3");
//    private MediaPlayer Bomb_Explodes = makeSound("Bomb_Explodes.mp3");
//    private MediaPlayer Game_Over = makeSound("Game_Over.mp3");
//    public MediaPlayer Level_Complete = makeSound("Level_Complete.mp3");
//    public MediaPlayer Level_Start = makeSound("Level_Start.mp3");
//   public MediaPlayer Kill_Enemy = makeSound("Kill_Enemy.mp3");
//    public MediaPlayer Get_Item = makeSound("Get_Item.mp3", 8);

    public void repeat(MediaPlayer mediaPlayer){
        mediaPlayer.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                mediaPlayer.seek(Duration.ZERO);
            }
        });
    }
    public MediaPlayer makeSound(String mp3, double volume){
        MediaPlayer mediaPlayer = makeSound(mp3);
        mediaPlayer.setVolume(volume);
        return mediaPlayer;
    }
    public MediaPlayer makeSound(String mp3){
        URL resource = Sound.class.getResource("/sound/");
        Media media = new Media(resource + mp3);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        return mediaPlayer;
    }
}
