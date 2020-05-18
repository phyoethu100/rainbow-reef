package RainbowReef;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class LevelTwo extends Image {

    private BufferedImage image;
    private int height, width;

    public LevelTwo() throws IOException {
        image = ImageIO.read(new File ("resources/stars.jpg"));
        this.height = image.getHeight();
        this.width = image.getWidth();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void repaint(Graphics graphic) {
        graphic.drawImage(image, (int) getImageX(), (int) getImageY(), null);
    }

}