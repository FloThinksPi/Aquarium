package de.florianbraun.dh;

import de.florianbraun.dh.Fishes.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    private static int WIDTH=142,HEIGHT=40,SPEED=150;
    private static String ANSI_CLS = "\u001b[2J";
    private static String ANSI_HOME = "\u001b[H";

    public static void main(String[] args) throws InterruptedException, AWTException {

        Aquarium myAquarium = new Aquarium(WIDTH,HEIGHT);

        ArrayList<Fish> myFishes = new ArrayList<>();

        Random rand = new Random();
        myFishes.add(new Controllable_Fish(2,10,10));
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


    private static void GameLoop(Aquarium myAquarium,ArrayList<Fish> myFishes) throws InterruptedException, AWTException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String line = "";


        while (line.equalsIgnoreCase("quit") == false) {
            Thread.sleep(SPEED, 0);
            myAquarium.DrawAquarium(myFishes);
            System.out.flush();
            System.out.print(ANSI_HOME);

            for(int x=1;x<myFishes.size();x++){
               myFishes.get(x).Move(WIDTH,HEIGHT);
            }

            try {
                if(in.ready())line = in.readLine();

                int dir=10;
                if(line.contains("w")){
                    dir=0;
                }else if(line.contains("d")){
                    dir=3;
                }else if(line.contains("s")){
                    dir=1;
                }else if(line.contains("a")){
                    dir=2;
                }
                myFishes.get(0).MoveControlled(WIDTH,HEIGHT,dir);
            } catch (IOException e) {
                e.printStackTrace();
            }



        }



    }

}
