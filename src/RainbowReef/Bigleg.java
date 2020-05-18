package RainbowReef;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class Bigleg extends Image implements Observer {

    private ImageObserver observer;
    private int frame, height, width;
    private Sprite sprite;

    public Bigleg (Sprite sprite, ImageObserver observer) throws IOException {
        this.sprite = sprite;
        this.observer = observer;
        this.width = sprite.getFrame(0).getWidth();
        this.height = sprite.getFrame(0).getHeight();
        this.setDisplay(true);
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getFrame() {
        return frame;
    }

    public Sprite getSprite() {
        return this.sprite;
    }

    public void repaint(Graphics graphics) {
        graphics.drawImage(this.sprite.getFrame(frame), (int) getImageX(), (int) getImageY(), observer);
    }

    @Override
    public void update(Observable o, Object arg) {
        this.frame = (this.frame++) % 24;
    }

}
