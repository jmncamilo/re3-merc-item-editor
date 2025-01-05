package utilities;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.Objects;

public class MercSounds {
    private static MediaPlayer bgMusic; // MediaPlayer-object will not clean away since someone holds a reference to it
    private static AudioClip selectSound; // Same case, if not instantiates outside the method, garbage collector will clean it

    // Method that reproduces background music
    public static void playBackgroundMusic() {
        try {
            if (bgMusic == null) {
                String pathBgMusic = Objects.requireNonNull(MercSounds.class.getResource(Paths.BG_MUSIC)).toExternalForm();
                Media mediaBg = new Media(pathBgMusic);
                bgMusic = new MediaPlayer(mediaBg);
                bgMusic.setCycleCount(MediaPlayer.INDEFINITE);
            }

            if(bgMusic.getStatus() != MediaPlayer.Status.PLAYING) {
                bgMusic.play();
            }
        } catch (NullPointerException e) {
            System.err.println("Error: it cannot play background music.");
        } catch (Exception e) {
            System.err.println("Error when background music is played: " + e.getMessage());
        }
    }

    // Method that reproduces sound when file exe is selected
    public static void playSelectSound() {
        String pathSelectSound = Objects.requireNonNull(MercSounds.class.getResource(Paths.SELECT_SOUND)).toExternalForm();
        selectSound = new AudioClip(pathSelectSound);
        selectSound.play();
    }
}
