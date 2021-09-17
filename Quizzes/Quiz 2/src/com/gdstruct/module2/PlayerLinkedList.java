package com.gdstruct.module2;

public class PlayerLinkedList {
    private PlayerNode head;
    private int size = 0;

    public void addToFront(Player player)
    {
        PlayerNode playerNode = new PlayerNode(player);
        playerNode.setNextPlayer(head);
        playerNode.setPreviousPlayer(null);

        //previous player of head is set to the new one
        if (head != null)
        {
            head.setPreviousPlayer(playerNode);
        }

        head = playerNode;

        size++;
    }

    public void removeFront()
    {
        //store current head in temp
        PlayerNode temp = head;
        temp.setNextPlayer(head.getNextPlayer());

        //move the head to the next item
        head = temp.getNextPlayer();
        head.setPreviousPlayer(null);

        size--;
    }

    public void printList()
    {
        System.out.println("Size: " + size);

        //print based on next nodes
        PlayerNode current = head;
        System.out.print("Ordered By Next Nodes: \nHEAD -> ");

        while (current != null)
        {
            System.out.print(current.getPlayer());
            System.out.print(" -> ");
            current = current.getNextPlayer();
        }
        System.out.println("null");

        //print based on previous nodes
        current = head;
        for (int i = 0; i < size - 1; i++)
        {
            current = current.getNextPlayer();
        }

        System.out.print("Ordered By Previous Nodes: \nEND -> ");
        while (current != null)
        {
            System.out.print(current.getPlayer());
            System.out.print(" -> ");
            current = current.getPreviousPlayer();
        }
        System.out.println("null\n");
    }

    public boolean contains(Player player)
    {
        PlayerNode current = head;

        while (current != null)
        {
            if (player.equals(current.getPlayer()))
            {
                return true;
            }
            current = current.getNextPlayer();
        }
        return false;
    }

    public int indexOf(Player player)
    {
        int index = 0;
        PlayerNode current = head;

        for (int i = 0; i < size; i++)
        {
            if (player.equals(current.getPlayer()))
            {
                return i;
            }
            current = current.getNextPlayer();
        }

        return -1;
    }
}
