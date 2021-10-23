package com.gdstruct.module6;

import java.util.Random;

public class Main {
    private static Random random = new Random();

    public static void main(String[] args) {
        int numbers[] = { 53, 11, 13, 19, 7, 27, 49, 50, -79, 82};

        System.out.println(kindGachaSearch(numbers, 82));
        System.out.println(kindGachaSearch(numbers, 33));

    }

    //the gacha is kind, it won't check the same item again and again...
    public static int kindGachaSearch (int[] input, int value)
    {
        int start = 0;
        int end = input.length - 1;
        int rand = random.nextInt(input.length);

        while (start <= end)
        {
            if (input[rand] == value)
            {
                return rand;
            }
            //if it's not equal
            else
            {
                //swap it with the one in the last index
                int temp = input[rand];
                input[rand] = input[end];
                input[end] = temp;

                //exclude the ones that are put in the back
                end -= 1;
            }
        }
        return -1;
    }
}
