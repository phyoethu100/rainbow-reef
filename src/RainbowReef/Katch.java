package RainbowReef;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.IOException;

public class Katch extends Image {

    private ImageObserver observer;
    private int height, width, frame;
    private int lives = 4;
    private Sprite sprite;

    public Katch(Sprite sprite, ImageObserver observer, double x, double y) throws IOException {
        this.sprite = sprite;
        this.observer = observer;
        this.frame = 0;
        this.setImageX(x);
        this.setImageY(y);
        this.setDisplay(true);
        this.height = sprite.getFrame(0).getHeight();
        this.width = sprite.getFrame(0).getWidth();
    }

    public boolean checkCollision() {
        boolean collision = false;
        double leftKatch, rightKatch;

        leftKatch = this.getImageX();
        rightKatch = this.getImageX() + 80;

        if (leftKatch <= 20 || rightKatch >= 620) {
            collision = true;
        }

        return collision;
    }

    public void resetKatch() {
        this.setImageX(280);
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getFrame() {
        return frame;
    }

    public int getLives() {
        return lives;
    }

    public Sprite getSprite() {
        return this.sprite;
    }

    public void repaint(Graphics graphics) {
        graphics.drawImage(this.sprite.getFrame(frame), (int) getImageX(), (int) getImageY(), observer);
    }

}

