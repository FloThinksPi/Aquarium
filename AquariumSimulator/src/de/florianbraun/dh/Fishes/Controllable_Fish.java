package de.florianbraun.dh.Fishes;

import java.util.Scanner;

/**
 * Created by flo on 16.04.15.
 */
public class Controllable_Fish extends Fish {

    public Controllable_Fish(int speed, int x, int y) {
        super(speed, x, y);
        this.length=4;
        this.visualLeft ="O<>=";
        this.visualRight ="=<>O";
        this.levelchange=0;
    }

    @Override
    public void MoveControlled(int Width,int Height,int direction){

        switch (direction){
            case 0://Hoch
                MoveUp();
                break;
            case 1://Runter
                MoveDown(Height);
                break;
            case 2://Links
                MoveLeft(1);
                break;
            case 3://Rechts
                MoveRight(1,Width);
                break;
            case 4://Hoch+Rechts
                MoveUp();
                MoveRight(1, Width);
                break;
            case 5://Runter+Rechts
                MoveDown(Height);
                MoveRight(1, Width);
                break;
            case 6://Hoch+Links
                MoveUp();
                MoveLeft(1);
                break;
            case 7://Runter+Links
                MoveDown(Height);
                MoveLeft(1);
                break;
        }


    }
}
