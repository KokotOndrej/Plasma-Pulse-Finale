package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main extends Funkce {
    static int heresave = 0;
    static int here = 0;
    static int inv = 0;
    static boolean rukavice = false;
    static ArrayList<Mistnosti> rooms = new ArrayList<>(List.of(new Mistnosti(0, "ložnice", new ArrayList<>(List.of(6))), new Mistnosti(1, "obývák", new ArrayList<>(List.of(6, 2))), new Mistnosti(2, "kuchyně", new ArrayList<>(List.of(6, 1))), new Mistnosti(3, "koupelna", new ArrayList<>(List.of(4))), new Mistnosti(4, "pokoj", new ArrayList<>(List.of(6, 3, 5))), new Mistnosti(5, "záchod", new ArrayList<>(List.of(4, 5))), new Mistnosti(6, "chodba", new ArrayList<>(List.of(7, 4, 0, 1))), new Mistnosti(7, "pokoj pro hosty", new ArrayList<>(List.of(6)))));

    public static void main(String[] args) {
        new JStuff();
        Mistnosti.rozmistKliceRukavice(rooms);
        print(napoveda);
        while(here!=69){
            print("Jsi v: " + rooms.get(here).name);
            System.out.print("Chceš " + (rooms.get(here).svetlo ? "zhasnout (10)" : "rozsvitit (11)") + ", nebo se přesunout do: ");
            printArray(rooms, here);
            here = skenInput(rooms, here);
            switch(here){
                case 69:
                    print("Máš " + inv + " klíčů. " + (rukavice ? "Máš rukavice." : "Rukavice zatím nemáš."));
                    here = heresave;
                    break;
                case 420:
                    print(napoveda);
                    here = heresave;
                    break;
                case 69420:
                    print("Ok konec.");
                    System.exit(0);
                    break;
            }
        }


    }
}
