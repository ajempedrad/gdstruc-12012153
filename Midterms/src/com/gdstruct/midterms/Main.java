package com.gdstruct.midterms;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    enum Commands {Draw, Discard, Retrieve};
    private static Random random = new Random();

    public static void main(String[] args)
    {
        CardStack playerDeck = new CardStack();
        CardStack discardPile = new CardStack();
        LinkedList<Card> hand = new LinkedList<>();

        createDeck(playerDeck);

        Scanner pause = new Scanner(System.in);

        while (!playerDeck.isEmpty())
        {
            act(hand, playerDeck, discardPile);

            System.out.println("Number of cards in Player Deck:" + playerDeck.getSize());
            System.out.println("Number of cards in Discard Pile:" + discardPile.getSize());
            System.out.println("Cards at hand: " + hand.toString());
            pause.nextLine();
        }
        System.out.println("There are no more cards in Player Deck");

    }

    public static void createDeck(CardStack deck)
    {
        //list of card names
        String[] cardNames = {"Dragon", "Griffin", "Unicorn" , "Pegasus", "Cerberus", "Jackalope", "Sphinx" , "Hippogriff", "Kelpie", "Manticore"};

        int randomName;

        //pushes 30 cards with random names
        for (int i = 0; i < 30; i++)
        {
            randomName = random.nextInt(10);
            deck.push(new Card(i+1, cardNames[randomName]));
        }
    }

    //get card from player deck or discard pile
    public static void getCard(CardStack deck, LinkedList<Card> hand, int amount)
    {
        for (int i = 0; i < amount; i++)
        {
            if (deck.isEmpty())
            {
                System.out.println("There are not enough cards in the pile.. obtaining all from pile");
                break;
            }

            hand.addFirst(deck.peek());
            deck.pop();
        }
    }

    //put card/s in the discard pile
    public static void discard(CardStack pile, LinkedList<Card> hand, int amount)
    {
        for (int i = 0; i < amount; i++)
        {
            if (hand.isEmpty())
            {
                System.out.println("There are not enough cards at hand... discarding all at hand");
                break;
            }
            pile.push(hand.getFirst());
            hand.removeFirst();
        }
    }

    //get random command
    public static Commands getCommand()
    {
        Commands commands[] = Commands.values();
        int length = commands.length;
        int command = random.nextInt(length);
        return commands[command];
    }

    public static void act(LinkedList<Card> hand, CardStack deck, CardStack pile)
    {
        int amount = random.nextInt(5) + 1;
        Commands command = getCommand();
        System.out.println("Command: " + command + " " + amount + " cards");
        switch(command)
        {
            case Draw:
                getCard(deck, hand, amount);
                break;
            case Discard:
                if (hand.isEmpty())
                {
                    System.out.println("You currently have no cards to discard");
                    break;
                }
                discard(pile, hand, amount);
                break;
            case Retrieve:
                if (pile.isEmpty())
                {
                    System.out.println("There are currently no cards to retrieve from the discard pile");
                    break;
                }
                getCard(pile, hand, amount);
                break;
            default:
                break;

        }
        System.out.println();
    }
}
