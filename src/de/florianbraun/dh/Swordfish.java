package de.florianbraun.dh;

/**
 * Created by flo on 15.04.15.
 */
public class Swordfish extends Fish {
    public Swordfish(int speed, int x, int y) {
        super(speed, x, y);
        this.length=4;
        this.visualLeft ="-<><";
        this.visualRight ="><>-";
        this.levelchange=0.2;
    }
}
