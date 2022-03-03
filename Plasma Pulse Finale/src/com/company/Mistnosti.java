package com.company;

import java.util.ArrayList;

public class Mistnosti {
    int here;
    String name;
    ArrayList<Integer> cango = new ArrayList<Integer>();
    boolean svetlo = false;
    boolean prohledano = false;
    boolean key1 = false;
    boolean key2 = false;
    boolean rukavice = false;

    Mistnosti(int a, String name, ArrayList<Integer> cango) {
        this.name = name;
        this.here = a;
        this.cango.addAll(cango);
    }

    static void rozmistKliceRukavice(ArrayList<Mistnosti> rooms) {
        int key1 = (int) (Math.random() * 8);
        int key2 = (int) (Math.random() * 8);
        while (key1 == key2) {
            key2 = (int) (Math.random() * 8);
        }
        int rukavice = (int) (Math.random() * 8);
        while (rukavice == key1 || rukavice == key2) {
            rukavice = (int) (Math.random() * 8);
        }
        rooms.get(key1).key1 = true;
        rooms.get(key2).key2 = true;
        rooms.get(rukavice).rukavice = true;
    }
}