package com.gdstruct.module5;

public class Main {

    public static void main(String[] args) {

        Player ploo = new Player(114, "Plooful", 135);
        Player wardell = new Player(536, "TSM wardell", 648);
        Player deadlyJimmy = new Player(32, "DeadlyJimmy", 34);
        Player subroza = new Player(4931, "Subroza", 684);
        Player anniDro = new Player(6919, "C9 Annie", 593);

        SimpleHashTable hashtable = new SimpleHashTable();
        hashtable.put(ploo.getUserName(), ploo);
        hashtable.put(wardell.getUserName(), wardell);
        hashtable.put(deadlyJimmy.getUserName(), deadlyJimmy);
        hashtable.put(subroza.getUserName(), subroza);
        hashtable.put(anniDro.getUserName(), anniDro);

        hashtable.printHashtable();
        System.out.println(hashtable.get("Subroza"));

        System.out.println("\nRemoving: " + hashtable.remove("Subroza"));
        hashtable.printHashtable();
        System.out.println(hashtable.get("Subroza"));
    }
}
