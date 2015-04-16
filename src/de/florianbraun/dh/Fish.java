package de.florianbraun.dh;

import java.util.Random;

/**
 * Created by flo on 15.04.15.
 */
public abstract class Fish {
    String visualLeft,visualRight;
    int length, MaxSpeed,x,y,direction;
    double levelchange;

    public Fish(int speed,int x,int y) {
        this.MaxSpeed = speed;
        this.x=x;
        this.y=y;
    }


    public int getMaxSpeed() {
        return MaxSpeed;
    }

    public int getLength() {
        return length;
    }

    public String getVisualLeft() {
        return visualLeft;
    }

    public double getLevelchange() {
        return levelchange;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void DrawFish(){
        if(direction==1){
            System.out.print(visualLeft);
        }else {
            System.out.print(visualRight);
        }

    }

    public void Move(int Width,int Height){

        Random rand = new Random();

        if(direction==1){
            if(!MoveLeft(rand.nextInt(MaxSpeed)))MoveRight(rand.nextInt(MaxSpeed),Width);
        }else{
            if(!MoveRight(rand.nextInt(MaxSpeed),Width))MoveLeft(rand.nextInt(MaxSpeed));
        }

        if(rand.nextInt(100)>=98){
            if(direction==1)direction=0;
            else direction=1;
        }

        if(rand.nextFloat()<=levelchange){
            if(rand.nextFloat()>0.5f){
                MoveUp();
            }else{
                MoveDown(Height);
            }
        }

    }

    private boolean MoveLeft(int dist) {
        if(this.x- dist <0)return false;
        this.x -= dist;
        this.direction=1;
        return true;
    }

    private boolean MoveRight(int dist,int Width) {
        if(this.x+ dist +length +1>Width)return false;
        this.x += dist;
        this.direction=0;
        return true;
    }

    private boolean MoveUp() {
        if(this.y-1<1)return false;
        this.y -=1;
        return true;
    }

    private boolean MoveDown(int Height) {
        if(this.y+3>Height)return false;
        this.y +=1;
        return true;
    }

}
