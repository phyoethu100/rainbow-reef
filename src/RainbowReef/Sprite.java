package RainbowReef;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Sprite {

    private BufferedImage[] image;
    private int height, width;
    private String sprite;

    public Sprite (String sprite, int width, int height) throws IOException {
        this.sprite = sprite;
        this.width = width;
        this.height = height;
        this.drawImages();
    }

    public BufferedImage getFrame (int frame) {
        return this.image[frame];
    }

    public int count() {
        return this.image.length;
    }

    private void drawImages() throws IOException {
        BufferedImage graphic = ImageIO.read(new File(sprite));
        this.image = new BufferedImage[graphic.getWidth()/width];

        int frame = 0;
        while (frame < this.image.length) {
            this.image[frame] = graphic.getSubimage(frame * this.width, 0, this.width, this.height);
            frame++;
        }
    }

}
