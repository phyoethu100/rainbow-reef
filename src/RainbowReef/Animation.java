package RainbowReef;

import java.util.Observable;
import static java.lang.Thread.sleep;

public class Animation extends Observable implements Runnable {

    @Override
    public void run() {

        while (true) {
            try {
                sleep(22);
                setChanged();
                notifyObservers();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

