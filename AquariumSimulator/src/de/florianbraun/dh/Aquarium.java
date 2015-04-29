package de.florianbraun.dh;

import de.florianbraun.dh.Fishes.Fish;

import java.util.ArrayList;

/**
 * Created by flo on 15.04.15.
 */
public final class Aquarium {

    private final int width,height;

    public Aquarium(int width,int height) {
        this.width=width;
        this.height=height;
    }

    public void DrawAquarium(ArrayList<Fish> myFishes){

        for(int j=0;j<height; j++) {

            System.out.print("|");

            if(j==0){
                for (int i = 0; i < width-2; i++) {
                    System.out.print("~");
                }
            }else if(j==height-1){
                for (int i = 0; i < width-2; i++) {
                    System.out.print("-");
                }
            }
            else{
                for (int i = 0; i < width-2; i++) {
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
