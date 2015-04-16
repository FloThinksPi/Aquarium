package de.florianbraun.dh;

import de.florianbraun.dh.Fishes.Fish;

import java.util.ArrayList;

/**
 * Created by flo on 15.04.15.
 */
public class Aquarium {

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private int width,height;

    public Aquarium(int width,int height) {
        this.width=width;
        this.height=height;
    }

    public void DrawAquarium(ArrayList<Fish> myFishes){

        for(int j=0;j<height; j++) {

            System.out.print("|");

            if(j==0 || j==height-1){
                for (int i = 0; i < width; i++) {
                    System.out.print("-");
                }
            }
            else{
                for (int i = 0; i < width; i++) {
                    for(int x=0;x<myFishes.size();x++){
                        if(myFishes.get(x).getX()==i && myFishes.get(x).getY()==j){
                            myFishes.get(x).DrawFish();
                            i+=myFishes.get(x).getLength();
                        }
                    }
                    System.out.print(" ");
                }
            }


            System.out.println("|");
        }

    }

}
