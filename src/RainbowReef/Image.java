package RainbowReef;

public abstract class Image {

    private double x, y;
    private boolean display;

    public Image() {};

    public void setImageX(double x) {
        this.x = x;
    }

    public void setImageY(double y) {
        this.y = y;
    }

    public double getImageX() {
        return this.x;
    }

    public double getImageY() {
        return this.y;
    }

    public void setDisplay(boolean display) {
        this.display = display;
    }

    public boolean getDisplay() {
        return this.display;
    }

}

