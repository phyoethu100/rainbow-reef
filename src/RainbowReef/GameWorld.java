package RainbowReef;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

public class GameWorld extends JPanel implements Observer, KeyListener {

    private Animation animation;
    private Bigleg bigleg;
    private Block blockExtraLife, blockExtraPop, blockSolid, block1, block2, block3, block4, block5, block6, block7, lives;
    private Katch katch;
    private LevelOne backgroundOne;
    private LevelTwo backgroundTwo;
    private Map map;
    private Pop pop, popCopy;
    private Sound sound;
    private Wall wall;

    private ArrayList<Integer> pressedKey;
    private boolean copy = false;
    private int count;

    public GameWorld() {
        this.animation = new Animation();
        this.animation.addObserver(this);
        this.pressedKey = new ArrayList<>();
        this.addKeyListener(this);
        this.setFocusable(true);
        this.count = 0;
        this.map = new Map();
        this.sound = new Sound();

        try {
            this.backgroundOne = new LevelOne();
            this.backgroundTwo = new LevelTwo();
            this.bigleg = new Bigleg(new Sprite("resources/spaceship.png", 40, 40), this);
            this.blockExtraLife = new Block("resources/energy.png");
            this.blockSolid = new Block("resources/greytile.png");
            this.blockExtraPop = new Block("resources/stars.png");
            this.block1 = new Block("resources/redtile.png");
            this.block2 = new Block("resources/cyantile.png");
            this.block3 = new Block("resources/bluetile.png");
            this.block4 = new Block("resources/greentile.png");
            this.block5 = new Block("resources/yellowtile.png");
            this.block6 = new Block("resources/orangetile.png");
            this.block7 = new Block("resources/purpletile.png");
            this.lives = new Block("resources/heart.png");
            this.katch = new Katch(new Sprite("resources/gold.jpg", 80, 30), this, 280, 420 );
            this.pop = new Pop(new Sprite("resources/Pop_strip45.png", 35, 35 ), this, this.katch);
            this.wall = new Wall();
        } catch (IOException exception) {
            System.err.println("Failed to load images.");
            exception.printStackTrace();
        }

        this.animation.addObserver(pop);
        new Thread(this.animation).start();
    }

    @Override
    public void update(Observable o, Object arg) {
        this.repaint();
    }

    @Override
    public void paintComponent(Graphics graphic) {

        if (Map.level == 1) {
            this.backgroundOne.repaint(graphic);
        } else if (Map.level == 2) {
            this.backgroundTwo.repaint(graphic);
        }

        if (Map.level == 1 && Map.bigleg == 0) {
            sound.playOnce("resources/Sound_bigleg.wav");
            this.map.setLevelTwo();
            this.pop.resetPop();
            this.katch.resetKatch();
            this.pop.setStart(false);
            Map.level = 2;
        }

        for (int i = 0; i < Map.lives; i++) {
            this.lives.setImageX(30 + 30*i);
            this.lives.setImageY(430);
            this.lives.repaint(graphic);
        }

        graphic.setColor(Color.white);
        graphic.setFont(new Font("Helvetica", Font.PLAIN, 14));
        graphic.drawString("SCORES: " + Map.score, 490, 440);

        // Initialize the map with the assigned numbers
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 30; j++) {

                if (Map.map[i][j]  == -2) {
                    this.bigleg.setImageX(20 + i*40);
                    this.bigleg.setImageY(20 + j*20);
                    this.bigleg.repaint(graphic);
                }

                if (Map.map[i][j] == -1) {
                    this.blockSolid.setImageX(20 + i*40);
                    this.blockSolid.setImageY(20 + j*20);
                    this.blockSolid.repaint(graphic);
                }

                if (Map.map[i][j] == 1) {
                    this.block1.setImageX(20 + i*40);
                    this.block1.setImageY(20 + j*20);
                    this.block1.repaint(graphic);
                }

                if (Map.map[i][j] == 2) {
                    this.block2.setImageX(20 + i*40);
                    this.block2.setImageY(20 + j*20);
                    this.block2.repaint(graphic);
                }

                if (Map.map[i][j] == 3) {
                    this.block3.setImageX(20 + i*40);
                    this.block3.setImageY(20 + j*20);
                    this.block3.repaint(graphic);
                }

                if (Map.map[i][j] == 4) {
                    this.block4.setImageX(20 + i*40);
                    this.block4.setImageY(20 + j*20);
                    this.block4.repaint(graphic);
                }

                if (Map.map[i][j] == 5) {
                    this.block5.setImageX(20 + i*40);
                    this.block5.setImageY(20 + j*20);
                    this.block5.repaint(graphic);
                }

                if (Map.map[i][j] == 6) {
                    this.block6.setImageX(20 + i*40);
                    this.block6.setImageY(20 + j*20);
                    this.block6.repaint(graphic);
                }

                if (Map.map[i][j] == 7) {
                    this.block7.setImageX(20 + i*40);
                    this.block7.setImageY(20 + j*20);
                    this.block7.repaint(graphic);
                }

                if (Map.map[i][j] == 8) {
                    this.blockExtraLife.setImageX(20 + i*40);
                    this.blockExtraLife.setImageY(20 + j*20);
                    this.blockExtraLife.repaint(graphic);
                }

                if (Map.map[i][j] == 9) {
                    this.blockExtraPop.setImageX(20 + i*40);
                    this.blockExtraPop.setImageY(20 + j*20);
                    this.blockExtraPop.repaint(graphic);
                }

            }
        }

        for (int i = 0; i < 32; i++) {
            this.wall.setImageX(i * 20);
            this.wall.setImageY(0);
            this.wall.repaint(graphic);
        }

        for (int j = 1; j < 24; j++) {
            this.wall.setImageX(0);
            this.wall.setImageY(j * 20);
            this.wall.repaint(graphic);
        }

        for (int j = 1; j < 24; j++) {
            this.wall.setImageX(620);
            this.wall.setImageY(j * 20);
            this.wall.repaint(graphic);
        }

        if (this.katch.getDisplay()) {
            this.katch.repaint(graphic);
        }

        if (this.pop.getDisplay()) {
            this.pop.repaint(graphic);
        }

        this.control(pressedKey);

        if (Map.extraPop) {
            try {
                if (!copy) {
                    popCopy = new Pop(new Sprite("resources/Pop_strip45.png", 35, 35 ), this, this.katch, this.pop );
                    copy = true;
                    this.animation.addObserver(popCopy);
                }
                popCopy.repaint(graphic);

                if(this.popCopy.collideSidesBlock()) {
                    sound.playOnce("resources/Sound_block.wav");
                    this.popCopy.reverseX();
                    this.popCopy.setFrameOffset();

                } else if(this.popCopy.collideTopBlock()) {
                    sound.playOnce("resources/Sound_block.wav");
                    this.popCopy.checkGravity();
                }

                if(this.popCopy.collideSidesWall()) {
                    sound.playOnce("resources/Sound_wall.wav");
                    this.popCopy.reverseX();
                    this.popCopy.setFrameOffset();
                }

                if(this.popCopy.collideTop()) this.popCopy.checkGravity();

                if(this.popCopy.collideSidesBlock()) {
                    this.popCopy.reverseX();
                    this.popCopy.setFrameOffset();

                } else if (this.popCopy.collideBotBlock()) {
                    sound.playOnce("resources/Sound_block.wav");
                    this.popCopy.checkGravity();
                }

                if(this.popCopy.collideSidesKatch(this.katch)) {
                    this.popCopy.reverseX();

                } else if (this.popCopy.collideKatch(this.katch)) {
                    sound.playOnce("resources/Sound_katch.wav");
                    this.popCopy.checkGravity();
                    this.count++;
                    if(this.count % 10 == 0)
                        this.popCopy.speed();
                    this.popCopy.setOffsetX(this.katch);
                }

                else if (this.popCopy.checkFell(this.katch)) {
                    this.animation.deleteObserver(popCopy);
                    this.copy = false;
                    Map.extraPop = false;
                }
            } catch (IOException e) {
                System.err.println("Failed to load duplicate Pop.");
            }

        }

        if(this.pop.collideSidesBlock()) {
            sound.playOnce("resources/Sound_block.wav");
            this.pop.reverseX();
            this.pop.setFrameOffset();

        } else if(this.pop.collideTopBlock()) {
            sound.playOnce("resources/Sound_block.wav");
            this.pop.checkGravity();
        }

        if(this.pop.collideSidesWall()) {
            sound.playOnce("resources/Sound_wall.wav");
            this.pop.reverseX();
            this.pop.setFrameOffset();
        }

        if(this.pop.collideTop())
            this.pop.checkGravity();

        if(this.pop.collideSidesBlock()) {
            sound.playOnce("resources/Sound_block.wav");
            this.pop.reverseX();
            this.pop.setFrameOffset();

        } else if (this.pop.collideBotBlock()) {
            sound.playOnce("resources/Sound_block.wav");
            this.pop.checkGravity();
        }

        if(this.pop.collideSidesKatch(this.katch)) {
            this.pop.reverseX();

        } else if (this.pop.collideKatch(this.katch)) {
            sound.playOnce("resources/Sound_katch.wav");
            this.pop.checkGravity();
            this.count++;
            if(this.count % 10 == 0) this.pop.speed();
            this.pop.setOffsetX(this.katch);

        } else if (this.pop.checkFell(this.katch)) {
            this.pop.resetPop();
            this.katch.resetKatch();
            this.pop.setStart(false);
            Map.lives--;
        }

        if (Map.lives == 0) {
            sound.playOnce("resources/Sound_lost.wav");
            this.animation.deleteObserver(this);
            try {
                GameOver lose = new GameOver();
                super.paintComponent(graphic);
                lose.repaint(graphic);
            } catch (IOException e) {
                System.err.println("Failed to load game over image.");
            }
        }

        if (Map.bigleg == 0 && Map.level == 2) {
            this.animation.deleteObserver(this);
            try {
                Title win = new Title();
                super.paintComponent(graphic);
                win.repaint(graphic);
            } catch (IOException e) {
                System.err.println("Failed to load congratulation image.");
            }
        }
    }

    public void control(ArrayList<Integer> e) {
        for (Integer key : e) {
            if (key == 37) { // Left arrow
                this.katch.setImageX(this.katch.getImageX() - 8);
                if (this.katch.checkCollision()) {
                    this.katch.setImageX(this.katch.getImageX() + 8);
                }
            }

            if (key == 39) { // Right arrow
                this.katch.setImageX(this.katch.getImageX() + 8);
                if (this.katch.checkCollision()) {
                    this.katch.setImageX(this.katch.getImageX() - 8);
                }
            }

            if (key == 32) { // Space bar
                this.pop.setStart(true);
            }

        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!pressedKey.contains(e.getKeyCode())) {
            pressedKey.add(e.getKeyCode());
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        pressedKey.remove(new Integer(e.getKeyCode()));
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

}
