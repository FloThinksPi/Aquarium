package de.florianbraun.dh;

/**
 * Created by flo on 15.04.15.
 */
public class Shark extends Fish {

    public Shark(int speed, int x, int y) {
        super(speed, x, y);
        this.length=10;
        this.visualLeft ="<///====><";
        this.visualRight ="><====///>";
        this.levelchange=0.25;
    }
}
