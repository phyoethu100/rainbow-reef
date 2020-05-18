package RainbowReef;

import javax.swing.*;
import java.io.IOException;

public class Frame extends JFrame {

    private GameWorld game;

    public Frame() throws IOException {
        this.game = new GameWorld();
        this.add(this.game);

        setTitle("Super Rainbow Reef");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 480);
        setVisible(true);
        setResizable(false);
    }

}