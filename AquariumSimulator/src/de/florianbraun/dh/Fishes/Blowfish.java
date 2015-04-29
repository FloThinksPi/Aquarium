package de.florianbraun.dh.Fishes;

/**
 * Created by flo on 15.04.15.
 */
public final class Blowfish extends Fish {


    public Blowfish(int speed, int x, int y) {
        super(speed, x, y);
        this.length=5;
        this.visualLeft ="<()><";
        this.visualRight ="><()>";
        this.levelchange=0.1;
    }
}
