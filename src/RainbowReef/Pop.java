package RainbowReef;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class Pop extends Image implements Observer {

    private boolean fell, start;
    private int frame, height, width, gravity;
    private ImageObserver observer;
    private Sprite sprite;
    protected double offsetX;
    protected int offsetFrame;

    public Pop (Sprite sprite, ImageObserver o, Katch katch) throws IOException {
        this.setImageX(302);
        this.setImageY(384);
        this.frame = 0;
        this.sprite = sprite;
        this.observer = o;
        this.width = sprite.getFrame(0).getWidth();
        this.height = sprite.getFrame(0).getHeight();
        this.setDisplay(true);
        this.gravity = -5;
        this.fell = false;
        this.start = false;
        this.offsetX = 0;
        this.offsetFrame = 1;
    }

    public Pop (Sprite sprite, ImageObserver o, Katch katch, Pop pop) throws IOException {
        this.setImageX(pop.getImageX());
        this.setImageY(pop.getImageY());
        this.frame = pop.getFrame();
        this.sprite = pop.getSprite();
        this.observer = o;
        this.width = sprite.getFrame(0).getWidth();
        this.height = sprite.getFrame(0).getHeight();
        this.setDisplay(true);
        this.gravity = -5;
        this.fell = false;
        this.start = true;
        this.offsetX = pop.offsetX;
        this.offsetFrame = pop.offsetFrame;
    }

    public boolean collideBotBlock() {
        if (this.gravity < 0) {
            return false;
        }
        boolean result = false;
        double x0, y0, x1, y1, x2, y2;
        int i, j;
        x0 = (this.getImageX() + 18) - 20;
        x1 = (this.getImageX() + 18) - 20;
        x2 = (this.getImageX() + 18) - 20;
        y0 = (this.getImageY()) + 15;
        y1 = (this.getImageY()) + 15;
        y2 = (this.getImageY()) + 15;

        if (y0 > 435) return false;

        if (x2 > 599) x2 = 599;
        if (x1 > 599) x1 = 599;
        if (x0 > 599) x0 = 599;

        i = (int)x1 / 40;
        j = (int)y1 / 20;

        if (Map.map[i][j] != 0) {
            result = true;

            if (Map.map[i][j] == 8) {
                Map.lives++;
                Map.map[i][j] = 0;
                return result;
            }

            if (Map.map[i][j] == 7) {
                Map.score += 700;
                Map.map[i][j] = 2;
                return result;
            }

            if (Map.map[i][j] == 6) {
                Map.score += 600;
                Map.map[i][j] = 1;
                return result;
            }

            if (Map.map[i][j] == 5) {
                Map.score += 500;
                Map.map[i][j] = 4;
                return result;
            }

            if (Map.map[i][j] == 4) {
                Map.score += 400;
                Map.map[i][j] = 0;
                return result;
            }

            if (Map.map[i][j] == 3) {
                Map.score += 300;
                Map.map[i][j] = 0;
                return result;
            }

            if (Map.map[i][j] == 2) {
                Map.score += 200;
                Map.map[i][j] = 3;
                return result;
            }

            if (Map.map[i][j] == 1) {
                Map.score += 100;
                Map.map[i][j] = 0;
                return result;
            }

            if (Map.map[i][j] == -2) {
                Map.score += 1000;
                Map.map[i][j] = 0;
                Map.map[i][j+1] = 0;
                Map.bigleg--;
                return result;
            }

            if (Map.map[i][j] == 9) {
                Map.extraPop = true;
                Map.map[i][j] = 0;
                return result;
            }

            if (Map.map[i][j] == -4) {
                Map.score += 1000;
                Map.map[i][j] = 0;
                Map.map[i][j-1] = 0;
                Map.bigleg--;
                return result;
            }
        }

        i = (int)x0 / 40;
        j = (int)y0 / 20;

        if (Map.map[i][j] != 0) {
            result = true;

            if (Map.map[i][j] == 8) {
                Map.lives++;
                Map.map[i][j] = 0;
                return result;
            }

            if (Map.map[i][j] == 7) {
                Map.score += 700;
                Map.map[i][j] = 2;
                return result;
            }

            if (Map.map[i][j] == 6) {
                Map.score += 600;
                Map.map[i][j] = 1;
                return result;
            }

            if (Map.map[i][j] == 5) {
                Map.score += 500;
                Map.map[i][j] = 4;
                return result;
            }

            if (Map.map[i][j] == 4) {
                Map.score += 400;
                Map.map[i][j] = 0;
                return result;
            }

            if (Map.map[i][j] == 3) {
                Map.score += 300;
                Map.map[i][j] = 0;
                return result;
            }

            if (Map.map[i][j] == 2) {
                Map.score += 200;
                Map.map[i][j] = 3;
                return result;
            }

            if (Map.map[i][j] == 1) {
                Map.score += 100;
                Map.map[i][j] = 0;
                return result;
            }

            if (Map.map[i][j] == -2) {
                Map.score += 1000;
                Map.map[i][j] = 0;
                Map.map[i][j+1] = 0;
                Map.bigleg--;
                return result;
            }

            if (Map.map[i][j] == 9) {
                Map.extraPop = true;
                Map.map[i][j] = 0;
                return result;
            }

            if (Map.map[i][j] == -4) {
                Map.score += 1000;
                Map.map[i][j] = 0;
                Map.map[i][j-1] = 0;
                Map.bigleg--;
                return result;
            }
        }

        i = (int)x2 / 40;
        j = (int)y2 / 20;

        if (Map.map[i][j] != 0) {
            result = true;

            if (Map.map[i][j] == 8) {
                Map.lives++;
                Map.map[i][j] = 0;
                return result;
            }

            if (Map.map[i][j] == 7) {
                Map.score += 700;
                Map.map[i][j] = 2;
                return result;
            }

            if (Map.map[i][j] == 6) {
                Map.score += 600;
                Map.map[i][j] = 1;
                return result;
            }

            if (Map.map[i][j] == 5) {
                Map.score += 500;
                Map.map[i][j] = 4;
                return result;
            }

            if (Map.map[i][j] == 4) {
                Map.score += 400;
                Map.map[i][j] = 0;
                return result;
            }

            if (Map.map[i][j] == 3) {
                Map.score += 300;
                Map.map[i][j] = 0;
                return result;
            }

            if (Map.map[i][j] == 2) {
                Map.score += 200;
                Map.map[i][j] = 3;
                return result;
            }

            if (Map.map[i][j] == 1) {
                Map.score += 100;
                Map.map[i][j] = 0;
                return result;
            }

            if (Map.map[i][j] == -2) {
                Map.score += 1000;
                Map.map[i][j] = 0;
                Map.map[i][j+1] = 0;
                Map.bigleg--;
                return result;
            }

            if (Map.map[i][j] == 9) {
                Map.extraPop = true;
                Map.map[i][j] = 0;
                return result;
            }

            if (Map.map[i][j] == -4) {
                Map.score += 1000;
                Map.map[i][j] = 0;
                Map.map[i][j-1] = 0;
                Map.bigleg--;
                return result;
            }
        }
        return result;
    }

    public boolean collideSidesBlock() {
        boolean result = false;
        double x0, y0, x1, y1, x2, y2, x3, y3, x4, y4, x5, y5;
        int i, j;

        x0 = (this.getImageX()) - 15;
        x1 = (this.getImageX()) - 15;
        x2 = (this.getImageX()) - 15;
        x3 = (this.getImageX()) + 10;
        x4 = (this.getImageX()) + 10;
        x5 = (this.getImageX()) + 10;
        y0 = (this.getImageY() + 4) - 20;
        y1 = (this.getImageY() + 18) - 20;
        y2 = (this.getImageY() + 31) - 20;
        y3 = (this.getImageY() + 4) - 20;
        y4 = (this.getImageY() + 18) - 20;
        y5 = (this.getImageY()+ 31) - 20;

        if (y0 > 470) return false;
        if (x1 > 599) x1 = 599;
        if (x4 > 599) x4 = 599;
        if (x0 > 599) x0 = 599;
        if (x3 > 599) x3 = 599;
        if (x2 > 599) x2 = 599;
        if (x5 > 599) x5 = 599;

        if (this.offsetX < 0) {
            i = (int)x1 / 40;
            j = (int)y1 / 20;

            if (Map.map[i][j] != 0) {
                result = true;

                if (Map.map[i][j] == 8) {
                    Map.lives++;
                    Map.map[i][j] = 0;
                    return result;
                }

                if (Map.map[i][j] == 7) {
                    Map.score += 700;
                    Map.map[i][j] = 2;
                    return result;
                }

                if (Map.map[i][j] == 6) {
                    Map.score += 600;
                    Map.map[i][j] = 1;
                    return result;
                }

                if (Map.map[i][j] == 5) {
                    Map.score += 500;
                    Map.map[i][j] = 4;
                    return result;
                }

                if (Map.map[i][j] == 4) {
                    Map.score += 400;
                    Map.map[i][j] = 0;
                    return result;
                }

                if (Map.map[i][j] == 3) {
                    Map.score += 300;
                    Map.map[i][j] = 0;
                    return result;
                }

                if (Map.map[i][j] == 2) {
                    Map.score += 200;
                    Map.map[i][j] = 3;
                    return result;
                }

                if (Map.map[i][j] == 1) {
                    Map.score += 100;
                    Map.map[i][j] = 0;
                    return result;
                }

                if (Map.map[i][j] == -2) {
                    Map.score += 1000;
                    Map.map[i][j] = 0;
                    Map.map[i][j+1] = 0;
                    Map.bigleg--;
                    return result;
                }

                if (Map.map[i][j] == 9) {
                    Map.extraPop = true;
                    Map.map[i][j] = 0;
                    return result;
                }

                if (Map.map[i][j] == -4) {
                    Map.score += 1000;
                    Map.map[i][j] = 0;
                    Map.map[i][j-1] = 0;
                    Map.bigleg--;
                    return result;
                }
            }

            i = (int)x0 / 40;
            j = (int)y0 / 20;

            if (Map.map[i][j] != 0) {
                result = true;

                if (Map.map[i][j] == 8) {
                    Map.lives++;
                    Map.map[i][j] = 0;
                    return result;
                }

                if (Map.map[i][j] == 7) {
                    Map.score += 700;
                    Map.map[i][j] = 2;
                    return result;
                }

                if (Map.map[i][j] == 6) {
                    Map.score += 600;
                    Map.map[i][j] = 1;
                    return result;
                }

                if (Map.map[i][j] == 5) {
                    Map.score += 500;
                    Map.map[i][j] = 4;
                    return result;
                }

                if (Map.map[i][j] == 4) {
                    Map.score += 400;
                    Map.map[i][j] = 0;
                    return result;
                }

                if (Map.map[i][j] == 3) {
                    Map.score += 300;
                    Map.map[i][j] = 0;
                    return result;
                }

                if (Map.map[i][j] == 2) {
                    Map.score += 200;
                    Map.map[i][j] = 3;
                    return result;
                }

                if (Map.map[i][j] == 1) {
                    Map.score += 100;
                    Map.map[i][j] = 0;
                    return result;
                }

                if (Map.map[i][j] == -2) {
                    Map.score += 1000;
                    Map.map[i][j] = 0;
                    Map.map[i][j+1] = 0;
                    Map.bigleg--;
                    return result;
                }

                if (Map.map[i][j] == 9) {
                    Map.extraPop = true;
                    Map.map[i][j] = 0;
                    return result;
                }

                if (Map.map[i][j] == -4) {
                    Map.score += 1000;
                    Map.map[i][j] = 0;
                    Map.map[i][j-1] = 0;
                    Map.bigleg--;
                    return result;
                }
            }

            i = (int)x2 / 40;
            j = (int)y2 / 20;

            if (Map.map[i][j] != 0) {
                result = true;

                if (Map.map[i][j] == 8) {
                    Map.lives++;
                    Map.map[i][j] = 0;
                    return result;
                }

                if (Map.map[i][j] == 7) {
                    Map.score += 700;
                    Map.map[i][j] = 2;
                    return result;
                }

                if (Map.map[i][j] == 6) {
                    Map.score += 600;
                    Map.map[i][j] = 1;
                    return result;
                }

                if (Map.map[i][j] == 5) {
                    Map.score += 500;
                    Map.map[i][j] = 4;
                    return result;
                }

                if (Map.map[i][j] == 4) {
                    Map.score += 400;
                    Map.map[i][j] = 0;
                    return result;
                }

                if (Map.map[i][j] == 3) {
                    Map.score += 300;
                    Map.map[i][j] = 0;
                    return result;
                }

                if (Map.map[i][j] == 2) {
                    Map.score += 200;
                    Map.map[i][j] = 3;
                    return result;
                }

                if (Map.map[i][j] == 1) {
                    Map.score += 100;
                    Map.map[i][j] = 0;
                    return result;
                }

                if (Map.map[i][j] == -2) {
                    Map.score += 1000;
                    Map.map[i][j] = 0;
                    Map.map[i][j+1] = 0;
                    Map.bigleg--;
                    return result;
                }

                if (Map.map[i][j] == 9) {
                    Map.extraPop = true;
                    Map.map[i][j] = 0;
                    return result;
                }

                if (Map.map[i][j] == -4) {
                    Map.score += 1000;
                    Map.map[i][j] = 0;
                    Map.map[i][j-1] = 0;
                    Map.bigleg--;
                    return result;
                }
            }
        }

        if (this.offsetX > 0) {
            i = (int)x4 / 40;
            j = (int)y4 / 20;

            if (Map.map[i][j] != 0) {
                result = true;

                if (Map.map[i][j] == 8) {
                    Map.lives++;
                    Map.map[i][j] = 0;
                    return result;
                }

                if (Map.map[i][j] == 7) {
                    Map.score += 700;
                    Map.map[i][j] = 2;
                    return result;
                }

                if (Map.map[i][j] == 6) {
                    Map.score += 600;
                    Map.map[i][j] = 1;
                    return result;
                }

                if (Map.map[i][j] == 5) {
                    Map.score += 500;
                    Map.map[i][j] = 4;
                    return result;
                }

                if (Map.map[i][j] == 4) {
                    Map.score += 400;
                    Map.map[i][j] = 0;
                    return result;
                }

                if (Map.map[i][j] == 3) {
                    Map.score += 300;
                    Map.map[i][j] = 0;
                    return result;
                }

                if (Map.map[i][j] == 2) {
                    Map.score += 200;
                    Map.map[i][j] = 3;
                    return result;
                }

                if (Map.map[i][j] == 1) {
                    Map.score += 100;
                    Map.map[i][j] = 0;
                    return result;
                }

                if (Map.map[i][j] == -2) {
                    Map.score += 1000;
                    Map.map[i][j] = 0;
                    Map.map[i][j+1] = 0;
                    Map.bigleg--;
                    return result;
                }

                if (Map.map[i][j] == 9) {
                    Map.extraPop = true;
                    Map.map[i][j] = 0;
                    return result;
                }

                if (Map.map[i][j] == -4) {
                    Map.score += 1000;
                    Map.map[i][j] = 0;
                    Map.map[i][j-1] = 0;
                    Map.bigleg--;
                    return result;
                }
            }

            i = (int)x3 / 40;
            j = (int)y3 / 20;

            if (Map.map[i][j] != 0) {
                result = true;

                if (Map.map[i][j] == 8) {
                    Map.lives++;
                    Map.map[i][j] = 0;
                    return result;
                }

                if (Map.map[i][j] == 7) {
                    Map.score += 700;
                    Map.map[i][j] = 2;
                    return result;
                }

                if (Map.map[i][j] == 6) {
                    Map.score += 600;
                    Map.map[i][j] = 1;
                    return result;
                }

                if (Map.map[i][j] == 5) {
                    Map.score += 500;
                    Map.map[i][j] = 4;
                    return result;
                }

                if (Map.map[i][j] == 4) {
                    Map.score += 400;
                    Map.map[i][j] = 0;
                    return result;
                }

                if (Map.map[i][j] == 3) {
                    Map.score += 300;
                    Map.map[i][j] = 0;
                    return result;
                }

                if (Map.map[i][j] == 2) {
                    Map.score += 200;
                    Map.map[i][j] = 3;
                    return result;
                }

                if (Map.map[i][j] == 1) {
                    Map.score += 100;
                    Map.map[i][j] = 0;
                    return result;
                }

                if (Map.map[i][j] == -2) {
                    Map.score += 1000;
                    Map.map[i][j] = 0;
                    Map.map[i][j+1] = 0;
                    Map.bigleg--;
                    return result;
                }

                if (Map.map[i][j] == 9) {
                    Map.extraPop = true;
                    Map.map[i][j] = 0;
                    return result;
                }

                if (Map.map[i][j] == -4) {
                    Map.score += 1000;
                    Map.map[i][j] = 0;
                    Map.map[i][j-1] = 0;
                    Map.bigleg--;
                    return result;
                }
            }

            i = (int)x5 / 40;
            j = (int)y5 / 20;

            if (Map.map[i][j] != 0) {
                result = true;

                if (Map.map[i][j] == 8) {
                    Map.lives++;
                    Map.map[i][j] = 0;
                    return result;
                }

                if (Map.map[i][j] == 7) {
                    Map.score += 700;
                    Map.map[i][j] = 2;
                    return result;
                }

                if (Map.map[i][j] == 6) {
                    Map.score += 600;
                    Map.map[i][j] = 1;
                    return result;
                }

                if (Map.map[i][j] == 5) {
                    Map.score += 500;
                    Map.map[i][j] = 4;
                    return result;
                }

                if (Map.map[i][j] == 4) {
                    Map.score += 400;
                    Map.map[i][j] = 0;
                    return result;
                }

                if (Map.map[i][j] == 3) {
                    Map.score += 300;
                    Map.map[i][j] = 0;
                    return result;
                }

                if (Map.map[i][j] == 2) {
                    Map.score += 200;
                    Map.map[i][j] = 3;
                    return result;
                }

                if (Map.map[i][j] == 1) {
                    Map.score += 100;
                    Map.map[i][j] = 0;
                    return result;
                }

                if (Map.map[i][j] == -2) {
                    Map.score += 1000;
                    Map.map[i][j] = 0;
                    Map.map[i][j+1] = 0;
                    Map.bigleg--;
                    return result;
                }

                if (Map.map[i][j] == 9) {
                    Map.extraPop = true;
                    Map.map[i][j] = 0;
                    return result;
                }

                if (Map.map[i][j] == -4) {
                    Map.score += 1000;
                    Map.map[i][j] = 0;
                    Map.map[i][j-1] = 0;
                    Map.bigleg--;
                    return result;
                }
            }
        }

        return result;
    }

    public boolean collideTopBlock() {
        if( this.gravity > 0 ) {
            return false;
        }

        boolean result = false;
        double x0, y0, x1, y1, x2, y2;
        int i, j;

        x0 = (this.getImageX() + 9) - 20;
        x1 = (this.getImageX() + 18) - 20;
        x2 = (this.getImageX() + 24) - 20;
        y0 = (this.getImageY() - 20);
        y1 = (this.getImageY() - 20);
        y2 = (this.getImageY() - 20);

        if (x2 > 599) x2 = 599;
        if (x1 > 599) x1 = 599;
        if (x0 > 599) x0 = 599;

        i = (int)x1 / 40;
        j = (int)y1 / 20;

        if (Map.map[i][j] != 0) {
            result = true;

            if (Map.map[i][j] == 8) {
                Map.lives++;
                Map.map[i][j] = 0;
                return result;
            }

            if (Map.map[i][j] == 7) {
                Map.score += 700;
                Map.map[i][j] = 2;
                return result;
            }

            if (Map.map[i][j] == 6) {
                Map.score += 600;
                Map.map[i][j] = 1;
                return result;
            }

            if (Map.map[i][j] == 5) {
                Map.score += 500;
                Map.map[i][j] = 4;
                return result;
            }

            if (Map.map[i][j] == 4) {
                Map.score += 400;
                Map.map[i][j] = 0;
                return result;
            }

            if (Map.map[i][j] == 3) {
                Map.score += 300;
                Map.map[i][j] = 0;
                return result;
            }

            if (Map.map[i][j] == 2) {
                Map.score += 200;
                Map.map[i][j] = 3;
                return result;
            }

            if (Map.map[i][j] == 1) {
                Map.score += 100;
                Map.map[i][j] = 0;
                return result;
            }

            if (Map.map[i][j] == -2) {
                Map.score += 1000;
                Map.map[i][j] = 0;
                Map.map[i][j+1] = 0;
                Map.bigleg--;
                return result;
            }

            if (Map.map[i][j] == 9) {
                Map.extraPop = true;
                Map.map[i][j] = 0;
                return result;
            }

            if (Map.map[i][j] == -4) {
                Map.score += 1000;
                Map.map[i][j] = 0;
                Map.map[i][j-1] = 0;
                Map.bigleg--;
                return result;
            }
        }

        i = (int)x0 / 40;
        j = (int)y0 / 20;

        if (Map.map[i][j] != 0) {
            result = true;

            if (Map.map[i][j] == 8) {
                Map.lives++;
                Map.map[i][j] = 0;
                return result;
            }

            if (Map.map[i][j] == 7) {
                Map.score += 700;
                Map.map[i][j] = 2;
                return result;
            }

            if (Map.map[i][j] == 6) {
                Map.score += 600;
                Map.map[i][j] = 1;
                return result;
            }

            if (Map.map[i][j] == 5) {
                Map.score += 500;
                Map.map[i][j] = 4;
                return result;
            }

            if (Map.map[i][j] == 4) {
                Map.score += 400;
                Map.map[i][j] = 0;
                return result;
            }

            if (Map.map[i][j] == 3) {
                Map.score += 300;
                Map.map[i][j] = 0;
                return result;
            }

            if (Map.map[i][j] == 2) {
                Map.score += 200;
                Map.map[i][j] = 3;
                return result;
            }

            if (Map.map[i][j] == 1) {
                Map.score += 100;
                Map.map[i][j] = 0;
                return result;
            }

            if (Map.map[i][j] == -2) {
                Map.score += 1000;
                Map.map[i][j] = 0;
                Map.map[i][j+1] = 0;
                Map.bigleg--;
                return result;
            }

            if (Map.map[i][j] == 9) {
                Map.extraPop = true;
                Map.map[i][j] = 0;
                return result;
            }

            if (Map.map[i][j] == -4) {
                Map.score += 1000;
                Map.map[i][j] = 0;
                Map.map[i][j-1] = 0;
                Map.bigleg--;
                return result;
            }
        }

        i = (int)x2 / 40;
        j = (int)y2 / 20;

        if (Map.map[i][j] != 0) {
            result = true;

            if (Map.map[i][j] == 8) {
                Map.lives++;
                Map.map[i][j] = 0;
                return result;
            }

            if (Map.map[i][j] == 7) {
                Map.score += 700;
                Map.map[i][j] = 2;
                return result;
            }

            if (Map.map[i][j] == 6) {
                Map.score += 600;
                Map.map[i][j] = 1;
                return result;
            }

            if (Map.map[i][j] == 5) {
                Map.score += 500;
                Map.map[i][j] = 4;
                return result;
            }

            if (Map.map[i][j] == 4) {
                Map.score += 400;
                Map.map[i][j] = 0;
                return result;
            }

            if (Map.map[i][j] == 3) {
                Map.score += 300;
                Map.map[i][j] = 0;
                return result;
            }

            if (Map.map[i][j] == 2) {
                Map.score += 200;
                Map.map[i][j] = 3;
                return result;
            }

            if (Map.map[i][j] == 1) {
                Map.score += 100;
                Map.map[i][j] = 3;
                return result;
            }

            if (Map.map[i][j] == -2) {
                Map.score += 1000;
                Map.map[i][j] = 0;
                Map.map[i][j+1] = 0;
                Map.bigleg--;
                return result;
            }

            if (Map.map[i][j] == 9) {
                Map.extraPop = true;
                Map.map[i][j] = 0;
                return result;
            }

            if (Map.map[i][j] == -4) {
                Map.score += 1000;
                Map.map[i][j] = 0;
                Map.map[i][j-1] = 0;
                Map.bigleg--;
                return result;
            }
        }

        return result;
    }

    public boolean collideSidesWall() {
        boolean result = false;
        if (this.getImageX() < 21 || this.getImageX()+35 > 620)
            result = true;

        return result;
    }

    public boolean checkFell(Katch katch) {
        boolean result = false;
        if ((((this.getImageX()+35 > katch.getImageX()-8 && this.getImageX()+35 < katch.getImageX()) ||
                (this.getImageX() < katch.getImageX()+88 && this.getImageX() > katch.getImageX()+80)) && this.getImageY() > 405 ) || this.getImageY() > 480 )
            result = true;

        return result;
    }

    public boolean collideSidesKatch(Katch katch) {
        boolean result = false;
        if ((((this.getImageX()+35 > katch.getImageX()-8 && this.getImageX()+35 < katch.getImageX()) ||
                (this.getImageX() < katch.getImageX()+88 && this.getImageX() > katch.getImageX()+80)) && ( this.getImageY() > 385 && this.getImageY() <= 405 ))){
            result = true;
        }

        return result;
    }

    public boolean collideKatch(Katch katch) {
        boolean result = false;
        if ((this.getImageX()+17.5 > katch.getImageX()-17.5 && this.getImageX()+17.5 < katch.getImageX()+97.5) && this.getImageY() > 385 )
            result = true;

        return result;
    }

    public boolean collideTop() {
        boolean result = false;
        if (this.getImageY() <= 20)
            result = true;

        return result;
    }

    public void speed() {
        if (this.gravity > 0) this.gravity++;
        if (this.gravity < 0) this.gravity--;
        if (this.gravity < -10) this.gravity = -10;
        if (this.gravity > 10) this.gravity = 10;
    }

    public void setOffsetX(Katch katch) {
        double x = this.getImageX()+17.5;
        double o = katch.getImageX()+40;

        if (x < o) {
            this.offsetX = (Math.abs(this.gravity))*Math.tan((x-o)*(x-o)/1600*0.6 )*-1;
        } else {
            this.offsetX = (Math.abs(this.gravity))*Math.tan((x-o)*(x-o)/1600*0.60);
        }
    }

    public void reverseX() {
        this.offsetX *= -1;
    }

    public void checkGravity() {
        this.gravity *= -1;
    }

    public void setStart(boolean bool) {
        this.start = bool;
    }

    public boolean getStart() {
        return this.start;
    }

    public boolean getFell() {
        return this.fell;
    }

    public void setFell(boolean fell) {
        this.fell = fell;
    }

    public void resetPop() {
        this.setImageX(302);
        this.setImageY(384);
        this.start = false;
        this.offsetX = 0;
        this.gravity = -5;
        this.frame = 0;
    }

    public void setFrameOffset() {
        this.offsetFrame *= -1;
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
        int tmp;
        double temp;
        if (this.start) {
            temp = this.gravity * (this.getImageY()/480);
            if(temp < 2 && temp > 0) temp = 2;
            if(temp < 0 && temp > -2) temp = -2;
            this.setImageY(this.getImageY() + temp);
            this.setImageX(this.getImageX() + this.offsetX);
            tmp = this.frame + this.offsetFrame;
            if (tmp == -1) tmp = 44;
            this.frame = tmp % 45;
        }
    }

}
