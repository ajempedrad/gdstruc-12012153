package com.gdstruct.module7;

public class Main {

    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.insert(25);
        tree.insert(13);
        tree.insert(27);
        tree.insert(55);
        tree.insert(3);
        tree.insert(19);
        tree.insert(-4);
        tree.insert(77);

        //tree.traverseInOrder();
        tree.traverseInOrderDescending();

       /* System.out.println(tree.get(25));
        System.out.println(tree.get(44));
        System.out.println(tree.get(233));*/

        System.out.println("Min: " + tree.getMin());
        System.out.println("Max: " + tree.getMax());
    }
}
