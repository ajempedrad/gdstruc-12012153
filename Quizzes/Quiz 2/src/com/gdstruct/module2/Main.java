package com.gdstruct.module2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Player asuna = new Player(1, "Asuna", 100);
        Player lethalBacon = new Player(2, "LethalBacon", 205);
        Player hpDeskjet = new Player(3, "HPDeskjet", 34);

        PlayerLinkedList playerLinkedList = new PlayerLinkedList();

        playerLinkedList.addToFront(asuna);
        playerLinkedList.addToFront(lethalBacon);
        playerLinkedList.addToFront(hpDeskjet);

        playerLinkedList.printList();

        //testing remove
        playerLinkedList.removeFront();
        playerLinkedList.printList();

        //testing contain
        System.out.println(playerLinkedList.contains(new Player(2, "LethalBacon", 205)));
        System.out.println(playerLinkedList.contains(new Player(2, "LethalBacon", 200)));

        //testing indexOf
        System.out.println(playerLinkedList.indexOf(new Player(1, "Asuna", 100)));
        System.out.println(playerLinkedList.indexOf(new Player(2, "LethalBacon", 205)));
        System.out.println(playerLinkedList.indexOf(new Player(3, "HPDeskjet", 34)));
    }
}
