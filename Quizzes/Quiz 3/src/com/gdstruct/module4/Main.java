package com.gdstruct.module4;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
	ArrayQueue queue = new ArrayQueue(20);

    int round = 0;

    while(round != 10)
    {
        //start when there's at least 5
        if(queue.size() >= 5)
        {
            round++;
            System.out.println("\nRound: " + round);
            startGame(queue);
        }

        if (round == 10)
        {
            System.out.println("10 games completed!");
            break;
        }

        queuePeople(queue);
        System.out.println("\nPlayers in queue:");
        queue.printQueue();
        scanner.nextLine();
    }

    }

    public static void queuePeople(ArrayQueue queue)
    {
        int randomPlayer = random.nextInt(20) + 1;
        int x = random.nextInt(7) + 1;


        for (int i = 0; i < x; i++)
        {
            //avoid duplicate player numbers
            while (queue.checkEqual(randomPlayer))
            {
                randomPlayer = random.nextInt(20) + 1;
            }

            queue.add(new Player(randomPlayer, "Player " + randomPlayer));
        }
    }

    public static void startGame(ArrayQueue queue)
    {
        for (int i = 0; i < 5; i++)
        {
            System.out.println("Popped player: " + queue.remove());
        }

        System.out.println("\nPlayers left: ");
        queue.printQueue();
        scanner.nextLine();
    }
}
