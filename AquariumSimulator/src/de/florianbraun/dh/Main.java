package de.florianbraun.dh;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    private static int WIDTH=142,HEIGHT=40,SPEED=100;
    private static String ANSI_CLS = "\u001b[2J";
    private static String ANSI_HOME = "\u001b[H";

    public static void main(String[] args) throws InterruptedException {

        Aquarium myAquarium = new Aquarium(WIDTH,HEIGHT);

        ArrayList<Fish> myFishes = new ArrayList<>();

        Random rand = new Random();
        for(int i=0;i<HEIGHT;i++){
            switch(rand.nextInt(5)){
                case 0:
                    myFishes.add(new Carp(2,rand.nextInt(WIDTH-2)+1,i));
                    break;
                case 1:
                    myFishes.add(new Blowfish(2,rand.nextInt(WIDTH-2)+1,i));
                    break;
                case 2:
                    myFishes.add(new Swordfish(4,rand.nextInt(WIDTH-2)+1,i));
                    break;
                case 3:
                    myFishes.add(new Shark(3,rand.nextInt(WIDTH-2)+1,i));
                    break;
            }
        }

        GameLoop(myAquarium,myFishes);
    }


    private static void GameLoop(Aquarium myAquarium,ArrayList<Fish> myFishes) throws InterruptedException {

        while (true) {
            Thread.sleep(SPEED, 0);
            myAquarium.DrawAquarium(myFishes);
            System.out.flush();
            System.out.print(ANSI_HOME);



            for(int x=0;x<myFishes.size();x++){
               myFishes.get(x).Move(WIDTH,HEIGHT);
            }

        }

    }

}
