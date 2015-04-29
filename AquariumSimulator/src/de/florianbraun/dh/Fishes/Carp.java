package de.florianbraun.dh.Fishes;

/**
 * Created by flo on 15.04.15.
 */
public final class Carp extends Fish{


    public Carp(int speed, int x, int y) {
        super(speed, x, y);
        this.length=3;
        this.visualLeft ="<><";
        this.visualRight ="><>";
        this.levelchange=0.5;
    }

}
