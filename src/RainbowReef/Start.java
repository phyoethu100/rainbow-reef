package RainbowReef;

import java.io.IOException;
import javax.swing.*;

public class Start extends JFrame {

    public static void main (String[] args) {

        System.out.println("Welcome to Super Rainbow Reef!");

        try {
            Sound music = new Sound();
            music.playForever("resources/Music.wav");
            new Frame();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

}

