package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Funkce<univerzalniTyp> {
    static Scanner sken = new Scanner(System.in);
    static Scanner sken2 = new Scanner(System.in);
    static int[] allRooms = {0, 1, 2, 3, 4, 5, 6, 7};
    static String napoveda = "Tvůj cíl je najít 2 náhodně rozmístěné klíče, ale nesmíš najít hřebík.\nMůžeš taky najít rukavice, ty tě před hřebíkem ochrání.\nMístnosti můžeš prohledávat jenom když je tam rozsvíceno\nPro stav inventáře napíš '69', pro nápovědu '420'\nPro konec napiš '69420'\n";

    static <univerzalniTyp> void print(univerzalniTyp a) {
        System.out.println(a);
    }

    static int skenInput(ArrayList<Mistnosti> rooms, int here) {
        int a = -1;
        boolean x = true;
        boolean y = true;
        loop:
        while (x) {
            try {
                a = sken.nextInt();
                for (int b : rooms.get(here).cango) {
                    if (a == b) {
                        break loop;
                    }
                }
                if (a == 69 || a == 420 || a == 69420 || a == (rooms.get(here).svetlo ? 10 : 11) || (!rooms.get(here).prohledano && rooms.get(here).svetlo ? a == 22 : a == 69)) {
                    x = false;
                }
                if (x) {
                    if (a == 22 && rooms.get(here).prohledano) {
                        print(rooms.get(here).svetlo ? "Už jsi to tu prohledal." : "Je tu zhasnuto, ale stejně už jsi to tu prohledal.");
                    } else if (a == 22 && !rooms.get(here).svetlo) {
                        print("Je tu zhasnuto, ale když si tu rozsvítíš, můžeš to tu prohledat.");
                    } else if (a == 10) {
                        print("Jak chceš zhasnout v zhasnuté místnosti xd.");
                    } else if (a == 11) {
                        print("Jak chceš rozsvítit v rozsvícené místnosti xd.");
                    } else {
                        isItThere(allRooms, a);
                    }
                    System.out.print("Povolený input je: ");
                    allowedPrint(rooms.get(here).cango, y);
                    continue;
                }
                if (a == 10) {
                    rooms.get(here).svetlo = false;
                    print("Ok zhasnuto");
                    x = true;
                } else if (a == 11) {
                    rooms.get(here).svetlo = true;
                    print("Ok rozsvíceno");
                    x = true;
                }
                if (a == 22) {
                    x = true;
                    rooms.get(here).prohledano = true;
                    print("Ok prohledávám.");
                    print("0%");
                    Thread.sleep(1000);
                    print("33%");
                    Thread.sleep(1000);
                    print("66%");
                    Thread.sleep(1000);
                    print("100%");
                    if (rooms.get(here).key1) {
                        Main.inv++;
                        print("našel jsi klíč");
                    }
                    if (rooms.get(here).key2) {
                        Main.inv++;
                        print("Našel jsi klíč");
                    }
                    if (Main.inv == 2) {
                        print("Našel jsi všechny klíče, hra končí");
                        System.exit(0);
                    }
                    if (rooms.get(here).rukavice) {
                        print("Našel jsi rukavice");
                        Main.rukavice = true;
                    }
                    if (!rooms.get(here).key1 && !rooms.get(here).key2 && !rooms.get(here).rukavice) {
                        int hrebik = (int) (Math.random() * 3);
                        if (!Main.rukavice && hrebik == 0) {
                            print("Našel jsi hřebík, hra končí.");
                            System.exit(0);
                        } else if (hrebik == 0) {
                            print("Našel jsi hřebík, ale rukavice tě ochránily.");
                        } else {
                            print("Nenašel jsi nic");
                        }
                    }
                }
            } catch (Exception e) {
                print("Zadal jsi String, double, nebo příliš velké číslo. Zkus to znovu");
                sken.nextLine();
            }
        }
        if (a != 69420 && a != 420 && a != 69) {
            Main.heresave = a;
        }
        return a;
    }

    static double skenDouble() {
        Double a = null;
        while (a == null) {
            try {
                a = sken.nextDouble();
            } catch (Exception e) {
                print("Zadal jsi String. Zkus to znovu.");
                sken.nextLine();
            }
        }
        return a;
    }

    static String sken() {
        return sken2.nextLine();
    }

    static void allowedPrint(ArrayList<Integer> povoleny, boolean y) {
        StringBuilder b = new StringBuilder();
        for (int a : povoleny) {
            b.append(a + ", ");
        }
        b.deleteCharAt(b.length() - 1);
        b.deleteCharAt(b.length() - 1);
        print(b + (y ? (Main.rooms.get(Main.here).svetlo ? ", 10" : ", 11") : "") + (Main.rooms.get(Main.here).prohledano && Main.rooms.get(Main.here).svetlo ? "" : ", 22") + ", 69, 420 a 69420.");
    }

    static void printArray(ArrayList<Mistnosti> rooms, int here) {
        StringBuilder a = new StringBuilder();
        for (int i = 0; i < rooms.get(here).cango.size(); i++) {
            a.append(rooms.get(rooms.get(here).cango.get(i)).name + " (" + rooms.get(here).cango.get(i) + "), ");
        }
        a.deleteCharAt(a.length() - 1);
        a.deleteCharAt(a.length() - 1);
        a.append(".");
        print(String.valueOf(a));
    }

    static void isItThere(int[] a, int b) {
        for (int c : a) {
            if (c == b && b == Main.here) {
                print("Už tady jsi lmao.");
            } else if (c == b) {
                print("Do zadané místnoti odsud jít nemůžeš.");
            }
        }
    }


}