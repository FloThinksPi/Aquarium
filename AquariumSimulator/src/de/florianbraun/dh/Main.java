package de.florianbraun.dh;

import de.florianbraun.dh.Fishes.*;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int WIDTH=142,HEIGHT=40,SPEED=120;
    private static final String ANSI_CLS = "\u001b[2J";
    private static final String ANSI_HOME = "\u001b[H";

    public static void main(String[] args) throws InterruptedException, AWTException {

        System.out.print(ANSI_CLS+ANSI_HOME);

        Scanner myscanner = new Scanner(System.in);
        int in;
        boolean validHeight=false,validWidth=false;
        while(!validWidth){
            System.out.print("Geben sie die Aquarium Breite an(min 20): ");
            while (!myscanner.hasNextInt()) {myscanner.next();System.out.print("Ungültige Breite(min 20): ");}
            in = myscanner.nextInt();
            if(in>=20){
                WIDTH=in;
                validWidth=true;
            }
        }
        while(!validHeight){
            System.out.print("Geben sie die Aquarium Höhe an(min 5): ");
            while (!myscanner.hasNextInt()) {myscanner.next();System.out.print("Ungültige Höhe(min 5): ");}
            in = myscanner.nextInt();
            if(in>=5){
                HEIGHT=in;
                validHeight=true;
            }
        }

        Aquarium myAquarium = new Aquarium(WIDTH,HEIGHT);

        ArrayList<Fish> myFishes = new ArrayList<>();

        Random rand = new Random();
        myFishes.add(new Diver_Controllable(2,2,2));
        for(int i=0;i<HEIGHT;i++){
            switch(rand.nextInt(4)){
                case 0:
                    myFishes.add(new Carp(2,rand.nextInt(WIDTH-8)+1,i));
                    break;
                case 1:
                    myFishes.add(new Blowfish(2,rand.nextInt(WIDTH-8)+1,i));
                    break;
                case 2:
                    myFishes.add(new Swordfish(4,rand.nextInt(WIDTH-8)+1,i));
                    break;
                case 3:
                    myFishes.add(new Shark(3,rand.nextInt(WIDTH-15)+1,i));
                    break;
            }

        }

        System.out.print(ANSI_CLS + ANSI_HOME);
        GameLoop(myAquarium,myFishes);
    }


    private static void GameLoop(Aquarium myAquarium,ArrayList<Fish> myFishes) throws InterruptedException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String line = "";


        while (!line.equalsIgnoreCase("quit")) {
            Thread.sleep(SPEED, 0);
            myAquarium.DrawAquarium(myFishes);
            System.out.print(ANSI_HOME);
            System.out.flush();

            for(int x=1;x<myFishes.size();x++){
               myFishes.get(x).Move(WIDTH,HEIGHT);
            }

            try {
                if(in.ready()){
                    line = in.readLine();
                    System.out.print(ANSI_CLS);
                    System.out.flush();
                }

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
